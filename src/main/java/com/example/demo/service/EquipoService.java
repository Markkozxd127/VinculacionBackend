package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.EquipoDto;
import com.example.demo.entity.Equipo;

public interface EquipoService  <T>{
	T update(T t);
	void delete(int id);
	Optional<T> read(int id);
	List<T> readAll();
	Equipo guardarEquipo(EquipoDto equipoDto);
}	

