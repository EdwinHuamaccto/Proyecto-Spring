package com.proyecto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_detalle")
public class Detalle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_detalle")
	private Integer coddetalle;
	@Column(name = "detalle")
	private String detalle;
	@Column(name = "monto")
	private double monto;
	//tiene un enlace con tb_importe_parcial
}