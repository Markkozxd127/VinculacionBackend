package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data               
@AllArgsConstructor 
@NoArgsConstructor  
public class Equipo_AlumnoDto {

	
    
    private String calificacion;
    
     private String nota;
    
   
    private String horas_realizadas;
     
     private String estado_asistencia;
     
     
     private int equipo;   

     private int proyecto_Rol;     // Un campo que representa el tipo de convenio (se espera un entero).

     private int alumno ;     
     
     // Un campo que representa el tipo de convenio (se espera un entero).
// Un campo que representa el tipo de convenio (se espera un entero).

}
