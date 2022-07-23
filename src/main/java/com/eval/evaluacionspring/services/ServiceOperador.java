package com.eval.evaluacionspring.services;

import com.eval.evaluacionspring.pojos.Operador;
import com.eval.evaluacionspring.repositories.RepositoryOperador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOperador {

    @Autowired
    private RepositoryOperador repositoryOperador;

    public Operador save(Operador operador) {
        return repositoryOperador.save(operador);
    }

    public Optional<Operador> findById(Long id) {
        return repositoryOperador.findById(id);
    }

    public boolean delete(Operador operador) {
        try {
            repositoryOperador.delete(operador);
            return true;
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public List<Operador> findAll() {
        return repositoryOperador.findAll();
    }
}
