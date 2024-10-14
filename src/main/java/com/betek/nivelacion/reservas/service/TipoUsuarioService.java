package com.betek.nivelacion.reservas.service;

import com.betek.nivelacion.reservas.model.TipoUsuario;

import java.util.List;

public interface TipoUsuarioService {

     TipoUsuario saveTipoUsuario(TipoUsuario tipoUsuario);

     List<TipoUsuario> findAll();

     TipoUsuario updateTipoUsuario(TipoUsuario tipoUsuario);
}
