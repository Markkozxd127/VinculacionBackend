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
@Table(name="EQUIPO_ALUMNO")
public class Equipo_Alumno {
	@Id
	@Column(name = "ID_EQUIPO_ALUMNO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEquipo_Alumno")
    @SequenceGenerator(name = "seqEquipo_Alumno", allocationSize = 1, sequenceName = "SEQ_EQUIPO_ALUMNO")
    private Integer id;
	
   @Column(name = "CALIFICION")
	@NotNull @NotBlank    
    private String calificacion;

    @Column(name = "NOTA")
 	@NotNull @NotBlank     
     private String nota;
    
	 @Column(name = "HORAS_REALIZADAS")
    @NotNull @NotBlank    
	 private String horas_realizadas;
    
	    @Column(name = "ESTADOS_REALIZADAS")
	 @NotNull @NotBlank    
 	  private String estado_asistencia;
    
	 @Column(name = "ESTADO")
	 @NotNull @NotBlank    
	  private String estado;
    
  //TODO RELACIONES 	
    
	//RELACION DE  EQUIPO_ALUMNO CON EQUIPOS 
	@ManyToOne
	@JoinColumn(name="ID_EQUIPO", nullable = false)
	private Equipo equipos;
	
	//RELACION DE  EQUIPO_ALUMNO CON ALUMNOS 
	@ManyToOne
	@JoinColumn(name="ID_ALUMNO", nullable = false)
	private Alumno alumnos;
	

	//RELACION DE  EQUIPO_ALUMNO CON PROYECTO_ROL 
	@ManyToOne
    @JoinColumn(name="ID_PROYECTO_ROL", nullable = false)
    private Proyecto_Rol  proyecto_Rol;





}



	



