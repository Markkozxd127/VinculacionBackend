package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ProyectoDto;
import com.example.demo.entity.Convenio;
import com.example.demo.entity.Escuela_Profecional;
import com.example.demo.entity.Proyecto;
import com.example.demo.entity.Semestre;
import com.example.demo.entity.Tipo_Proyecto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ConvenioRepository;
import com.example.demo.repository.Escuela_ProfecionalRepository;
import com.example.demo.repository.ProyectoRepository;
import com.example.demo.repository.SemestreRepository;
import com.example.demo.repository.Tipo_ProyectoRepository;
import com.example.demo.service.ProyectoService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProyectoServiceImpl implements ProyectoService<Proyecto>{
	
	@Autowired
	private ProyectoRepository proyectoRepository;
	@Autowired
	private ConvenioRepository convenioRepository;
	@Autowired
	private Tipo_ProyectoRepository tipo_ProyectoRepository;
	@Autowired
	private SemestreRepository semestreRepository;
	@Autowired
	private Escuela_ProfecionalRepository escuela_ProfecionalRepository;
	
	
	@Override
	@Transactional
	public Proyecto update(int id, ProyectoDto proyectoDto ) {
		System.out.println(id);
		Proyecto proyecto = new Proyecto();
		proyecto = proyectoRepository.findById(id)
	    		.orElseThrow(() -> new EntityNotFoundException("Convenio not found"));


	        // Actualiza los campos del libro con los valores del DTO
	    	proyecto.setNombreproyecto(proyectoDto.getNombreproyecto());
	    	proyecto.setDescripcion(proyectoDto.getDescripcion());
	    	proyecto.setFecha_inicio(proyectoDto.getFecha_inicio());
	    	proyecto.setFecha_fin(proyectoDto.getFecha_fin());
	    	proyecto.setNumero_bene(proyectoDto.getNumero_bene());
	    	proyecto.setLocalidad(proyectoDto.getLocalidad());
	    	proyecto.setObjetivo(proyectoDto.getObjetivo());
	    	proyecto.setDocumento(proyectoDto.getDocumento());
	    	proyecto.setEstado(proyectoDto.getEstado());	
	    	Convenio c = new Convenio(proyectoDto.getConvenio());
	    	Tipo_Proyecto TP = new Tipo_Proyecto(proyectoDto.getTipo_Proyecto());
	    	Semestre s = new Semestre(proyectoDto.getSemestre());
	    	Escuela_Profecional ep = new Escuela_Profecional(proyectoDto.getEscuelaProfecional());
	        // Actualiza las relaciones con autor, editorial y categoría
	    	proyecto.setConvenio(c);
	    	proyecto.setTipo_Proyecto(TP);
	    	proyecto.setSemestre(s);
	    	proyecto.setEscuelaProfecional(ep);
	        // Guarda el libro actualizado en la base de datos
	        return proyectoRepository.save(proyecto);
	}
	
	
	
	@Override
	public void delete(int id) {
		proyectoRepository.deleteById(id);
	}
	@Override	
	public Optional<Proyecto> read(int id) {
		return proyectoRepository.findById(id);
	}
	@Override
	public List<Proyecto> readAll() {
		return proyectoRepository.findAll();
	}	
	
	public List<Proyecto> findSemesterProyecto(int id_semester){
		return proyectoRepository.getProyectoBySemestre(id_semester);
	}
	
	@Override
	public Proyecto guardarProyecto(ProyectoDto proyectoDto) {

	    Convenio convenio = convenioRepository.findById(proyectoDto.getConvenio())
	            .orElseThrow(() -> new EntityNotFoundException("Convenio not found"));

	    Tipo_Proyecto tipo_Proyecto = tipo_ProyectoRepository.findById(proyectoDto.getTipo_Proyecto())
	            .orElseThrow(() -> new EntityNotFoundException("Tipo_Proyecto not found"));

	    Semestre semestre = semestreRepository.findById(proyectoDto.getSemestre())
	            .orElseThrow(() -> new EntityNotFoundException("Semestre not found"));


	    Escuela_Profecional escuela_Profecional = escuela_ProfecionalRepository.findById(proyectoDto.getEscuelaProfecional())
	            .orElseThrow(() -> new EntityNotFoundException("Escuela_Profecional not found"));
	   
	    Proyecto proyecto = new Proyecto();
	    //atri
	    proyecto.setNombreproyecto(proyectoDto.getNombreproyecto());	  
	    //atri
	    proyecto.setDescripcion(proyectoDto.getDescripcion());	    
	    //atri
	    proyecto.setFecha_inicio(proyectoDto.getFecha_inicio());	    
	    //atri
	    proyecto.setFecha_fin(proyectoDto.getFecha_fin());	    
	    //atri
	    proyecto.setNumero_bene(proyectoDto.getNumero_bene());	    
	    //atri
	    proyecto.setLocalidad(proyectoDto.getLocalidad());	    
	    //atri
	    proyecto.setObjetivo(proyectoDto.getObjetivo());	    
	    //atri
	    proyecto.setDocumento(proyectoDto.getDocumento());    	    
	    //atri
	    proyecto.setEstado(proyectoDto.getEstado());    
	    //fora
	    proyecto.setConvenio(convenio);
	    //fora
	    proyecto.setTipo_Proyecto(tipo_Proyecto);	    
	    //fora
	    proyecto.setSemestre(semestre);	    
	    //fora
	    proyecto.setEscuelaProfecional(escuela_Profecional);
	    return proyectoRepository.save(proyecto);
	}	
	
	
	// @Override
	  //  public Proyecto findProyectoWithDetails(Integer proyectoId) {
	     //   return proyectoRepository.findProyectoWithDetails(proyectoId);
	   // }
}


// proyecto.setCordinadora(cordinadora);

// Cordinadora cordinadora = cordinadoraRepository.findById(proyectoDto.getCordinadora())
//   .orElseThrow(() -> new EntityNotFoundException("Cordinadora not found"));

	