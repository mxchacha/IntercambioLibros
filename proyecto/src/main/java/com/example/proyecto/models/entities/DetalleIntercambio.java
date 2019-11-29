package com.example.proyecto.models.entities;

import java.io.Serializable;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;




@Entity
@Table(name="DETALLEINTERCAMBIO")
public class DetalleIntercambio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDDETALLEINTERCAMBIO")
	private  Integer iddetalleIntercambio;
	
	@Column(name="TITULOLIBROA")
	@Size(max=20)
	@NotEmpty
	private String tituloLibroa;
	
	@Column(name="TITULOLIBROB")
	@Size(max=20)
	@NotEmpty
	private String tituloLibrob;

	@JoinColumn(name="IDINTERCAMBIO",referencedColumnName="IDINTERCAMBIO")
	@ManyToOne
	private Intercambio intercambio;
	
	public DetalleIntercambio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DetalleIntercambio(Integer id) {
		super();
		this.iddetalleIntercambio=id;
		
		// TODO Auto-generated constructor stub
	}

	public Integer getIddetalleIntercambio() {
		return iddetalleIntercambio;
	}

	public void setIddetalleIntercambio(Integer iddetalleIntercambio) {
		this.iddetalleIntercambio = iddetalleIntercambio;
	}

	public String getTituloLibroa() {
		return tituloLibroa;
	}

	public void setTituloLibroa(String tituloLibroa) {
		this.tituloLibroa = tituloLibroa;
	}

	public String getTituloLibrob() {
		return tituloLibrob;
	}

	public void setTituloLibrob(String tituloLibrob) {
		this.tituloLibrob = tituloLibrob;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

