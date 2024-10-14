package com.betek.nivelacion.reservas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TIPO_USUARIO")
@NoArgsConstructor
@Getter
@Setter
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "NOMBRE", length = 10, nullable = false, unique = true)
    private String nombre;

    @Column(name = "DESCRIPCION", length = 100)
    private String descripcion;

    @Column(name = "DESCUENTO_BASE", nullable = false)
    private double descuentoBase;

    public TipoUsuario(Integer id, String nombre, String descripcion, double descuentoBase) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descuentoBase = descuentoBase;
    }
}