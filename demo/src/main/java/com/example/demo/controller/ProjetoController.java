package com.example.demo.controller;

import com.example.demo.Service.ProjetoService;
import com.example.demo.model.Projeto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;


    @PostMapping
    public ResponseEntity<Projeto> store(@Valid @RequestBody Projeto projeto) {
        return ResponseEntity.ok(projetoService.store(projeto));
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> index() {
        return ResponseEntity.ok(projetoService.index());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Projeto>> show(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.show(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> update(@PathVariable Long id, @Valid @RequestBody Projeto projeto) {
        Optional<Projeto> optionalProjeto = projetoService.show(id);

//        if (Projeto.isPresent()) {
//            projeto.setId(id);
//            return ResponseEntity.ok(projetoService.update(projeto));
//        } else {
//            return null;
//        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Projeto> destroy(@PathVariable Long id) {
        projetoService.destroy(id);
        return ResponseEntity.ok(null);
    }
}
