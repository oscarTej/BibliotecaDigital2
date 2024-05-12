package com.iesam.bibliotecaDigital2.usuario.domain;

public interface UsuarioRepository {
    void deleteUsuario(String dni);

    Usuario showUsuario(String dni);
}
