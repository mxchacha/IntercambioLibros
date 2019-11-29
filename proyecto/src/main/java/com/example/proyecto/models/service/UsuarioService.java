package com.example.proyecto.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.models.dao.IUsuario;
import com.example.proyecto.models.entities.Usuario;

@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private IUsuario dao;
	@Override
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		dao.save(usuario);
		
	}

	@Override
	public Usuario findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer Id) {
		dao.deleteById(Id);
		
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) dao.findAll();
	}

}
