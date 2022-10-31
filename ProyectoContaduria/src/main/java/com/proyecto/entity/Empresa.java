package com.proyecto.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_empresa")
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_emp")
	private Integer codempresa;
	@Column(name = "nombre")
	private String nomempresa;
	
	@OneToMany(mappedBy = "empresa")
	private List<LibroDiario> libdiarios;

	public Integer getCodempresa() {
		return codempresa;
	}

	public void setCodempresa(Integer codempresa) {
		this.codempresa = codempresa;
	}

	public String getNomempresa() {
		return nomempresa;
	}

	public void setNomempresa(String nomempresa) {
		this.nomempresa = nomempresa;
	}

	public List<LibroDiario> getLibdiarios() {
		return libdiarios;
	}

	public void setLibdiarios(List<LibroDiario> libdiarios) {
		this.libdiarios = libdiarios;
	}
}