package com.vocacional.sitapivocacional.service.impl;

import com.vocacional.sitapivocacional.model.Categoria;
import com.vocacional.sitapivocacional.repository.CategoriaRepository;
import com.vocacional.sitapivocacional.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria addCategoria(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    @Override
    public Categoria updateCategoria(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    @Override
    public Set<Categoria> getAllCategoria() {
        return new LinkedHashSet<>(this.categoriaRepository.findAll());
    }

    @Override
    public Categoria getCategoria(Long categoriaId) {
        return this.categoriaRepository.findById(categoriaId).orElse(null);
    }

    @Override
    public void eliminarCategoria(Long categoriaId) {
        this.categoriaRepository.deleteById(categoriaId);
    }
}
