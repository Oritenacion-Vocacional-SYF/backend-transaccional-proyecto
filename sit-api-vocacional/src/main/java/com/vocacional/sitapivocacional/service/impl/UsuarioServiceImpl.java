package com.vocacional.sitapivocacional.service.impl;

import com.vocacional.sitapivocacional.model.Usuario;
import com.vocacional.sitapivocacional.repository.UsuarioRepository;
import com.vocacional.sitapivocacional.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario addUser(Usuario usuario) throws Exception {
        Usuario userLocal = usuarioRepository.findAllByUsername(usuario.getUsername());
        return (userLocal == null) ?  usuarioRepository.save(usuario) : null ;
    }

}
