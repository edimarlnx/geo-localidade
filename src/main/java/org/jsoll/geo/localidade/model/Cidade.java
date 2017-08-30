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
@Table(name = "cidade_ibge")
@NamedQueries({
        @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c order by c.nome asc", hints = {
                @QueryHint(name = QueryHints.CACHEABLE, value = "true"),
                @QueryHint(name = QueryHints.CACHE_REGION, value = "Cidade.findAll")
        }),
        @NamedQuery(name = "Cidade.findByUf", query = "SELECT c FROM Cidade c join c.uf u WHERE u.sigla = :uf order by c.nome asc", hints = {
                @QueryHint(name = QueryHints.CACHEABLE, value = "true"),
                @QueryHint(name = QueryHints.CACHE_REGION, value = "Cidade.findByUf")
        })
    }
)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Cidade implements BaseModel<Integer> {

    @Id
    @Column(name = "cidade_ibge_id")
    @Getter @Setter
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "uf_ibge_id")
    @Getter @Setter
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Uf uf;

    @Column(name = "nome")
    @Size(max = 100)
    @Getter @Setter
    private String nome;

    @Column(name = "nome_normalizado")
    @Size(max = 100)
    @Getter @Setter
    private String nomeAbrev;

    @Column(name = "geocodigo")
    @Size(max = 15)
    @Getter @Setter
    private String geocodigo;

}
