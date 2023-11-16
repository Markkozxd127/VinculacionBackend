package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EquipoDto;
import com.example.demo.entity.Equipo;
import com.example.demo.serviceImpl.EquipoServiceImpl;

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
	
	
	@GetMapping("BuscarEqui/{id}")
	public ResponseEntity<Equipo> getEquipoById(@PathVariable("id") int id){
		Optional<Equipo> carData = equipoServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Equipo>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/InsertEqui")
    public ResponseEntity<Equipo> crear(@Valid @RequestBody EquipoDto equipoDto){
        try {
        	Equipo _alq = equipoServiceImpl.guardarEquipo(equipoDto);
            return new ResponseEntity<Equipo>(_alq, HttpStatus.CREATED);
          } catch (Exception e) {
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
	
	
	@PutMapping("EdidEqui/{id}")
	public ResponseEntity<?> updateCarrera(@PathVariable("id") int id, @Valid @RequestBody Equipo equipo){
		Optional<Equipo> carData = equipoServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Equipo dbequipo = carData.get();
	    	  dbequipo.setNombre_equipo(equipo.getNombre_equipo());
	    	  dbequipo.setArchivo_informe(equipo.getArchivo_informe());

	        
	        return new ResponseEntity<Equipo>(equipoServiceImpl.update(dbequipo), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}