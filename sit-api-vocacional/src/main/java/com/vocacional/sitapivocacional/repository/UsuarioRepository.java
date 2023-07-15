package com.vocacional.sitapivocacional.repository;

import com.vocacional.sitapivocacional.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Usuario findAllByUsername(String username);

    Usuario findByUsername(String username);

}
