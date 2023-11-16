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
@Table(name="EQUIPO")
public class Equipo {
	@Id
	@Column(name = "ID_EQUIPO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEquipo")
    @SequenceGenerator(name = "seqEquipo", allocationSize = 1, sequenceName = "SEQ_EQUIPO")
    private Integer id;
	
    @Column(name = "NOMBRE_EQUIPO")
	@NotNull @NotBlank    
    private String nombre_equipo;
    
    @Column(name = "ARCHIVO_INFORME")
 	@NotNull @NotBlank    
     private String archivo_informe;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "equipos")
	@JsonIgnore
	private Set<Equipo_Alumno> equipo_alumnos;
    
//TODO RELACIONES 	
	
	
	
//--------BORRAR
	  // Relación ManyToOne desde Equipo hacia Jornada
   // @ManyToOne
  //  @JoinColumn(name = "ID_JORNADA", nullable = false)
    //private Jornada jornada;
    
    
    
    //AGREGAR
    
    @ManyToOne
    @JoinColumn(name = "ID_PROYECTO", nullable = false)
    private Proyecto proyecto;

}

