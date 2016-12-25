package org.jsoll.geo.localidade.service;

import org.jsoll.geo.localidade.model.Cidade;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.TypedQuery;
import java.util.List;

@Named
@Singleton
public class CidadeService extends GenericService<Cidade> {

    @Override
    public List<Cidade> findAll() {
        TypedQuery<Cidade> query = getEntityManager().createNamedQuery("Cidade.findAll", Cidade.class);
        return query.getResultList();
    }

    public List<Cidade> findByUf(String uf) {
        TypedQuery<Cidade> query = getEntityManager().createNamedQuery("Cidade.findByUf", Cidade.class)
                .setParameter("uf", uf);
        return query.getResultList();
    }
}
