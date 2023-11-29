package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EquipoAlumnoDTOEDIT;
import com.example.demo.dto.EquipoDto;
import com.example.demo.entity.Equipo;
import com.example.demo.serviceImpl.EquipoServiceImpl;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
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

import static com.example.demo.commons.GlobalConstans.API_EQUIPO;

@RestController
@RequestMapping(API_EQUIPO)
@CrossOrigin({"*"})

public class EquipoController {
	@Autowired
	private EquipoServiceImpl equipoServiceImpl;
	
	
	@GetMapping("/ListEqui")
	public ResponseEntity<List<Equipo>> listar() {
		try {
		      List<Equipo> alq = equipoServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	@GetMapping("/ListEquiJor/{id}")
	public ResponseEntity<List<Equipo>> listarEquipoByJornada(@PathVariable("id") int id) {
		try {
		      List<Equipo> alq = equipoServiceImpl.getEquipoByJornada(id);
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("/BuscarEqui/{id}")
	public ResponseEntity<Equipo> getEquipoById(@PathVariable("id") int id){
		Optional<Equipo> carData = equipoServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Equipo>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/informe/{id}")
	public ResponseEntity<List<Map<String, Object>>> getInforme(@PathVariable("id") int id){
		List<Map<String, Object>> carData = equipoServiceImpl.getInforme(id);
		return new ResponseEntity<>(carData, HttpStatus.OK);
	}
	
	
	@PostMapping("/InsertEqui")
    public ResponseEntity<Integer> crear(@RequestBody EquipoDto equipoDto){
        try {
        	equipoServiceImpl.guardarEquipo(equipoDto);
            return new ResponseEntity<Integer>(1, HttpStatus.CREATED);
          } catch (Exception e) {
        	  System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	

	@DeleteMapping("DeleteEqui/{id}")
	public ResponseEntity<Equipo> delete(@PathVariable("id") int id){
		try {
			equipoServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	 @PutMapping("/EdidEqui/{id}")
	    public ResponseEntity<Equipo> updateEquipo(@PathVariable("id") int id, @Valid @RequestBody EquipoDto equipoDto) {
	        try {
	        	Equipo updatedEquipo = equipoServiceImpl.update(id, equipoDto);
	            return new ResponseEntity<>(updatedEquipo, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	}