package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import com.example.demo.dto.ProyectoDto;
import com.example.demo.entity.Proyecto;

public interface ProyectoService <T>{
	T update(T t);
	void delete(int id);
	Optional<T> read(int id);
	List<T> readAll();
	Proyecto guardarProyecto(ProyectoDto proyectoDto);
	
	
   // Proyecto findProyectoWithDetails(Integer proyectoId);

}	

