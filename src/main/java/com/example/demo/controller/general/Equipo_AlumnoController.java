package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Equipo_AlumnoDto;
import com.example.demo.entity.Equipo_Alumno;
import com.example.demo.serviceImpl.Equipo_AlumnoServiceImpl;

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

import static com.example.demo.commons.GlobalConstans.API_EQUIPOALUMNO;

@RestController
@RequestMapping(API_EQUIPOALUMNO)
@CrossOrigin({"*"})

public class Equipo_AlumnoController {
	@Autowired
	private Equipo_AlumnoServiceImpl equipo_AlumnoServiceImpl;
	
	
	@GetMapping("/ListEA")
	public ResponseEntity<List<Equipo_Alumno>> listar() {
		try {
		      List<Equipo_Alumno> alq = equipo_AlumnoServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("BuscarEA/{id}")
	public ResponseEntity<Equipo_Alumno> getEquipo_AlumnoById(@PathVariable("id") int id){
		Optional<Equipo_Alumno> carData = equipo_AlumnoServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Equipo_Alumno>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	

    
    
	@PostMapping("/InsertEA")
	public ResponseEntity<Equipo_Alumno> crear(@Valid @RequestBody Equipo_AlumnoDto equipo_AlumnoDto) {
	    try {
	    	Equipo_Alumno _alq = equipo_AlumnoServiceImpl.guardarEquipo_Alumno(equipo_AlumnoDto);
	        return new ResponseEntity<Equipo_Alumno>(_alq, HttpStatus.CREATED);
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	
	
	
	@DeleteMapping("DeleteAlumno/{id}")
	public ResponseEntity<Equipo_Alumno> delete(@PathVariable("id") int id){
		try {
			equipo_AlumnoServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidAlumno/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody Equipo_Alumno equipoa){
		Optional<Equipo_Alumno> carData = equipo_AlumnoServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  
	    	  Equipo_Alumno dbequipoa = carData.get();
	    

	 

	        
	        return new ResponseEntity<Equipo_Alumno>(equipo_AlumnoServiceImpl.update(dbequipoa), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}