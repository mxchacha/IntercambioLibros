package com.example.proyecto.models.service;

import java.util.List;

import com.example.proyecto.models.entities.Libro;

public interface ILibroService {
	
	public void save(Libro libro);
	
	public Libro findById(Integer id);
	
	public void delete(Integer Id);
	
	public List<Libro>findAll();

}
