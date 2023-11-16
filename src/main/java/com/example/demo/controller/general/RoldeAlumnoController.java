package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RoldeAlumno;
import com.example.demo.serviceImpl.RoldeAlumnoServiceImpl;

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

import static com.example.demo.commons.GlobalConstans.API_ROLDEALUMNO;

@RestController
@RequestMapping(API_ROLDEALUMNO)
@CrossOrigin({"*"})

public class RoldeAlumnoController {
	@Autowired
	private RoldeAlumnoServiceImpl roldeAlumnoServiceImpl;
	
	
	@GetMapping("/ListRoldeAlumno")
	public ResponseEntity<List<RoldeAlumno>> listar() {
		try {
		      List<RoldeAlumno> alq = roldeAlumnoServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("BuscarRoldeAlumno/{id}")
	public ResponseEntity<RoldeAlumno> getRoldeAlumnoById(@PathVariable("id") int id){
		Optional<RoldeAlumno> carData = roldeAlumnoServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<RoldeAlumno>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/InsertRoldeAlumno")
    public ResponseEntity<RoldeAlumno> crear(@Valid @RequestBody RoldeAlumno roldeAlumno){
        try {
        	RoldeAlumno _alq = roldeAlumnoServiceImpl.create(roldeAlumno);
            return new ResponseEntity<RoldeAlumno>(_alq, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	

	@DeleteMapping("DeleteRoldeAlumno/{id}")
	public ResponseEntity<RoldeAlumno> delete(@PathVariable("id") int id){
		try {
			roldeAlumnoServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidRoldeAlumno/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody RoldeAlumno roldeAlumno){
		Optional<RoldeAlumno> carData = roldeAlumnoServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  RoldeAlumno dbroldeAlumno = carData.get();
	    	  dbroldeAlumno.setNombrerol(roldeAlumno.getNombrerol());
	 
	        
	        return new ResponseEntity<RoldeAlumno>(roldeAlumnoServiceImpl.update(dbroldeAlumno), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}