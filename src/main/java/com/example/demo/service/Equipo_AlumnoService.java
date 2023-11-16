package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.Equipo_AlumnoDto;
import com.example.demo.entity.Equipo_Alumno;

public interface Equipo_AlumnoService  <T>{
	T update(T t);
	void delete(int id);
	Optional<T> read(int id);
	List<T> readAll();
	Equipo_Alumno guardarEquipo_Alumno(Equipo_AlumnoDto equipo_AlumnoDto);
}	

