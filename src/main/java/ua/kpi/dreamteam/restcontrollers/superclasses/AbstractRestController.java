package ua.kpi.dreamteam.restcontrollers.superclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import ua.kpi.dreamteam.entities.superclasses.JpaEntity;
import ua.kpi.dreamteam.services.superclasses.GenericService;
import ua.kpi.dreamteam.utils.StaticUtls;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by root on 27.03.15.
 */
public abstract class AbstractRestController<T extends JpaEntity<ID>, ID extends Serializable, SERVICE_TYPE extends GenericService<T, ID>> implements CrudController<T, ID> {

    static final Logger logger = LogManager.getLogger(AbstractRestController.class.getName());

    @Autowired
    private SERVICE_TYPE service;

    // Getting entity by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Object get(@PathVariable("id") ID id) throws Exception {
        T entity = service.find(id);
        return entity;
    }

    //Getting list of entities
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Object getAll(WebRequest webRequest, HttpServletResponse response, Model model) throws Exception {
        List<T> result = service.findAll();
        return result;
    }

    //Creating entity
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Object create(@RequestBody T entity,
                                       HttpServletResponse response,
                                       BindingResult bindingResult, WebRequest webRequest) throws Exception {

        entity.setId(null);

        return service.save(entity);

    }

    @RequestMapping(value = "/saveall", method = RequestMethod.POST)
    public @ResponseBody Object saveAll(@RequestBody Iterable<T> entities,
                                        HttpServletResponse response,
                                        WebRequest webRequest, @RequestParam(required = false) Boolean full) throws Exception {

        for (T entity : entities) {
            entity.setId(null);
        }

        Iterable<T> result = service.save(entities);

        return result;
    }


    // Updating entity
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Object update(@PathVariable("id") ID id, HttpServletResponse response, @RequestBody(required = false) T entity, BindingResult bindingResult, WebRequest webRequest) throws Exception {
        T existsEntity = getService().find(id);

        if (existsEntity == null) {
            bindingResult.reject(null, "Try update non exist entity");
            throw new MethodArgumentNotValidException(null, bindingResult);
        }

        entity.setId(null);

        boolean isCopied = false;

        try {
            isCopied = StaticUtls.nullAwareBeanCopy(existsEntity, entity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if (isCopied) {
            existsEntity = service.save(existsEntity);
        }

        return existsEntity;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") ID id, HttpServletResponse response, WebRequest webRequest) throws Exception {
        T entity = service.find(id);
        if (entity == null) {
            return null;
        }
        service.delete(id);
        return entity;
    }

    // Getters & Setters
    //------------------------------------------------------------------------------------------------------------------
    public SERVICE_TYPE getService() {
        return service;
    }

    public void setService(SERVICE_TYPE service) {
        this.service = service;
    }


}
