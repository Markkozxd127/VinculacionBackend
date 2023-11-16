package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AsistenciaDto;
import com.example.demo.entity.Asistencia;
import com.example.demo.entity.Jornada;
import com.example.demo.entity.Equipo_Alumno;
import com.example.demo.repository.AsistenciaRepository;
import com.example.demo.repository.JornadaRepository;
import com.example.demo.service.AsistenciaService;
import com.example.demo.repository.Equipo_AlumnoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AsistenciaServiceImpl implements AsistenciaService<Asistencia>{
	
	@Autowired
	private AsistenciaRepository asistenciaRepository;
	
	@Autowired
	private JornadaRepository jornadaRepository;
	
	@Autowired
	private Equipo_AlumnoRepository equipo_AlumnoRepository;


	@Override
	public Asistencia update(Asistencia t) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Optional<Asistencia> read(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}


	@Override
	public List<Asistencia> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Asistencia guardarAsistencia(AsistenciaDto asistenciaDto) {

	    Jornada jornada = jornadaRepository.findById(asistenciaDto.getJornada())
	            .orElseThrow(() -> new EntityNotFoundException("Jornada not found"));

	    Equipo_Alumno equipo_Alumno = equipo_AlumnoRepository.findById(asistenciaDto.getEquipoAlumno())
	            .orElseThrow(() -> new EntityNotFoundException("Equipo_Alumno not found"));

	    Asistencia asistencia = new Asistencia();
	    
	    // Set attributes
	    asistencia.setCalificacion(asistenciaDto.getCalificacion());
	    asistencia.setNota(asistenciaDto.getNota());
	    asistencia.setHoras_realizadas(asistenciaDto.getHoras_realizadas());
	    asistencia.setEstado_asistencia(asistenciaDto.getEstado_asistencia());

	    // Set associations
	    asistencia.setJornada(jornada);
	    asistencia.setEquipoAlumno(equipo_Alumno); // Fix this line

	    return asistenciaRepository.save(asistencia);
	}

}