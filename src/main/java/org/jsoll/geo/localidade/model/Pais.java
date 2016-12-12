package org.jsoll.geo.localidade.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pais")
@NamedQueries(
        @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p order by p.nome asc")
)
public class Pais implements BaseModel<Integer> {

    @Id
    @Column(name = "pais_id")
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
