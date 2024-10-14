package com.betek.nivelacion.reservas.service.impl;

import com.betek.nivelacion.reservas.exception.NotFoundException;
import com.betek.nivelacion.reservas.model.TipoUsuario;
import com.betek.nivelacion.reservas.repository.TipoUsuarioRepository;
import com.betek.nivelacion.reservas.service.TipoUsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

    private final TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioServiceImpl(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    @Override
    public TipoUsuario saveTipoUsuario(TipoUsuario tipoUsuario) {
        Optional<TipoUsuario> optTipoUsuario = tipoUsuarioRepository.findByNombre(tipoUsuario.getNombre());
        return optTipoUsuario.orElseGet(() -> tipoUsuarioRepository.save(tipoUsuario));
    }

    @Override
    public List<TipoUsuario> findAll() {
        return tipoUsuarioRepository.findAll();
    }

    @Override
    public TipoUsuario updateTipoUsuario(TipoUsuario tipoUsuario) {
        TipoUsuario tipoUsuarioBD = tipoUsuarioRepository.findById(tipoUsuario.getId())
                .orElseThrow(() -> new NotFoundException("Tipo de usuario no encontrado"));

        tipoUsuarioBD.setDescripcion(tipoUsuario.getDescripcion());
        tipoUsuarioBD.setDescuentoBase(tipoUsuario.getDescuentoBase());

        return tipoUsuarioRepository.save(tipoUsuarioBD);
    }

}
