package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.EquipoAlumnoDTOEDIT;
import com.example.demo.dto.Equipo_AlumnoDto;
import com.example.demo.entity.Alumno;
import com.example.demo.entity.Convenio;
import com.example.demo.entity.Equipo;
import com.example.demo.entity.Equipo_Alumno;
import com.example.demo.entity.Escuela_Profecional;
import com.example.demo.entity.Proyecto;
import com.example.demo.entity.Proyecto_Rol;
import com.example.demo.entity.Semestre;
import com.example.demo.entity.Tipo_Proyecto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AlumnoRepository;
import com.example.demo.repository.EquipoRepository;
import com.example.demo.repository.Equipo_AlumnoRepository;
import com.example.demo.repository.Proyecto_RolRepository;
import com.example.demo.service.Equipo_AlumnoService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class Equipo_AlumnoServiceImpl implements Equipo_AlumnoService<Equipo_Alumno>{	
	@Autowired
	private Equipo_AlumnoRepository equipo_AlumnoRepository;
	@Autowired
	private EquipoRepository equipoRepository;
	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private Proyecto_RolRepository proyecto_RolRepository;

	@Override
	public Equipo_Alumno update(Equipo_Alumno t) {
		return null;
	}
	
	//@Override
	//	public Equipo_Alumno update(int id, Equipo_AlumnoDto equipo_AlumnoDto) {
	//    Optional<Equipo_Alumno> optionalLibro = equipo_AlumnoRepository.findById(id);

	//    if (optionalLibro.isPresent()) {
	    	//	    	Equipo_Alumno libro = optionalLibro.get();

	//        // Actualiza los campos del libro con los valores del DTO
	//        libro.setCalificacion(equipo_AlumnoDto.getCalificacion());
	    	//        libro.setNota(equipo_AlumnoDto.getNota());
	    	//        libro.setHoras_realizadas(equipo_AlumnoDto.getHoras_realizadas());
	    	//        libro.setEstado_asistencia(equipo_AlumnoDto.getEstado_asistencia());
	    	//        libro.setEstado(equipo_AlumnoDto.getEstado());

	        // Actualiza las relaciones con autor, editorial y categoría
	//        libro.setEquipo(equipoRepository.findById(equipo_AlumnoDto.getEquipo()).orElse(null));
	//      libro.setProyecto_Rol(proyecto_RolRepository.findById(equipo_AlumnoDto.getProyecto_Rol()).orElse(null));
	//      libro.setAlumno(alumnoRepository.findById(equipo_AlumnoDto.getAlumno()).orElse(null));
	    	//
	        // Guarda el libro actualizado en la base de datos
	//    return equipo_AlumnoRepository.save(libro);
	    	//    } else {
	//      throw new ResourceNotFoundException("Libro no encontrado con ID: " + id);
	    	//  }
	//}
	
	
	
	
	
	
	
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub		
	}
	@Override
	public Optional<Equipo_Alumno> read(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	@Override
	public List<Equipo_Alumno> readAll() {
		// TODO Auto-generated method stub
		return equipo_AlumnoRepository.findAll();
	}

	@Override
	public Equipo_Alumno guardarEquipo_Alumno(Equipo_AlumnoDto equipo_AlumnoDto) {		
		Equipo equipo = equipoRepository.findById(equipo_AlumnoDto.getEquipo())
	            .orElseThrow(() -> new EntityNotFoundException("Equipo not found"));
		Alumno alumno = alumnoRepository.findById(equipo_AlumnoDto.getAlumno())
		            .orElseThrow(() -> new EntityNotFoundException("Alumno not found"));		 
		Proyecto_Rol proyecto_Rol = proyecto_RolRepository.findById(equipo_AlumnoDto.getProyecto_Rol())
		            .orElseThrow(() -> new EntityNotFoundException("Proyecto_Rol not found"));

		Equipo_Alumno equipo_Alumno = new Equipo_Alumno();
	    //atri	    
	    //fora		
		equipo_Alumno.setProyecto_Rol(proyecto_Rol);
		equipo_Alumno.setEquipos(equipo);
		equipo_Alumno.setAlumnos(alumno);

	    return equipo_AlumnoRepository.save(equipo_Alumno);
	}
    @Transactional
    public void update(EquipoAlumnoDTOEDIT dto, int id) {
        equipo_AlumnoRepository.updateEquipoAlumno(dto.getCalificacion(), dto.getEstado(), dto.getEstado_asistencia(),
                dto.getHoras_realizadas(), dto.getNota(), id);
    }


}