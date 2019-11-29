package com.example.proyecto.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto.models.dao.IDetalleIntercambio;
import com.example.proyecto.models.entities.DetalleIntercambio;

@Service
public class DetalleIntercambioService implements IDetalleIntercambioService {

	@Autowired
	private IDetalleIntercambio dao;
	@Override
	public void save(DetalleIntercambio detalleIntercambio) {
		// TODO Auto-generated method stub
		dao.save(detalleIntercambio);
		
	}

	@Override
	public DetalleIntercambio findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public void delete(Integer Id) {
		dao.deleteById(Id);
		
	}

	@Override
	public List<DetalleIntercambio> findAll() {
		// TODO Auto-generated method stub
		return (List<DetalleIntercambio>) dao.findAll();
	}

}
