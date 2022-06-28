package com.example.demo.Service;


import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa store(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> index() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> show(Long id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa update(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public void destroy(Long id) {
        Optional<Pessoa> optionalPessoa = this.show(id);

        if (optionalPessoa.isPresent()) {
            pessoaRepository.deleteById(id);
        }
    }
}