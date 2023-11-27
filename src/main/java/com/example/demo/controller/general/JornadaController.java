package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.JornadaDto;
import com.example.demo.entity.Jornada;
import com.example.demo.entity.Proyecto;
import com.example.demo.serviceImpl.JornadaServiceImpl;
import com.example.demo.serviceImpl.ProyectoServiceImpl;

import jakarta.validation.Valid;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	@GetMapping("/searchByProyecto/{id}")
	public ResponseEntity<List<Map<String, Object>>> jornadaByProyecto(@PathVariable("id") int id) {
		try {
			List<Map<String, Object>> alq = jornadaServiceImpl.searchByProyectoJornada(id);
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@GetMapping("/ListJornadas/{idProyecto}")
	public ResponseEntity<List<Map<String, Object>>> listarJornadasPorProyecto(@PathVariable("idProyecto") int idProyecto) {
	    try {
	    	System.out.println(idProyecto);
	    	List<Map<String, Object>> list = jornadaServiceImpl.buscarPorProyecto(idProyecto);
	        if (list.isEmpty()) {
	            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NO_CONTENT);
	        } else {
	        	return new ResponseEntity<>(list, HttpStatus.OK);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/ListJornadasPersonas/{id}")
	public ResponseEntity<List<Map<String, Object>>> listarJornadasPorPersonas(@PathVariable("id") int id) {
	    try {
	    	List<Map<String, Object>> list = jornadaServiceImpl.searchByPersona(id);
	        if (list.isEmpty()) {
	            return new ResponseEntity<>(Collections.emptyList(),HttpStatus.NO_CONTENT);
	        } else {
	        	return new ResponseEntity<>(list, HttpStatus.OK);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@GetMapping("/BuscarJor/{id}")
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
	    	System.out.println(jornadaDto.getURL());
	        Jornada _alq = jornadaServiceImpl.guardarJornada(jornadaDto);
	        return new ResponseEntity<>(_alq, HttpStatus.CREATED);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	

	@DeleteMapping("/DeleteJor/{id}")
	public ResponseEntity<Jornada> delete(@PathVariable("id") int id){
		try {
			jornadaServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	

	
    @PutMapping("/EdidJor/{id}")
    public ResponseEntity<Jornada> updateJornada(@PathVariable("id") int id, @Valid @RequestBody JornadaDto jornadaDto) {
        try {
        	Jornada updatedJornada = jornadaServiceImpl.update(id, jornadaDto);
            return new ResponseEntity<>(updatedJornada, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}