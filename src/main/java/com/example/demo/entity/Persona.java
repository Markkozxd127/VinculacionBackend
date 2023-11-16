	package com.example.demo.entity;
	
	
	
	
	
	
	
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;
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
	@Table(name="PERSONA")
	public class Persona {
		@Id
		@Column(name = "ID_PERSONA")
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPersona")
	    @SequenceGenerator(name = "seqPersona", allocationSize = 1, sequenceName = "SEQ_PERSONA")
	    private Integer id;
		
		@Column(name = "NOMBRE")
		@NotNull @NotBlank    
	    private String nombre;
		
		@Column(name = "APELLIDO")
		@NotNull @NotBlank    
	    private String apellido;
		
		@Column(name = "DNI")
		@NotNull @NotBlank    
	    private String dni;
		
		@Column(name = "TELEFONO")
		@NotNull @NotBlank    
	    private String telefono;
		
		@Column(name = "CORREO")
		@NotNull @NotBlank    
	    private String correo;
	
	
	//TODO RELACIONES 	
	    // Relación uno a uno con Alumno
	    //@OneToOne(mappedBy = "persona")
	    //private Alumno alumno;
		
	    // Relación uno a uno con Cordinadora
	    @OneToOne(mappedBy = "persona")
	    private Cordinadora cordinadora;
	    
	    // Relación uno a uno con Usuario
	    @OneToOne(mappedBy = "persona")
	   private Usuario usuario;
	 
	}
