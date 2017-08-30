package org.jsoll.geo.localidade.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pais_ibge")
@NamedQueries(
        @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p order by p.nome asc", hints = {
                @QueryHint(name = QueryHints.CACHEABLE, value = "true"),
                @QueryHint(name = QueryHints.CACHE_REGION, value = "Pais.findAll"),
        })
)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Pais implements BaseModel<Integer> {

    @Id
    @Column(name = "pais_ibge_id")
    @Getter @Setter
    private Integer id;

    @Column(name = "nome")
    @Size(max = 100)
    @Getter @Setter
    private String nome;

    @Column(name = "codiso3166")
    @Size(max = 3)
    @Getter @Setter
    private String codigoIso;

}
