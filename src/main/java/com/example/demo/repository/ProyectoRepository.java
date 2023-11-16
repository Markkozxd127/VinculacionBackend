package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Proyecto;
@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer>{
    //@Query("SELECT p FROM Proyecto p JOIN FETCH p.jornadas j JOI+N FETCH j.equipos e JOIN FETCH e.equipo_alumnos ea JOIN FETCH ea.asistencias WHERE p.id = :proyectoId")
   // Proyecto findProyectoWithDetails(@Param("proyectoId") Integer proyectoId);
}