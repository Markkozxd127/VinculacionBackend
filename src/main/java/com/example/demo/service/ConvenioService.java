package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.ConvenioDto;
import com.example.demo.entity.Convenio;

public interface ConvenioService  <T>{
	T update(T t);
	void delete(int id);
	Optional<T> read(int id);
	List<T> readAll();
	Convenio guardarConvenio(ConvenioDto convenioDto);
}	

