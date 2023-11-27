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
@Table(name="PROYECTO")
public class Proyecto {
	@Id
	@Column(name = "ID_PROYECTO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProyecto")
    @SequenceGenerator(name = "seqProyecto", allocationSize = 1, sequenceName = "SEQ_PROYECTO")
    private Integer id;
	
	@Column(name = "NOMBRE_PROYECTO")
	@NotNull @NotBlank    
    private String nombreproyecto;
	
	@Column(name = "Descipcion")
	@NotNull @NotBlank    
    private String descripcion;
	
	@Column(name = "FECHA_INICIO")
	@NotNull @NotBlank    
    private String fecha_inicio;
	
	@Column(name = "FECHA_FIN")
	@NotNull @NotBlank    
    private String fecha_fin;
	
	@Column(name = "NUMERO_BENE")
	@NotNull @NotBlank    
    private String numero_bene;
	
	@Column(name = "LOCALIDAD")
	@NotNull @NotBlank    
    private String localidad;
	
	@Column(name = "OBJETIVO")
	@NotNull @NotBlank    
    private String objetivo;
	
	@Column(name = "DOCUMENTO")
	@NotNull @NotBlank    
    private String documento;
	
	@Column(name = "ESTADO")
	@NotNull @NotBlank    
    private String estado;
	
	
	
//TODO RELACIONES 
	
		//RELACION ENTRE PROYECTO Y CONVENIO
		@ManyToOne
		@JoinColumn(name="ID_CONVENIO", nullable = false)
		private Convenio  convenio;	

		//RELACION PROYECTO Y TIPO_PROYECTO
		@ManyToOne
	    @JoinColumn(name="ID_TIPO_PROYECTO", nullable = false)
	    private Tipo_Proyecto tipo_Proyecto;
		
		//RELACION ENTRE PROYECTO Y SEMESTRE
		@ManyToOne
		@JoinColumn(name="ID_SEMESTRE", nullable = false)
		private Semestre  semestre ;	
		
	//	@ManyToOne
		//@JoinColumn(name = "CORDINADORA_ID", nullable = false)
		//private Cordinadora cordinadora;

		
		//RELACION ENTRE PROYECTO Y ESCUELA_PROFECIONAL
		@ManyToOne
		@JoinColumn(name="ID_ESCUELA_PROFECIONAL", nullable = false)
		private Escuela_Profecional   escuelaProfecional  ;	
		
		//----------------------one to many----------------------------
		
		//RELACION ENTRE PROYECTO Y JORNADA 
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "proyecto")
		@JsonIgnore
		private Set<Jornada> jornadas;
    
		
		//RELACION ENTRE PROYECTO Y PROYECTO_ROL 
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "proyecto")
		@JsonIgnore
		private Set<Proyecto_Rol> proyecto_rol;


		public Proyecto(Integer id, @NotNull @NotBlank String nombreproyecto) {
			super();
			this.id = id;
			this.nombreproyecto = nombreproyecto;
		}
		
		


		

}
