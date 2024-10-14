package com.betek.nivelacion.reservas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {

    private int codigo;
    private String detalles;
}
