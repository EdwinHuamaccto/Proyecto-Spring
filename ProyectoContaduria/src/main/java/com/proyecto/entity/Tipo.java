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
@Table(name = "tb_tipo")
public class Tipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_tipo")
	private Integer codtipo;
	@Column(name = "descripcion")
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipo")
	private List<LibroDiario> listaLibroD;

	public List<LibroDiario> getListaLibroD() {
		return listaLibroD;
	}

	public void setListaLibroD(List<LibroDiario> listaLibroD) {
		this.listaLibroD = listaLibroD;
	}

	public Integer getCodtipo() {
		return codtipo;
	}

	public void setCodtipo(Integer codtipo) {
		this.codtipo = codtipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}