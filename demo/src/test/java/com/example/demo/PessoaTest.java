package com.example.demo;

import com.example.demo.Service.PessoaService;
import com.example.demo.model.Pessoa;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PessoaTest {

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
        Pessoa resultdb = pessoaService.store(pessoa);
        Assertions.assertEquals(pessoa, resultdb);

    }
    
    @Test
    void show() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(faker.name().name());
        pessoa.setDataNascimento(faker.date().birthday());
        pessoa.setCpf(faker.random().toString());
        pessoa.setFuncionario(faker.random().nextBoolean());

        pessoaService.store(pessoa);

        Optional<Pessoa> result = pessoaService.show(pessoa.getId());
        Assertions.assertTrue(result.isPresent());
    }
    @Test
    void index() {
        List<Pessoa> before = pessoaService.index();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(faker.name().name());
        pessoa.setDataNascimento(faker.date().birthday());
        pessoa.setCpf(faker.random().toString());
        pessoa.setFuncionario(faker.random().nextBoolean());

        pessoaService.store(pessoa);

        List<Pessoa> after = pessoaService.index();
        Assertions.assertEquals(after.size(), before.size() + 1);

    }

    @Test
    void update() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(faker.name().name());
        pessoa.setDataNascimento(faker.date().birthday());
        pessoa.setCpf(faker.random().toString());
        pessoa.setFuncionario(faker.random().nextBoolean());

        Pessoa resultdb = pessoaService.store(pessoa);

        resultdb.setNome(faker.name().name());
        Pessoa updatePessoa = pessoaService.update(resultdb);
        Assertions.assertEquals(resultdb.getNome(), updatePessoa.getNome());
    }

    @Test
    void destroy() {
        List<Pessoa> before = pessoaService.index();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(faker.name().name());
        pessoa.setDataNascimento(faker.date().birthday());
        pessoa.setCpf(faker.random().toString());
        pessoa.setFuncionario(faker.random().nextBoolean());

        Pessoa resultdb = pessoaService.store(pessoa);

        resultdb.setId(resultdb.getId());
        pessoaService.destroy(resultdb.getId());

        List<Pessoa> after = pessoaService.index();
        Assertions.assertEquals(after.size(), before.size());
    }


}
