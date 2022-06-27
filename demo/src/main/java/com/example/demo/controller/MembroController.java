package com.example.demo.controller;

import com.example.demo.Service.MembroService;
import com.example.demo.model.Membro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/membros")

public class MembroController {

    private final MembroService membroService;

    @Autowired
    public MembroController(MembroService membroService) {
        this.membroService = membroService;
    }

    @PostMapping
    public ResponseEntity<Membro> store(@Valid @RequestBody Membro membro) {
        return ResponseEntity.ok(membroService.store(membro));
    }

    @GetMapping
    public ResponseEntity<List<Membro>> index() {
        return ResponseEntity.ok(membroService.index());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Membro>> show(@PathVariable Long id) {
        return ResponseEntity.ok(membroService.show(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Membro> update(@PathVariable Long id, @Valid @RequestBody Membro membro) {
        Optional<Membro> optionalMembro = membroService.show(id);

        if (optionalMembro.isPresent()) {
            membro.setId(id);
            return ResponseEntity.ok(membroService.update(membro));
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Membro> destroy(@PathVariable Long id) {
        membroService.destroy(id);
        return ResponseEntity.ok(null);
    }
}
