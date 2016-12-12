package org.jsoll.geo.localidade.service;

import org.jsoll.geo.localidade.model.Pais;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.TypedQuery;
import java.util.List;

@Named
@Singleton
public class PaisService extends GenericService<Pais> {

    @Override
    public List<Pais> findAll() {
        TypedQuery<Pais> query = getEntityManager().createNamedQuery("Pais.findAll", Pais.class);
        return query.getResultList();
    }
}
