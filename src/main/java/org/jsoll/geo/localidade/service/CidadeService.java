package org.jsoll.geo.localidade.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.jpa.impl.JPAQuery;
import org.jsoll.geo.localidade.model.Cidade;
import org.jsoll.geo.localidade.model.QCidade;
import org.jsoll.geo.localidade.model.QUf;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Named
@Singleton
public class CidadeService extends GenericService<Cidade> {

    @Override
    public List<Cidade> findAll() {
        TypedQuery<Cidade> query = getEntityManager().createNamedQuery("Cidade.findAll", Cidade.class);
        return query.getResultList();
    }

    public List<Cidade> findByUfByStream(String uf) {
        List<Cidade> todasCidades = findAll();
        return todasCidades.stream()
                .filter(cidade -> cidade.getUf().equals(uf))
                .collect(Collectors.toList());
    }

    public List<Cidade> findByUfByStream(String uf, String inicio) {
        QCidade qCidade = QCidade.cidade;
        final QBean<Cidade> cidadeQBean =
                Projections.fields(qCidade, qCidade.nome, qCidade.geocodigo);
        QUf qUf = qCidade.uf;
        BooleanBuilder predicate = new BooleanBuilder(qCidade.uf.nome.eq(uf));
        if (inicio != null && !inicio.isEmpty()) {
            predicate.and(qCidade.nome.startsWith(inicio));
        }
        JPAQuery<Cidade> query = new JPAQuery<>(getEntityManager())
                .select(cidadeQBean)
                .from(qCidade)
                .innerJoin(qUf)
                .where(predicate);
        return query.fetch();
    }

    public List<Cidade> findByUf(String uf) {
        TypedQuery<Cidade> query = getEntityManager().createNamedQuery("Cidade.findByUf", Cidade.class)
                .setParameter("uf", uf);
        return query.getResultList();
    }

    public Cidade findById(Integer id) {
        return getEntityManager().find(Cidade.class, id);
    }

    @Transactional
    public void salvar(Cidade cidade) {
        getEntityManager().merge(cidade);
    }
}
