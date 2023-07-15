package com.vocacional.sitapivocacional.service;

import com.vocacional.sitapivocacional.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario addUser(Usuario usuario) throws Exception;

    public List<Usuario> getAllUser();

    public Usuario getUser(String username);

    public void deleteUser(String username);

    public List<Usuario> getUserByRol(String rolName);
    public Usuario authUser(String username, String password);

}
