package org.jsoll.geo.localidade.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "unidade_federacao")
@NamedQueries(
        @NamedQuery(name = "Uf.findAll", query = "SELECT u FROM Uf u order by u.nome asc")
)
public class Uf implements BaseModel<Integer> {

    @Id
    @Column(name = "unidade_federacao_id")
    @Getter @Setter
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pais_id")
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
