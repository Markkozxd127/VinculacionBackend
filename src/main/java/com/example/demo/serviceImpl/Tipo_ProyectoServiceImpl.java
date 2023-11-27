package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Tipo_Proyecto;
import com.example.demo.repository.Tipo_ProyectoRepository;
import com.example.demo.service.Tipo_ProyectoService;

@Service
public class Tipo_ProyectoServiceImpl implements  Tipo_ProyectoService<Tipo_Proyecto>{

	
	@Autowired
	private Tipo_ProyectoRepository tipo_ProyectoRepository;
	
	@Override
	public Tipo_Proyecto create(Tipo_Proyecto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tipo_Proyecto update(Tipo_Proyecto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Tipo_Proyecto> read(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Tipo_Proyecto> readAll() {
		// TODO Auto-generated method stub
		return tipo_ProyectoRepository.findAll();
	}
	


}