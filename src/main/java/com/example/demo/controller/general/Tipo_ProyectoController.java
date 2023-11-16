package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Tipo_Proyecto;
import com.example.demo.serviceImpl.Tipo_ProyectoServiceImpl;

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

import static com.example.demo.commons.GlobalConstans.API_TIPO_PROYECTO;

@RestController
@RequestMapping(API_TIPO_PROYECTO)
@CrossOrigin({"*"})

public class Tipo_ProyectoController {
	@Autowired
	private Tipo_ProyectoServiceImpl tipo_ProyectoServiceImpl;
	
	
	@GetMapping("/ListTipoP")
	public ResponseEntity<List<Tipo_Proyecto>> listar() {
		try {
		      List<Tipo_Proyecto> alq = tipo_ProyectoServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("BuscarTipoP/{id}")
	public ResponseEntity<Tipo_Proyecto> getTipo_ConvenioById(@PathVariable("id") int id){
		Optional<Tipo_Proyecto> carData = tipo_ProyectoServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Tipo_Proyecto>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/InsertTipoP")
    public ResponseEntity<Tipo_Proyecto> crear(@Valid @RequestBody Tipo_Proyecto tipo_Proyecto){
        try {
        	Tipo_Proyecto _alq = tipo_ProyectoServiceImpl.create(tipo_Proyecto);
            return new ResponseEntity<Tipo_Proyecto>(_alq, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	

	@DeleteMapping("DeleteTipoP/{id}")
	public ResponseEntity<Tipo_Proyecto> delete(@PathVariable("id") int id){
		try {
			tipo_ProyectoServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidTipoP/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody Tipo_Proyecto tipo_Proyecto){
		Optional<Tipo_Proyecto> carData = tipo_ProyectoServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Tipo_Proyecto dbtipo_Convenio = carData.get();
	    	  dbtipo_Convenio.setTipoProyecto(tipo_Proyecto.getTipoProyecto());
	 
	        
	        return new ResponseEntity<Tipo_Proyecto>(tipo_ProyectoServiceImpl.update(dbtipo_Convenio), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}