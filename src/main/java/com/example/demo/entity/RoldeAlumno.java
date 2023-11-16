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
@Table(name="ROLDEALUMNO")
public class RoldeAlumno {
	@Id
	@Column(name = "ID_ROLDEALUMNO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRoldeAlumno")
    @SequenceGenerator(name = "seqRoldeAlumno", allocationSize = 1, sequenceName = "SEQ_ROLDEALUMNO")
    private Integer id;
	
	@Column(name = "NOMBRE_ROL")
	@NotNull @NotBlank    
    private String nombrerol;

	
//TODO RELACIONES 	

	//RELACION ENTRE ROLDEALUMNO Y PROYECTO_ROL 
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "roldeAlumno")
	@JsonIgnore
	private Set<Proyecto_Rol> proyecto_rol;
}
