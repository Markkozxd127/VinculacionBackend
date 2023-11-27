package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               
@AllArgsConstructor 
@NoArgsConstructor  
public class EquipoDto {
	private String nombre_equipo; // Un campo que representa el nombre del convenio.
	private String archivo_informe; // Un campo que representa el nombre del convenio.
	private int hora;
	private int jornada;     // Un campo que representa el tipo de convenio (se espera un entero).
	
	
}
