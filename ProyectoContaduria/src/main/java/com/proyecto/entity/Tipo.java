package com.proyecto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tipo")
public class Tipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_tipo")
	private Integer codtipo;
	@Column(name = "descripcion")
	private String descripcion;
	
	//tiene un enlace con tb_importe_parcial
}