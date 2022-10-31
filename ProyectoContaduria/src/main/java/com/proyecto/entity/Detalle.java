package com.proyecto.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	@OneToMany(mappedBy = "detalle")
	private List<Detalle> detalles;

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

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}
}