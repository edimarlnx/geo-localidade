package org.jsoll.geo.localidade.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cidade")
@NamedQueries(
        @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c order by c.nome asc")
)
public class Cidade implements BaseModel<Integer> {

    @Id
    @Column(name = "cidade_id")
    @Getter @Setter
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "unidade_federacao_id")
    @Getter @Setter
    private Uf uf;

    @Column(name = "nome")
    @Size(max = 100)
    @Getter @Setter
    private String nome;

    @Column(name = "nome_abrev")
    @Size(max = 50)
    @Getter @Setter
    private String nomeAbrev;

    @Column(name = "geocodigo")
    @Size(max = 15)
    @Getter @Setter
    private String geocodigo;

}