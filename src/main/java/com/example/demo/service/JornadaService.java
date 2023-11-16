package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.JornadaDto;
import com.example.demo.entity.Jornada;

public interface JornadaService  <T>{
	T update(T t);
	void delete(int id);
	Optional<T> read(int id);
	List<T> readAll();
	Jornada guardarJornada(JornadaDto jornadaDto);
}	

