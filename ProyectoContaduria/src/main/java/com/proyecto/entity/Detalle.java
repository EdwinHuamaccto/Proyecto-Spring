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

	public Integer getCoddetalle() {
		return coddetalle;
	}

	public void setCoddetalle(Integer coddetalle) {
		this.coddetalle = coddetalle;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
}