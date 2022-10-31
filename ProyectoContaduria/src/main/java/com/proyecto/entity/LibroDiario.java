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
	@Column(name="importe_parcial")
	private String importe;
	
    @ManyToOne
	@JoinColumn(name = "cod_tipo")
	private Tipo tipo;
   
	@ManyToOne
	@JoinColumn(name = "cod_detalle")
	private Detalle detalle;
	
	@ManyToOne
	@JoinColumn(name = "cod_emp")
	private Empresa empresa;
	

			 
		
}
