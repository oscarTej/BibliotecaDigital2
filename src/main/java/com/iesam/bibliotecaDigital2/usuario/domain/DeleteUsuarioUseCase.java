package com.iesam.bibliotecaDigital2.usuario.domain;

public class DeleteUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public DeleteUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void execute (String dni){

        usuarioRepository.deleteUsuario(dni);
    }
}
