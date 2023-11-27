package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.EquipoDto;
import com.example.demo.entity.Equipo;

public interface EquipoService  <T>{
	Equipo update(int id,EquipoDto equipoDto);
	void delete(int id);
	Optional<T> read(int id);
	List<T> readAll();
	void guardarEquipo(EquipoDto equipoDto);
}	

