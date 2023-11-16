package com.example.demo.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="ASISTENCIA")
public class Asistencia {
	@Id
	@Column(name = "ID_ASISTENCIA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAsistencia")
    @SequenceGenerator(name = "seqAsistencia", allocationSize = 1, sequenceName = "SEQ_ASISTENCIA")
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
    
    @Column(name = "ESTADO_ASISSTENCIA")
 	@NotNull @NotBlank    
     private String estado_asistencia;
    
    @Column(name = "ESTADO")
 	@NotNull @NotBlank    
     private String estado;

    
    
//AGREGAR
    @ManyToOne
    @JoinColumn(name = "ID_JORNADA", nullable = false)
    private Jornada jornada;
	
    
    @ManyToOne
    @JoinColumn(name = "ID_EQUIPO_ALUMNO", nullable = false)
    private Equipo_Alumno equipoAlumno;


	
}
