package com.example.demo.controller.general;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProyectoDto;
import com.example.demo.entity.Proyecto;
import com.example.demo.serviceImpl.ProyectoServiceImpl;

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

import static com.example.demo.commons.GlobalConstans.API_PROYECTO;

@RestController
@RequestMapping(API_PROYECTO)
@CrossOrigin({"*"})

public class ProyectoController {
	@Autowired
	private ProyectoServiceImpl proyectoServiceImpl;
	
	
	
	
	
	 //@GetMapping("/DetallesProyecto/{id}")
//	    public ResponseEntity<Proyecto> getProyectoWithDetails(@PathVariable("id") int id) {
	   //     try {
	      //      Proyecto proyecto = proyectoServiceImpl.findProyectoWithDetails(id);
	     //       if (proyecto != null) {
	      //          return new ResponseEntity<>(proyecto, HttpStatus.OK);
	//            } else {
	    //            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     //       }
	   //     } catch (Exception e) {
	   //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	      //  }
	    //}
	
	
	
	
	
	
	
	@GetMapping("/ListProyecto")
	public ResponseEntity<List<Proyecto>> listar() {
		try {
		      List<Proyecto> pro = proyectoServiceImpl.readAll();
		      if (pro.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(pro, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}
	
	
	@GetMapping("/BuscarProyecto/{id}")
	public ResponseEntity<Proyecto> getProyectoById(@PathVariable("id") int id){
		Optional<Proyecto> carData = proyectoServiceImpl.read(id);
	    if (carData.isPresent()) {
	      return new ResponseEntity<Proyecto>(carData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/Semester/{id_semestre}")
	public ResponseEntity<List<Proyecto>> getSemestreProyecto(@PathVariable("id_semestre") int id_semestre){
		List<Proyecto> carData = proyectoServiceImpl.findSemesterProyecto(id_semestre);
	    if (carData.isEmpty()) {
	      return new ResponseEntity<>(carData, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PostMapping("/InsertProyecto")
    public ResponseEntity<Proyecto> crear(@Valid @RequestBody ProyectoDto proyectoDto){
        try {
    
            Proyecto _pro = proyectoServiceImpl.guardarProyecto(proyectoDto);
            return new ResponseEntity<Proyecto>(_pro, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
	
	
	
	
	
	@DeleteMapping("DeleteProyecto/{id}")
	public ResponseEntity<Proyecto> delete(@PathVariable("id") int id){
		try {
			proyectoServiceImpl.delete(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	
	

	@PutMapping("/EdidProyecto/{id}")
    public ResponseEntity<Proyecto> updatedProyecto(@PathVariable("id") int id, @Valid @RequestBody ProyectoDto proyectoDto) {
        try {
        	Proyecto updatedProyecto= proyectoServiceImpl.update(id, proyectoDto);
            return new ResponseEntity<>(updatedProyecto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}