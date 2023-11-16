package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Proyecto_RolDto;
import com.example.demo.entity.Proyecto_Rol;
import com.example.demo.serviceImpl.Proyecto_RolServiceImpl;

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

import static com.example.demo.commons.GlobalConstans.API_PROYECTOROL;

@RestController
@RequestMapping(API_PROYECTOROL)
@CrossOrigin({"*"})

public class Proyecto_RolController {
	@Autowired
	private Proyecto_RolServiceImpl proyecto_RolServiceImpl;
	
	
	@GetMapping("/ListPyrol")
	public ResponseEntity<List<Proyecto_Rol>> listar() {
		try {
		      List<Proyecto_Rol> alq = proyecto_RolServiceImpl.readAll();
		      if (alq.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(alq, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("BuscarPyrol/{id}")
	public ResponseEntity<Proyecto_Rol> getProyecto_RolById(@PathVariable("id") int id){
		Optional<Proyecto_Rol> carData = proyecto_RolServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Proyecto_Rol>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	@PostMapping("/InsertPyrol")
    public ResponseEntity<Proyecto_Rol> crear(@Valid @RequestBody Proyecto_RolDto proyecto_RolDto){
        try {
        	Proyecto_Rol _alq = proyecto_RolServiceImpl.guardarProyecto_Rol(proyecto_RolDto);
            return new ResponseEntity<Proyecto_Rol>(_alq, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	

	@DeleteMapping("DeletePyrol/{id}")
	public ResponseEntity<Proyecto_Rol> delete(@PathVariable("id") int id){
		try {
			proyecto_RolServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	
	@PutMapping("EdidPyrol/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody Proyecto_Rol proyecto_Rol){
		Optional<Proyecto_Rol> carData = proyecto_RolServiceImpl.read(id);
	      if (carData.isPresent()) {
	    	  Proyecto_Rol dbproyecto_Rol = carData.get();
	    	  dbproyecto_Rol.setHoras(proyecto_Rol.getHoras());
	    	  dbproyecto_Rol.setDetalles(proyecto_Rol.getDetalles());

	        
	        return new ResponseEntity<Proyecto_Rol>(proyecto_RolServiceImpl.update(dbproyecto_Rol), HttpStatus.OK);
	      } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	      }
	}
}