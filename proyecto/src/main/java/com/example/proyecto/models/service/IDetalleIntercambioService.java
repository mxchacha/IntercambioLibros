package com.example.proyecto.models.service;

import java.util.List;
import com.example.proyecto.models.entities.DetalleIntercambio;

public interface IDetalleIntercambioService {
	

	public void save(DetalleIntercambio detalleIntecambio);
	
	public DetalleIntercambio findById(Integer id);
	
	public void delete(Integer Id);
	
	public List<DetalleIntercambio>findAll();
}
