package com.iesam.bibliotecaDigital2.usuario.data;

import com.iesam.bibliotecaDigital2.usuario.data.local.UsuarioFileLocalDataSource;
import com.iesam.bibliotecaDigital2.usuario.domain.Usuario;
import com.iesam.bibliotecaDigital2.usuario.domain.UsuarioRepository;

import java.util.List;

public class UsuarioDataRepository implements UsuarioRepository {


    private final UsuarioFileLocalDataSource usuarioFileLocalDataSource;

    public UsuarioDataRepository(UsuarioFileLocalDataSource usuarioFileLocalDataSource) {
        this.usuarioFileLocalDataSource = usuarioFileLocalDataSource;
    }


    @Override
    public void deleteUsuario(String dni) {

        usuarioFileLocalDataSource.delete(dni);

    }

    @Override
    public Usuario showUsuario(String dni) {
        return usuarioFileLocalDataSource.findById(dni);
    }

    @Override
    public List<Usuario> obtainUsuarios() {
        return usuarioFileLocalDataSource.findAll();
    }

    @Override
    public Usuario updateUsuario(String dni) {
        usuarioFileLocalDataSource.delete(dni);
       usuarioFileLocalDataSource.findById(dni);
        return null;
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioFileLocalDataSource.save(usuario);
    }
}
