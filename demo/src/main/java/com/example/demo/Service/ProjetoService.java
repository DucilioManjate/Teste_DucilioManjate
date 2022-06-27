package com.example.demo.Service;


import com.example.demo.model.Projeto;

import com.example.demo.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    @Autowired
    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Projeto store(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public List<Projeto> index() {
        return projetoRepository.findAll();
    }

    public Optional<Projeto> show(Long id) {
        return projetoRepository.findById(id);
    }

    public Projeto update(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public void destroy(Long id) {
        Optional<Projeto> optionalProjeto = this.show(id);

        if (optionalProjeto.isPresent()) {
            projetoRepository.deleteById(id);
        }
    }

}
