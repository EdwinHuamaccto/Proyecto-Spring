package com.proyecto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_compra")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_com")
	private Integer codigocom;
	@Column(name = "AFECTO")
	private Double afecto;
	@Column(name = "INAF")
	private Double inaf;
	@Column(name = "TOTAL_VC")
	private Double total_vc;
	@Column(name ="IGV_COMPRA")
	private Double igv;
	@Column(name = "precio_compra")
	private Double precio_compra;

	
	
	@ManyToOne
	@JoinColumn(name = "cod_tipo_afecto")
	private TipoAfecto tipoafe;

	public Integer getCodigocom() {
		return codigocom;
	}

	public void setCodigocom(Integer codigocom) {
		this.codigocom = codigocom;
	}

	public Double getAfecto() {
		return afecto;
	}

	public void setAfecto(Double afecto) {
		this.afecto = afecto;
	}

	public Double getInaf() {
		return inaf;
	}

	public void setInaf(Double inaf) {
		this.inaf = inaf;
	}

	public Double getTotal_vc() {
		return total_vc;
	}

	public void setTotal_vc(Double total_vc) {
		this.total_vc = total_vc;
	}

	public Double getIgv() {
		return igv;
	}

	public void setIgv(Double igv) {
		this.igv = igv;
	}

	public Double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(Double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public TipoAfecto getTipoafe() {
		return tipoafe;
	}

	public void setTipoafe(TipoAfecto tipoafe) {
		this.tipoafe = tipoafe;
	}
	
	
	

}
