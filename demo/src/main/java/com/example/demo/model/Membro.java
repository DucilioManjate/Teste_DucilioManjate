package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Membro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Projeto projeto;

    @OneToOne
    private Pessoa pessoa;

}
