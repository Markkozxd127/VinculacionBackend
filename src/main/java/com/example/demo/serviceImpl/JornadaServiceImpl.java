package com.example.demo.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.JornadaDto;
import com.example.demo.entity.Jornada;
import com.example.demo.entity.Proyecto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.JornadaRepository;
import com.example.demo.repository.ProyectoRepository;
import com.example.demo.service.JornadaService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class JornadaServiceImpl implements JornadaService<Jornada>{
	
	@Autowired
	private JornadaRepository jornadaRepository;

	@Autowired
	private ProyectoRepository proyectoRepository;

	@Override
	@Transactional
	public Jornada update(int id, JornadaDto jornadaDto ) {
	    Optional<Jornada> optionalJornada = jornadaRepository.findById(id);

	    if (optionalJornada.isPresent()) {
	    	Jornada jornada = optionalJornada.get();
	    	jornada.setNombreJornada(jornadaDto.getNombreJornada());
	    	jornada.setFecha(jornadaDto.getFecha());	
	    	jornada.setURL(jornadaDto.getURL());
	    	jornada.setProyecto(proyectoRepository.findById(jornadaDto.getProyecto()).orElse(null));
	        return jornadaRepository.save(jornada);
	    } else {
	        throw new ResourceNotFoundException("equipo no encontrado con ID: " + id);
	    }
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		jornadaRepository.deleteById(id);
	}

	@Override
	public Optional<Jornada> read(int id) {
		// TODO Auto-generated method stub
		return jornadaRepository.findById(id);
	}
	

	public List<Map<String, Object>> searchByProyectoJornada(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		return jornadaRepository.jornadaByProyecto(id);
	}
	
	public List<Map<String, Object>> searchByPersona(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		return jornadaRepository.jornadaByPersona(id);
	}

	@Override
	public List<Jornada> readAll() {
		// TODO Auto-generated method stub
		return jornadaRepository.findAll();
	}

	@Override
	public Jornada guardarJornada(JornadaDto jornadaDto) {

	    Proyecto proyecto = new Proyecto(jornadaDto.getProyecto(), null);
	           
	    System.out.println(jornadaDto.getURL());
	    Jornada jornada = new Jornada();
	    //atri
	    jornada.setNombreJornada(jornadaDto.getNombreJornada());
	    //atri
	    jornada.setFecha(jornadaDto.getFecha());
	    jornada.setURL(jornadaDto.getURL());
	    //fora
	    jornada.setProyecto(proyecto);

	    return jornadaRepository.save(jornada);
	}
	
	public List<Map<String, Object>> buscarPorProyecto(int idProyecto){
		System.out.println(idProyecto);
		return jornadaRepository.searchByProyecto(idProyecto); 
	}
	

}