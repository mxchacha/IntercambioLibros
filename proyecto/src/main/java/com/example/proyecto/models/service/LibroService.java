package com.example.proyecto.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.models.dao.ILibro;
import com.example.proyecto.models.entities.Libro;


@Service
public class LibroService implements ILibroService{

	@Autowired
	private ILibro dao;
	@Override
	public void save(Libro libro) {
		// TODO Auto-generated method stub
		dao.save(libro);
		
	}

	@Override
	public Libro findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer Id) {
		dao.deleteById(Id);
		
	}

	@Override
	public List<Libro> findAll() {
		// TODO Auto-generated method stub
		return (List<Libro>) dao.findAll();
	}

}
