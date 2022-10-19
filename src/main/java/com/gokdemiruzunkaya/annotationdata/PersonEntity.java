package com.gokdemiruzunkaya.annotationdata;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull

    private long id;
}
