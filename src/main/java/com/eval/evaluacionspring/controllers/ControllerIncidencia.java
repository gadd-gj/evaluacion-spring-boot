package com.eval.evaluacionspring.controllers;

import com.eval.evaluacionspring.pojos.Incidencia;
import com.eval.evaluacionspring.services.ServiceIncidencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/incidencia")
public class ControllerIncidencia {

    @Autowired
    private ServiceIncidencia serviceIncidencia;

    private Map<String, String> response;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Incidencia incidencia) {
        response = new HashMap<>();
        Optional<Incidencia> saveInc = Optional.ofNullable(serviceIncidencia.save(incidencia));
        return new ResponseEntity<>(saveInc, HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public List<Incidencia> findAll(){
        return serviceIncidencia.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> save(@RequestBody @PathVariable("id") Long id) {
        response = new HashMap<>();
        Optional<Incidencia> byId = serviceIncidencia.findById(id);
        if (byId.isPresent()) {
            return new ResponseEntity<>(byId.get(), HttpStatus.ACCEPTED);
        }
        response.put("error", "no se ha podido encontrar el id de la incidencia");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/fecha")
    public ResponseEntity<?> searchByFecha(@RequestParam("fecha") @DateTimeFormat(pattern = "dd-MM-yyyy") Date fecha) {

        response = new HashMap<>();

        if (serviceIncidencia.existsByFechaInicio(fecha)) {
            List<Incidencia> findByFecha = serviceIncidencia.findByFecha(fecha);
            return new ResponseEntity<>(findByFecha, HttpStatus.OK);
        }

        response.put("error", "no existe incidencia para la fecha solicitada");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
