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
@Table(name="JORNADA")
public class Jornada {
	@Id
	@Column(name = "ID_JORNADA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqJornada")
    @SequenceGenerator(name = "seqJornada", allocationSize = 1, sequenceName = "SEQ_JORNADA")
    private Integer id;
	
	@Column(name = "NOMBRE_JORNADA")
	@NotNull @NotBlank    
    private String nombreJornada;
	
	@Column(name = "fecha")
	@NotNull @NotBlank    
    private String fecha;


//TODO RELACIONES 	

	
	@ManyToOne
    @JoinColumn(name="ID_PROYECTO", nullable = false)
    private Proyecto proyecto;
		
	//--------BORRAR
    // Relación OneToMany desde Jornada hacia Equipo
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jornada")
    //@JsonIgnore
    //private Set<Equipo> equipos;
    
    
    //AGREGAR
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "jornada")
    @JsonIgnore
    private Set<Asistencia> asistencias;

    
 
}
