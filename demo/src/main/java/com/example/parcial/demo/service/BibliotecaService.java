package com.example.parcial.demo.service;

import com.example.parcial.demo.entity.Biblioteca;
import com.example.parcial.demo.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BibliotecaService {
    @Autowired
    private BibliotecaRepository repository;

    public List<Biblioteca> listarTodas() {
        return repository.findAll();
    }

    public Biblioteca guardar(Biblioteca biblioteca) {
        return repository.save(biblioteca);
    }

    public Biblioteca obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}