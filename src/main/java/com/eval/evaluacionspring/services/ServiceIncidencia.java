package com.eval.evaluacionspring.services;

import com.eval.evaluacionspring.pojos.Incidencia;
import com.eval.evaluacionspring.repositories.RepositoryIncidencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceIncidencia {

    @Autowired
    private RepositoryIncidencia repositoryIncidencia;


    public Incidencia save(Incidencia incidencia) {
        return repositoryIncidencia.save(incidencia);
    }

    public Optional<Incidencia> findById(Long id) {
        return repositoryIncidencia.findById(id);
    }

    public boolean delete (Incidencia incidencia) {
        try {
            repositoryIncidencia.delete(incidencia);
            return true;
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean existsByFechaInicio(Date fecha) {
        return repositoryIncidencia.existsByFecha(fecha);
    }

    public List<Incidencia> findByFecha(Date fecha) {
        return repositoryIncidencia.findByFecha(fecha);
    }

    public List<Incidencia> findAll() {
        return repositoryIncidencia.findAll();
    }
}
