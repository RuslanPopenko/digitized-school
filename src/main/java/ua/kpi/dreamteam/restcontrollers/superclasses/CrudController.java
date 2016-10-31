package ua.kpi.dreamteam.restcontrollers.superclasses;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * Created by ruslan on 27.03.15.
 */
public interface CrudController<T, ID extends Serializable> {

    // Getting entity by id
    Object get(ID id, HttpServletResponse response, WebRequest webRequest) throws Exception;

    //Getting list of entities
    Object getAll(WebRequest webRequest, HttpServletResponse response, Model model) throws Exception;

    Object create(T entity,
                  HttpServletResponse response,
                  BindingResult bindingResult,
                  WebRequest webRequest) throws Exception;

    // Updating entity
    Object update(ID id,
                  HttpServletResponse response,
                  T entity,
                  BindingResult bindingResult,
                  WebRequest webRequest) throws Exception;

    //Deleting entity
    Object delete(ID id,
                  HttpServletResponse response,
                  WebRequest webRequest) throws Exception;

}
