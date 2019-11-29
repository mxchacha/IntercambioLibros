package com.example.proyecto.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDUSUARIO")
	private  Integer idusuario;
	
	
	@Column(name="NOMBRE")
	@Size(max=25)
	@NotEmpty
	private String nombre;
	
	
	@Column(name="APELLIDO")
	@Size(max=25)
	@NotEmpty
	private String apellido;
	
	@Column(name="CEDULA")
	@Size(max=10)
	@NotEmpty
	private String cedula;
	
	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	private List<Libro> libro;
	
	@JoinColumn(name="IDINTERCAMBIO",referencedColumnName="IDINTERCAMBIO")
	@ManyToOne
	private Intercambio intercambio;

	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(Integer id) {
		super();
		this.idusuario=id;
		// TODO Auto-generated constructor stub
	}


	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
