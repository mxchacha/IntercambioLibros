package com.example.proyecto.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.proyecto.models.entities.Libro;

public interface ILibro extends CrudRepository<Libro,Integer>{

}
