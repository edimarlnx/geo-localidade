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
@Table(name = "uf_ibge")
@NamedQueries(
        @NamedQuery(name = "Uf.findAll", query = "SELECT u FROM Uf u order by u.nome asc", hints = {
            @QueryHint(name = QueryHints.CACHEABLE, value = "true"),
            @QueryHint(name = QueryHints.CACHE_REGION, value = "Uf.findAll")
        })
)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Uf implements BaseModel<Integer> {

    @Id
    @Column(name = "uf_ibge_id")
    @Getter @Setter
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pais_ibge_id")
    @Getter @Setter
    private Pais pais;

    @Column(name = "nome")
    @Size(max = 100)
    @Getter @Setter
    private String nome;

    @Column(name = "sigla")
    @Size(max = 2)
    @Getter @Setter
    private String sigla;

    @Column(name = "geocodigo")
    @Size(max = 15)
    @Getter @Setter
    private String geocodigo;

}
