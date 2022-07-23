package com.eval.evaluacionspring.repositories;

import com.eval.evaluacionspring.pojos.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryIncidencia extends JpaRepository<Incidencia, Long> {

    boolean existsByFecha(Date fecha);

    List<Incidencia> findByFecha(Date fecha);
}
