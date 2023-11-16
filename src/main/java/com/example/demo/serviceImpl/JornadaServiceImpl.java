package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.JornadaDto;
import com.example.demo.entity.Jornada;
import com.example.demo.entity.Proyecto;
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
	public Jornada update(Jornada t) {
		// TODO Auto-generated method stub
		return jornadaRepository.save(t);
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

	@Override
	public List<Jornada> readAll() {
		// TODO Auto-generated method stub
		return jornadaRepository.findAll();
	}

	@Override
	public Jornada guardarJornada(JornadaDto jornadaDto) {

	    Proyecto proyecto = proyectoRepository.findById(jornadaDto.getProyecto())
	            .orElseThrow(() -> new EntityNotFoundException("Tipo_Convenio not found"));

	    Jornada jornada = new Jornada();
	    //atri
	    jornada.setNombreJornada(jornadaDto.getNombreJornada());
	    //atri
	    jornada.setFecha(jornadaDto.getFecha());
	    
	    //fora
	    jornada.setProyecto(proyecto);

	    return jornadaRepository.save(jornada);
	}
	

}