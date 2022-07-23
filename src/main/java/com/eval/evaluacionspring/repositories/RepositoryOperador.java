package com.eval.evaluacionspring.repositories;

import com.eval.evaluacionspring.pojos.Operador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryOperador extends JpaRepository<Operador, Long> {
}
