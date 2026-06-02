package com.example.parcial.demo.controller;

import com.example.parcial.demo.entity.Biblioteca;
import com.example.parcial.demo.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bibliotecas")
@CrossOrigin(origins = "*") 
public class BibliotecaController {

    @Autowired
    private BibliotecaService service;

    @GetMapping
    public List<Biblioteca> listar() {
        return service.listarTodas();
    }

    @PostMapping
    public Biblioteca crear(@RequestBody Biblioteca biblioteca) {
        return service.guardar(biblioteca);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Biblioteca> obtener(@PathVariable Long id) {
        Biblioteca biblioteca = service.obtenerPorId(id);
        if (biblioteca == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(biblioteca);
    }

    @PutMapping("/{id}")
    public Biblioteca actualizar(@PathVariable Long id, @RequestBody Biblioteca biblioteca) {
        biblioteca.setId(id);
        return service.guardar(biblioteca);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}