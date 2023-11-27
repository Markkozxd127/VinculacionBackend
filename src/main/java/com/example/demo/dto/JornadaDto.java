package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               
@AllArgsConstructor 
@NoArgsConstructor  
public class JornadaDto {
	
    private String nombreJornada; 
    private String fecha; 
    private String URL;
    private int proyecto;

	
}
