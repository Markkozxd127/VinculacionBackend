package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RoldeAlumno;
import com.example.demo.repository.RoldeAlumnoRepository;
import com.example.demo.service.RoldeAlumnoService;

@Service
public class RoldeAlumnoServiceImpl implements RoldeAlumnoService<RoldeAlumno>{
	
	@Autowired
	private RoldeAlumnoRepository roldeAlumnoRepository;

	@Override
	public RoldeAlumno create(RoldeAlumno t) {
		// TODO Auto-generated method stub
		return roldeAlumnoRepository.save(t);
	}

	@Override
	public RoldeAlumno update(RoldeAlumno t) {
		// TODO Auto-generated method stub
		return roldeAlumnoRepository.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		roldeAlumnoRepository.deleteById(id);
	}

	@Override
	public Optional<RoldeAlumno> read(int id) {
		// TODO Auto-generated method stub
		return roldeAlumnoRepository.findById(id);
	}

	@Override
	public List<RoldeAlumno> readAll() {
		// TODO Auto-generated method stub
		return roldeAlumnoRepository.findAll();
	}

}