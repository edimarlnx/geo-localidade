package org.jsoll.geo.localidade.service;

import org.jsoll.geo.localidade.model.Uf;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.TypedQuery;
import java.util.List;

@Named
@Singleton
public class UfService extends GenericService<Uf> {

    @Override
    public List<Uf> findAll() {
        TypedQuery<Uf> query = getEntityManager().createNamedQuery("Uf.findAll", Uf.class);
        return query.getResultList();
    }

    public Uf findById(Integer id) {
        return getEntityManager().find(Uf.class, id);
    }

}
