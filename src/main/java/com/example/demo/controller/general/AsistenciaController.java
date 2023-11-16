package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AsistenciaDto;
import com.example.demo.entity.Asistencia;
import com.example.demo.serviceImpl.AsistenciaServiceImpl;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.example.demo.commons.GlobalConstans.API_ASISTENCIA;

@RestController
@RequestMapping(API_ASISTENCIA)
@CrossOrigin({"*"})

public class AsistenciaController {
	@Autowired
	private 	AsistenciaServiceImpl asistenciaServiceImpl;
	
	
	@GetMapping("/ListAsis")
	public ResponseEntity<List<Asistencia>> listar() {
		try {
		      List<Asistencia> alq = asistenciaServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("BuscarAsis/{id}")
	public ResponseEntity<Asistencia> getAlumnoById(@PathVariable("id") int id){
		Optional<Asistencia> carData = asistenciaServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Asistencia>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/InsertAsis")
    public ResponseEntity<Asistencia> crear(@Valid @RequestBody AsistenciaDto alumno){
        try {
        	Asistencia _alq = asistenciaServiceImpl.guardarAsistencia(alumno);
            return new ResponseEntity<Asistencia>(_alq, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	

	@DeleteMapping("DeleteAsis/{id}")
	public ResponseEntity<Asistencia> delete(@PathVariable("id") int id){
		try {
			asistenciaServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidAlum/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody AsistenciaDto asistencia){
		Optional<Asistencia> carData = asistenciaServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Asistencia dbalumno = carData.get();
	    	  
	    	  dbalumno.setCalificacion(asistencia.getCalificacion());
	    	  dbalumno.setCalificacion(asistencia.getCalificacion());
	    	  dbalumno.setCalificacion(asistencia.getCalificacion());
	    	  dbalumno.setCalificacion(asistencia.getCalificacion());

	    	  
	    		
	    	    
	        
	        return new ResponseEntity<Asistencia>(asistenciaServiceImpl.update(dbalumno), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}