package com.example.proyecto.models.service;

import java.util.List;

import com.example.proyecto.models.entities.Usuario;

public interface IUsuarioService {
	
	public void save(Usuario usuario);
	
	public Usuario findById(Integer id);
	
	public void delete(Integer Id);
	
	public List<Usuario>findAll();

}
