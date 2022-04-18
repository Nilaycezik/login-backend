package com.example.RestGet.dao;

import org.springframework.stereotype.Repository;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDao<T> {
    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> persistentClass;

    protected BaseDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T create(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public T delete(Serializable id) {
        T entityObject = (T) findById(id);
        entityManager.remove(entityObject);
        return entityObject;
    }

    public List<T> findAll() {
        Query query = entityManager.createQuery("select e from " + persistentClass.getSimpleName() + " e order by id desc");
        return query.getResultList();
    }

    public List findAll(Class<?> classType) {
        Query query = entityManager.createQuery("select e from " + classType.getSimpleName() + " e");
        return query.getResultList();
    }


    public T findById(Serializable id) {
        return entityManager.find(persistentClass, id);
    }

    public Object findById(Serializable id, Class persistentClassType) {
        return entityManager.find(persistentClassType, id);
    }

    public long getCount() {
        Query query = entityManager.createQuery("select count(e.id) from " + persistentClass.getSimpleName() + " e");
        return ((Number) query.getSingleResult()).longValue();
    }

    public long findMax() {
        Query query = entityManager.createQuery("select max(e.id)+1 from " + persistentClass.getSimpleName() + " e");
        return ((Number) query.getSingleResult()).longValue();
    }

    public void refresh(T entity) {
        entityManager.refresh(entity);
    }

}