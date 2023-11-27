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
@Table(name="TIPO_PROYECTO")
public class Tipo_Proyecto {
	@Id
	@Column(name = "ID_TIPO_PROYECTO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTipo_Proyecto")
    @SequenceGenerator(name = "seqTipo_Proyecto", allocationSize = 1, sequenceName = "SEQ_TIPO_PROYECTO")
    private Integer id;
	
	@Column(name = "TIPO_PROYECTO")
	@NotNull @NotBlank    
    private String tipoProyecto;
	
//TODO RELACIONES 
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tipo_Proyecto")
	@JsonIgnore
	private Set<Proyecto> proyectos;

	public Tipo_Proyecto(Integer id) {
		super();
		this.id = id;
	}
	
	
}
