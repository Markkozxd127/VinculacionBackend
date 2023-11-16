package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.JornadaDto;
import com.example.demo.entity.Jornada;
import com.example.demo.entity.Proyecto;
import com.example.demo.serviceImpl.JornadaServiceImpl;
import com.example.demo.serviceImpl.ProyectoServiceImpl;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import static com.example.demo.commons.GlobalConstans.API_JORNADA;

@RestController
@RequestMapping(API_JORNADA)
@CrossOrigin({"*"})

public class JornadaController {
	@Autowired
	private JornadaServiceImpl jornadaServiceImpl;
	
	@Autowired
	private ProyectoServiceImpl proyectoServiceImpl;
	@GetMapping("/ListJor")
	public ResponseEntity<List<Jornada>> listar() {
		try {
		      List<Jornada> alq = jornadaServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@GetMapping("/ListJornadas/{idProyecto}")
	public ResponseEntity<Set<Jornada>> listarJornadasPorProyecto(@PathVariable("idProyecto") int idProyecto) {
	    try {
	        Optional<Proyecto> proyecto = proyectoServiceImpl.read(idProyecto);
	        if (proyecto.isPresent()) {
	            Set<Jornada> jornadas = proyecto.get().getJornadas();
	            return new ResponseEntity<>(jornadas, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@GetMapping("BuscarJor/{id}")
	public ResponseEntity<Jornada> getJornadaById(@PathVariable("id") int id){
		Optional<Jornada> carData = jornadaServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Jornada>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/Insertjornadas")
	public ResponseEntity<Jornada> crear(@Valid @RequestBody JornadaDto jornadaDto) {
	    try {
	        Jornada _alq = jornadaServiceImpl.guardarJornada(jornadaDto);
	        return new ResponseEntity<>(_alq, HttpStatus.CREATED);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	

	@DeleteMapping("DeleteJor/{id}")
	public ResponseEntity<Jornada> delete(@PathVariable("id") int id){
		try {
			jornadaServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidJor/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody Jornada jornada){
		Optional<Jornada> carData = jornadaServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Jornada dbjornada = carData.get();
	    	  dbjornada.setNombreJornada(jornada.getNombreJornada());
	    	  dbjornada.setFecha(jornada.getFecha());
	     
	        return new ResponseEntity<Jornada>(jornadaServiceImpl.update(dbjornada), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}