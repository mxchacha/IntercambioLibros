package com.example.proyecto.models.service;

import java.util.List;
import com.example.proyecto.models.entities.Intercambio;

public interface IIntercambioService {
	
	public void save(Intercambio intercambio);
	
	public Intercambio findById(Integer id);
	
	public void delete(Integer Id);
	
	public List<Intercambio>findAll();

}
