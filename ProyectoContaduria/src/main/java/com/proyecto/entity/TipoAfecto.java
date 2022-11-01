package com.proyecto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "tb_tipo_afecto")
public class TipoAfecto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_tipo_afecto")
	private Integer codigoafe;
	@Column(name = "tipo_afecto")
	private String tipoafe;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipoafe")
	private List<Compra> listaCompra;

	public Integer getCodigoafe() {
		return codigoafe;
	}

	public void setCodigoafe(Integer codigoafe) {
		this.codigoafe = codigoafe;
	}

	public String getTipoafe() {
		return tipoafe;
	}

	public void setTipoafe(String tipoafe) {
		this.tipoafe = tipoafe;
	}

	public List<Compra> getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(List<Compra> listaCompra) {
		this.listaCompra = listaCompra;
	}
	
	
	

}
