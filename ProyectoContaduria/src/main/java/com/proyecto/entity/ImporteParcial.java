package com.proyecto.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="tb_importe_parcial")
public class ImporteParcial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_imp_par")
	private Integer codigoImporte;
	@Column(name="importe_parcial")
	private String importe;


    @ManyToOne
	@JoinColumn(name = "cod_tipo")
	private Tipo tipo;
   
	@ManyToOne
	@JoinColumn(name = "cod_detalle")
	private Detalle detalle;
	
	@JsonIgnore
	@OneToMany(mappedBy = "importe")
	private List<LibroDiario> listaLibroD;

	public Integer getCodigoImporte() {
		return codigoImporte;
	}

	public void setCodigoImporte(Integer codigoImporte) {
		this.codigoImporte = codigoImporte;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}


	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	public List<LibroDiario> getListaLibroD() {
		return listaLibroD;
	}

	public void setListaLibroD(List<LibroDiario> listaLibroD) {
		this.listaLibroD = listaLibroD;
	}
}
