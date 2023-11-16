package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Proyecto_RolDto;
import com.example.demo.entity.Proyecto;
import com.example.demo.entity.Proyecto_Rol;
import com.example.demo.entity.RoldeAlumno;
import com.example.demo.repository.ProyectoRepository;
import com.example.demo.repository.Proyecto_RolRepository;
import com.example.demo.repository.RoldeAlumnoRepository;
import com.example.demo.service.Proyecto_RolService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class Proyecto_RolServiceImpl implements Proyecto_RolService<Proyecto_Rol>{
	
	@Autowired
	private Proyecto_RolRepository proyecto_RolRepository;

	@Autowired
	private ProyectoRepository proyectoRepository;


	@Autowired
	private RoldeAlumnoRepository roldeAlumnoRepository;



	@Override
	public Proyecto_Rol update(Proyecto_Rol t) {
		// TODO Auto-generated method stub
		return proyecto_RolRepository.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		proyecto_RolRepository.deleteById(id);
	}

	@Override
	public Optional<Proyecto_Rol> read(int id) {
		// TODO Auto-generated method stub
		return proyecto_RolRepository.findById(id);
	}

	@Override
	public List<Proyecto_Rol> readAll() {
		// TODO Auto-generated method stub
		return proyecto_RolRepository.findAll();
	}
	@Override
	public Proyecto_Rol guardarProyecto_Rol(Proyecto_RolDto proyecto_RolDto) {

	    Proyecto proyecto = proyectoRepository.findById(proyecto_RolDto.getProyecto())
	            .orElseThrow(() -> new EntityNotFoundException("Tipo_Convenio not found"));

	   
	     RoldeAlumno roldeAlumno =roldeAlumnoRepository.findById(proyecto_RolDto.getRoldeAlumno())
	            .orElseThrow(() -> new EntityNotFoundException("Tipo_Convenio not found"));

	     Proyecto_Rol proyecto_Rol = new Proyecto_Rol();
	    //atri
	     proyecto_Rol.setHoras(proyecto_RolDto.getHoras());
	    
	    //atri
	     proyecto_Rol.setDetalles(proyecto_RolDto.getDetalles());
	    
	    //fora
	     proyecto_Rol.setProyecto(proyecto);
	    
	    
	    //fora
	     proyecto_Rol.setRoldeAlumno(roldeAlumno);

	    return proyecto_RolRepository.save(proyecto_Rol);
	}
	

}