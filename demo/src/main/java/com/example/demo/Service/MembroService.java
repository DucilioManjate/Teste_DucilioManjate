package com.example.demo.Service;

import com.example.demo.model.Membro;
import com.example.demo.repository.MembroRepository;
import com.example.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembroService {
    private final MembroRepository membroRepository;

    @Autowired
    public MembroService(MembroRepository membroRepository) {
        this.membroRepository = membroRepository;
    }

    public Membro store(Membro membro) {
        return membroRepository.save(membro);
    }

    public List<Membro> index() {
        return membroRepository.findAll();
    }

    public Optional<Membro> show(Long id) {
        return membroRepository.findById(id);
    }

    public Membro update(Membro membro) {
        return membroRepository.save(membro);
    }

    public void destroy(Long id) {
        Optional<Membro> optionalMembro = this.show(id);

        if (optionalMembro.isPresent()) {
            membroRepository.deleteById(id);
        }
    }
}
