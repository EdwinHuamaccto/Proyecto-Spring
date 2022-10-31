package com.proyecto.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_libro_diario")
public class LibroDiario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_LDiario")
	private int codigo;
	@Column(name="fecha")
	private Date fecha;
			  
	@ManyToOne
	@JoinColumn(name = "cod_imp_par")
	private ImporteParcial importe;
	@ManyToOne
	@JoinColumn(name = "cod_emp")
	private Empresa empresa;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public ImporteParcial getImporte() {
		return importe;
	}
	public void setImporte(ImporteParcial importe) {
		this.importe = importe;
	}
			 
		
}
