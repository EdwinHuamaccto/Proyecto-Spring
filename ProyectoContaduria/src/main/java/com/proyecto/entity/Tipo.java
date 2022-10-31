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
@Table(name = "tb_tipo")
public class Tipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_tipo")
	private Integer codtipo;
	@Column(name = "descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "tipo")
	private List<ImporteParcial> importes;

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

	public List<ImporteParcial> getImportes() {
		return importes;
	}

	public void setImportes(List<ImporteParcial> importes) {
		this.importes = importes;
	}
}