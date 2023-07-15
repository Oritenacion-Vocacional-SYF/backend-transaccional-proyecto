package com.vocacional.sitapivocacional.service;

import com.vocacional.sitapivocacional.model.Categoria;

import java.util.Set;

public interface CategoriaService {

    Categoria addCategoria(Categoria categoria);

    Categoria updateCategoria(Categoria categoria);

    Set<Categoria> getAllCategoria();

    Categoria getCategoria(Long categoriaId);

    void eliminarCategoria(Long categoriaId);

}
