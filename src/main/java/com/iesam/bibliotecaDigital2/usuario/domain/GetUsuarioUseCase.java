package com.iesam.bibliotecaDigital2.usuario.domain;

public class GetUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public GetUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario execute (String dni){
        return usuarioRepository.showUsuario(dni);
    }
}
