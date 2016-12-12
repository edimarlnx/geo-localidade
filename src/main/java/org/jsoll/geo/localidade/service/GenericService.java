package org.jsoll.geo.localidade.service;

import org.jsoll.geo.localidade.model.BaseModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class GenericService<T extends BaseModel> implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public abstract List<T> findAll();
}
