package com.example.demo.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               
@AllArgsConstructor 
@NoArgsConstructor  
public class AsistenciaDto {

	    private String calificacion;	    	     
	     private String nota;	    
	    private String horas_realizadas;	  
	     private String estado_asistencia;	    	     
	     private String estado;

	    
	    private int jornada;		
	    private int equipoAlumno;

}  
