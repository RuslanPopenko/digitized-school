package ua.kpi.dreamteam.services.superclasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractService<T, ID extends Serializable, REPOSITORY_TYPE extends JpaRepository<T, ID>> implements GenericService<T, ID> {

    @Autowired
    protected REPOSITORY_TYPE repo;

    @Override
    @Transactional
    public T save(T entity) {
        return repo.saveAndFlush(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public T find(ID id) {
        return repo.findOne(id);
    }

    @Override
    public boolean exist(ID id) {
        return repo.exists(id);
    }

    @Override
    @Transactional
    public void delete(ID id) {
        repo.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return repo.findAll();
    }

    @Transactional
    public T saveWithoutFlush(T entity) {
        return repo.save(entity);
    }

    @Transactional
    public void flush() {
        repo.flush();
    }

    @Override
    @Transactional
    public Iterable<T> save(Iterable<T> entities) {
        return repo.save(entities);
    }

    public REPOSITORY_TYPE getRepo() {
        return repo;
    }

    public void setRepo(REPOSITORY_TYPE repo) {
        this.repo = repo;
    }

}