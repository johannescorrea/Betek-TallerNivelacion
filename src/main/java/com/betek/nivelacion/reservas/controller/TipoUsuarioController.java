package com.betek.nivelacion.reservas.controller;

import com.betek.nivelacion.reservas.model.TipoUsuario;
import com.betek.nivelacion.reservas.service.TipoUsuarioService;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipoUsuario")
public class TipoUsuarioController {

    private final TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService) {
        this.tipoUsuarioService = tipoUsuarioService;
    }

    @PostMapping
    public TipoUsuario saveTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioService.saveTipoUsuario(tipoUsuario);
    }

    @GetMapping
    public List<TipoUsuario> listar() {
        return tipoUsuarioService.findAll();
    }

    @PutMapping
    public TipoUsuario updateTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioService.updateTipoUsuario(tipoUsuario);
    }
}
