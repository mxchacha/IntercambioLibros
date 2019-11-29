package com.example.proyecto.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.models.dao.IIntercambio;
import com.example.proyecto.models.entities.Intercambio;

@Service
public class IntercambioService implements IIntercambioService{

	@Autowired
	private IIntercambio dao;
	@Override
	public void save(Intercambio intercambio) {
		// TODO Auto-generated method stub
		dao.save(intercambio);
		
	}

	@Override
	public Intercambio findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer Id) {
		dao.deleteById(Id);
		
	}

	@Override
	public List<Intercambio> findAll() {
		// TODO Auto-generated method stub
		return (List<Intercambio>) dao.findAll();
	}

}
