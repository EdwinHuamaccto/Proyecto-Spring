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


@Entity
@Table(name="tb_importe_parcial")
public class ImporteParcial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_imp_par")
	private Integer codigoImporte;
	@Column(name="importe_parcial")
	private String importe;
	@Column(name="monto")
	private double monto;

    @ManyToOne
	@JoinColumn(name = "cod_tipo")
	private Tipo tipo;
   
	@ManyToOne
	@JoinColumn(name = "cod_detalle")
	private Detalle detalle;
	
	@OneToMany(mappedBy = "importe")
	private List<LibroDiario> listaLibroD;
}
