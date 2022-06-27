package com.example.demo.repository;
import com.example.demo.model.Membro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembroRepository extends JpaRepository<Membro, Long> {
}
