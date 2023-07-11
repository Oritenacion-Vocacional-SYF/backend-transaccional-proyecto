package com.vocacional.sitapivocacional.controller;

import com.vocacional.sitapivocacional.model.Usuario;
import com.vocacional.sitapivocacional.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> registarUsuario(@RequestBody Usuario usuario) throws Exception{
        System.out.println(usuario);
        return (usuarioService.addUser(usuario) != null) ? new ResponseEntity<>(usuario, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
