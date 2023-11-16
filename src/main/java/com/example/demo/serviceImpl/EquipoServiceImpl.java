package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EquipoDto;
import com.example.demo.entity.Equipo;
import com.example.demo.entity.Proyecto;
import com.example.demo.repository.EquipoRepository;
import com.example.demo.repository.ProyectoRepository;
import com.example.demo.service.EquipoService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EquipoServiceImpl implements EquipoService<Equipo>{
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	@Autowired
	private ProyectoRepository proyectoRepository;



	@Override
	public Equipo update(Equipo t) {
		return equipoRepository.save(t);
	}

	@Override
	public void delete(int id) {
		equipoRepository.deleteById(id);
	}

	@Override
	public Optional<Equipo> read(int id) {
		return equipoRepository.findById(id);
	}

	@Override
	public List<Equipo> readAll() {
		return equipoRepository.findAll();
	}
	
	@Override
	public Equipo guardarEquipo(EquipoDto equipoDto) {

	    Proyecto proyecto = proyectoRepository.findById(equipoDto.getProyecto())
	            .orElseThrow(() -> new EntityNotFoundException("Proyecto not found"));

	    Equipo equipo = new Equipo();
	    //atri
	    equipo.setNombre_equipo(equipoDto.getNombre_equipo());
	    //atri
	    equipo.setArchivo_informe(equipoDto.getArchivo_informe());
	    //fora
	    equipo.setProyecto(proyecto);

	    return equipoRepository.save(equipo);
	}
	

}