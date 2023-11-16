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
@Table(name="ALUMNO")
public class Alumno {
	@Id
	@Column(name = "ID_ALUMNO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAlumno")
    @SequenceGenerator(name = "seqAlumno", allocationSize = 1, sequenceName = "SEQ_ALUMNO")
    private Integer id;
	
	@Column(name = "CODIGO_ALUMNO")
	@NotNull @NotBlank    
    private String codigo_alumno;

//TODO RELACIONES 	

	//RELACION DE EQUIPO CON EQUIPO_ALUMNO
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "alumnos")
	@JsonIgnore
	private Set<Equipo_Alumno> equipo_alumnos;
	
    // Relación uno a uno con Persona
    //@OneToOne
    //@JoinColumn(name = "PERSONA_ID", referencedColumnName = "ID_PERSONA")
    //private Persona persona;
}
