package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date dataInicio;
    private Date fimData;
    private Date privisaoFimData;
    private String descricao;

    private BigDecimal orcamento;


    private Risco risco;

    private Status status;

    @OneToOne
    private Pessoa gerente;

}
