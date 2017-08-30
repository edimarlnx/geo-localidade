package org.jsoll.geo.localidade.service;

import org.hibernate.annotations.QueryHints;
import org.jsoll.geo.localidade.model.Pais;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.TypedQuery;
import java.util.List;

@Named
@Singleton
public class PaisService extends GenericService<Pais> {

    private static boolean FIRST_TIME_EXEC = true;

    @Override
    public List<Pais> findAll() {
        TypedQuery<Pais> query = getEntityManager().createNamedQuery("Pais.findAll", Pais.class);
        configureFirtsTimeCachedExecute(query);
        return query.getResultList();
    }

    protected void configureFirtsTimeCachedExecute(TypedQuery query) {
        if (!checkAndMarkFirstTimeExecute()) {
            return;
        }
        Object cached = query.getHints().get(QueryHints.CACHEABLE);
        if (cached != null && ((boolean) cached)) {
            query.setHint(QueryHints.CACHEABLE, false);
        }
    }

    protected boolean checkAndMarkFirstTimeExecute() {
        if (FIRST_TIME_EXEC) {
            FIRST_TIME_EXEC = false;
            return true;
        }
        return false;
    }
}
