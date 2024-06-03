package com.iesam.bibliotecaDigital2.usuario.domain;

import java.util.List;

public interface UsuarioRepository {
    void deleteUsuario(String dni);

    Usuario showUsuario(String dni);

    List<Usuario> obtainUsuarios();

    Usuario updateUsuario(String dni);

    void saveUsuario(Usuario usuario);
}
