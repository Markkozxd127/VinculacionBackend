package com.example.demo.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="PROYECTO_ROL")
public class Proyecto_Rol{
	
	@Id
	@Column(name = "ID_PROYECTO_ROL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProyecto_Rol")
    @SequenceGenerator(name = "seqProyecto_Rol", allocationSize = 1, sequenceName = "SEQ_PROYECTO_ROL")
    private Integer id;
	
	@Column(name = "HORAS")
	@NotNull @NotBlank    
    private String horas;
	
	@Column(name = "DETALLES")
	@NotNull @NotBlank    
    private String detalles;
	
//TODO RELACIONES 	
	
	//RELACION PROYECTO_ROL Y PROYECTO 
	@ManyToOne
    @JoinColumn(name="ID_PROYECTO", nullable = false)
    private Proyecto proyecto;
	
	//RELACION PROYECTO_ROL Y ROLDEALUMNO
	@ManyToOne
    @JoinColumn(name="ID_ROLDEALUMNO", nullable = false)
    private RoldeAlumno roldeAlumno;
	
	//RELACION DE PROYECTO CON EQUIPO_ALUMNO
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "proyecto_Rol")
	@JsonIgnore
	private Set<Equipo_Alumno> equipo_alumnos;
	
	
	
	
}
