package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Equipo_Alumno;
@Repository
public interface Equipo_AlumnoRepository extends JpaRepository<Equipo_Alumno, Integer>{

}