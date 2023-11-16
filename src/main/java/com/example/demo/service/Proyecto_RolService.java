package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.Proyecto_RolDto;
import com.example.demo.entity.Proyecto_Rol;

public interface Proyecto_RolService<T>{
	T update(T t);
	void delete(int id);
	Optional<T> read(int id);
	List<T> readAll();
	Proyecto_Rol guardarProyecto_Rol(Proyecto_RolDto proyecto_RolDto);
}	

