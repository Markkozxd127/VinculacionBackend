package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               
@AllArgsConstructor 
@NoArgsConstructor  
public class Proyecto_RolDto {

	
private String horas; // Un campo que representa el nombre del convenio.
    

private String detalles; // Un campo que representa el nombre del convenio.

    private int proyecto;     // Un campo que representa el tipo de convenio (se espera un entero).
    private int roldeAlumno;     // Un campo que representa el tipo de convenio (se espera un entero).

}
