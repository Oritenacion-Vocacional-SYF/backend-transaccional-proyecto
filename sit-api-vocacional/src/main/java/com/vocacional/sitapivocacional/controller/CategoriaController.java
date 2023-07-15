package com.vocacional.sitapivocacional.controller;

import com.vocacional.sitapivocacional.model.Categoria;
import com.vocacional.sitapivocacional.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<Categoria> registrarCategoria(@RequestBody Categoria categoria) {
        return (categoriaService.addCategoria(categoria) != null) ? new ResponseEntity<>(categoria,HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{categoriaId}")
    public ResponseEntity<Categoria> obtenerCategoriaId(@PathVariable Long categoriaId){
        return ResponseEntity.ok(categoriaService.getCategoria(categoriaId));
    }

    @GetMapping
    public ResponseEntity<?> listarCategorias(){
        return ResponseEntity.ok(categoriaService.getAllCategoria());
    }

    @PutMapping
    public ResponseEntity<Categoria> actualizarCategoria(@RequestBody Categoria categoria){
        return (categoriaService.updateCategoria(categoria) != null) ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{categoriaId}")
    public void eliminarCategoria(@PathVariable Long categoriaId){
        this.categoriaService.eliminarCategoria(categoriaId);
    }



}
