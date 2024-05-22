package com.iesam.bibliotecaDigital2.usuario.domain;

public class UpdateUsuarioUseCase {

    private UsuarioRepository usuarioRepository;

    public UpdateUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario execute(String dni){

         return usuarioRepository.updateUsuario(dni);


    }
}
