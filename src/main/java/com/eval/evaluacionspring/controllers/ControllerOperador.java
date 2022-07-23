package com.eval.evaluacionspring.controllers;

import com.eval.evaluacionspring.pojos.Incidencia;
import com.eval.evaluacionspring.pojos.Operador;
import com.eval.evaluacionspring.services.ServiceOperador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/operador")
public class ControllerOperador {

    @Autowired
    private ServiceOperador serviceOperador;
    private Map<String, String> response;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Operador operador) {
        response = new HashMap<>();
        Optional<Operador> saveOp = Optional.ofNullable(serviceOperador.save(operador));
        return new ResponseEntity<>(saveOp.get(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> save(@RequestBody @PathVariable("id") Long id) {
        response = new HashMap<>();
        Optional<Operador> byId = serviceOperador.findById(id);
        if (byId.isPresent()) {
            return new ResponseEntity<>(byId.get(), HttpStatus.ACCEPTED);
        }
        response.put("error", "no se ha podido encontrar el id de el operador");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public List<Operador> findAll() {
        return serviceOperador.findAll();
    }


}
