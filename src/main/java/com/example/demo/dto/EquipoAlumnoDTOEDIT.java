package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EquipoAlumnoDTOEDIT {
	// DTO
	private String calificacion;
	private String estado;
	private String estado_asistencia;
	private String horas_realizadas;
	private String nota;

 
}
