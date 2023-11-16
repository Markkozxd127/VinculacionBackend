package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               
@AllArgsConstructor 
@NoArgsConstructor  
public class ProyectoDto {

	
    private String nombreproyecto; 
    private String descripcion; 
    private String fecha_inicio; 
    private String fecha_fin; 
    private String numero_bene; 
    private String localidad; 
    private String objetivo; 
    private String documento; 
    private String estado; 


    
    private int convenio;
    private int tipo_Proyecto;
    private int semestre;
   // private int cordinadora;
    private int escuelaProfecional;


}
