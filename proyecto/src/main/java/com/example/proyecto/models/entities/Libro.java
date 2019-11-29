package com.example.proyecto.models.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="LIBRO")
public class Libro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDLIBRO")
	private  Integer idlibro;
	
	@Column(name="TITULO")
	@Size(max=30)
	@NotEmpty
	private String titulo;
	
	@Column(name="AUTOR")
	@Size(max=25)
	@NotEmpty
	private String autor;
	
	@Column(name="FECHAPUBLICACION")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Calendar fechaPublicacion;
	
	@Column(name="DESCRIPCION")
	@Size(max=300)
	@NotEmpty
	private String descripcion;
	
	@Column(name="CATEGORIA")
	@Size(max=20)
	@NotEmpty
	private String categoria;
	

	
	@JoinColumn(name="IDUSUARIO",referencedColumnName="IDUSUARIO")
	@ManyToOne
	private Usuario usuario;

	public Integer getIdlibro() {
		return idlibro;
	}
	

	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Libro(Integer id) {
		super();
		this.idlibro=id;
		// TODO Auto-generated constructor stub
	}

	public void setIdlibro(Integer idlibro) {
		this.idlibro = idlibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Calendar getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Calendar fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
