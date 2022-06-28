package com.example.demo;


import com.example.demo.Service.PessoaService;
import com.example.demo.Service.ProjetoService;
import com.example.demo.model.Pessoa;
import com.example.demo.model.Projeto;
import com.example.demo.model.Risco;
import com.example.demo.model.Status;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Optional;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)


public class ProjetoTest {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private PessoaService pessoaService;
    private final Faker faker = new Faker(new Locale("pt-br"));

    @Test
    void store() {
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(faker.name().name());
        pessoa.setDataNascimento(faker.date().birthday());
        pessoa.setCpf(faker.random().toString());
        pessoa.setFuncionario(faker.random().nextBoolean());
        Pessoa pessoaCriada = pessoaService.store(pessoa);

        Projeto projeto = new Projeto();

        projeto.setNome(faker.name().name());
        projeto.setDataInicio(faker.date().birthday());
        projeto.setFimData(faker.date().birthday());
        projeto.setPrivisaoFimData(faker.date().birthday());
        projeto.setDescricao(faker.random().toString());

        projeto.setOrcamento(BigDecimal.valueOf(faker.random().nextDouble()));
        projeto.setStatus(Status.ANALSE);
        projeto.setRisco(Risco.ALTO_RISCO);
        projeto.setGerente(pessoaCriada);

        Projeto resultdb = projetoService.store(projeto);
        Assertions.assertEquals(projeto, resultdb);

    }


}
