package com.example.demo.controller;

import com.example.demo.Service.PessoaService;
import com.example.demo.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<Pessoa> store(@Valid @RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(pessoaService.store(pessoa));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> index() {
        return ResponseEntity.ok(pessoaService.index());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> show(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.show(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {
        Optional<Pessoa> optionalPessoa = pessoaService.show(id);

        if (optionalPessoa.isPresent()) {
            pessoa.setId(id);
            return ResponseEntity.ok(pessoaService.update(pessoa));
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pessoa> destroy(@PathVariable Long id) {
        pessoaService.destroy(id);
        return ResponseEntity.ok(null);
    }




}
