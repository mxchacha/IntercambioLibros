package com.example.proyecto.models.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="INTERCAMBIO")
public class Intercambio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDINTERCAMBIO")
	private  Integer idintercambio;
	
	@Column(name="FECHAINTERCAMBIO")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Calendar fechaIntercambio;
	
	@Column(name="LUGAR")
	@Size(max=30)
	@NotEmpty
	private String lugar;

	@Column(name="ESTADO")
	@Size(max=15)
	@NotEmpty
	private String estado;

	@OneToMany(mappedBy="intercambio", fetch=FetchType.LAZY)
	private List<Usuario> usuario;

	@OneToMany(mappedBy="intercambio", fetch=FetchType.LAZY)
	private List<DetalleIntercambio> detalleIntercambio;
	
	
	public Intercambio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Intercambio(Integer id) {
		super();
		this.idintercambio=id;
	}

	public Integer getIdintercambio() {
		return idintercambio;
	}


	public void setIdintercambio(Integer idintercambio) {
		this.idintercambio = idintercambio;
	}


	public Calendar getFechaIntercambio() {
		return fechaIntercambio;
	}


	public void setFechaIntercambio(Calendar fechaIntercambio) {
		this.fechaIntercambio = fechaIntercambio;
	}


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	

}
