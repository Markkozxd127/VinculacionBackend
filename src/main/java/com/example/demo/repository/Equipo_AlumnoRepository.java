package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Equipo_Alumno;
@Repository
public interface Equipo_AlumnoRepository extends JpaRepository<Equipo_Alumno, Integer>{
	
	   @Modifying
	    @Query(value = "UPDATE EQUIPO_ALUMNO " +
	    		"SET CALIFICACION = :calificacion, " +
	    		"    ESTADO = :estado, " +
	    		"    ESTADO_ASISTENCIA = :estadoAsistencia, " +
	    		"    HORAS_REALIZADAS = :horasRealizadas, " +
	    		"    NOTA = :nota " +
	            "WHERE ID_EQUIPO_ALUMNO = :idEquipoAlumno", nativeQuery = true)
	    void updateEquipoAlumno(
	            @Param("calificacion") String calificacion,
	            @Param("estado") String estado,
	            @Param("estadoAsistencia") String estadoAsistencia,
	            @Param("horasRealizadas") String horasRealizadas,
	            @Param("nota") String nota,
	            @Param("idEquipoAlumno") int idEquipoAlumno);
	}