package com.vocacional.sitapivocacional.controller;

import com.vocacional.sitapivocacional.model.Usuario;
import com.vocacional.sitapivocacional.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> registarUsuario(@RequestBody Usuario usuario) throws Exception {
        System.out.println(usuario);
        return (usuarioService.addUser(usuario) != null) ? new ResponseEntity<>(usuario, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() throws Exception {
        return new ResponseEntity<>(usuarioService.getAllUser(), HttpStatus.OK);
    }
    @GetMapping("/{username}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable String username) throws Exception{
        Usuario localUser = this.usuarioService.getUser(username);
        return (localUser != null) ? ResponseEntity.ok(localUser) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable String username)throws Exception{
        this.usuarioService.deleteUser(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/roles/{nameRol}")
    public ResponseEntity<List<Usuario>> listarUsuarioRol(@PathVariable String nameRol){
        return new ResponseEntity<>(usuarioService.getUserByRol(nameRol), HttpStatus.OK);
    }

    @PostMapping("/auth")
    public ResponseEntity<Usuario> autenticarUsuario(@RequestBody Usuario usuario){
        System.out.println(usuario);
        Usuario localUser = this.usuarioService.authUser(usuario.getUsername(), usuario.getPassword());
        return ResponseEntity.ok(localUser);
    }

}
