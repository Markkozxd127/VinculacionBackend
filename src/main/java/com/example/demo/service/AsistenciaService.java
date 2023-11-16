package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.AsistenciaDto;
import com.example.demo.entity.Asistencia;

public interface AsistenciaService <T>{
	T update(T t);
	void delete(int id);
	Optional<T> read(int id);
	List<T> readAll();
	Asistencia guardarAsistencia(AsistenciaDto asistenciaDto);
}	

