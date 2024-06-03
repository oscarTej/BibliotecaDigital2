package com.iesam.bibliotecaDigital2.usuario.domain;

import com.iesam.bibliotecaDigital2.prestamo.domain.Prestamo;

public class SaveUsuarioUseCase {
    private UsuarioRepository usuarioRepository;

    public SaveUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void execute(Usuario usuario){
        usuarioRepository.saveUsuario(usuario);
    }
}
