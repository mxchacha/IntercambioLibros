package com.example.proyecto.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.proyecto.models.entities.Usuario;

public interface IUsuario extends CrudRepository<Usuario,Integer> {

}
