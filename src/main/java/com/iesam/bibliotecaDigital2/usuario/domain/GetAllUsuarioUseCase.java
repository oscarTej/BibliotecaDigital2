package com.iesam.bibliotecaDigital2.usuario.domain;

import java.util.List;

public class GetAllUsuarioUseCase {

    private UsuarioRepository usuarioRepository;

    public GetAllUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> execute(){

        return this.usuarioRepository.obtainUsuarios();
    }
}
