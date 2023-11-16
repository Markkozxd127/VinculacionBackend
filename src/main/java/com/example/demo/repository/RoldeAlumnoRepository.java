package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RoldeAlumno;
@Repository
public interface RoldeAlumnoRepository extends JpaRepository<RoldeAlumno, Integer>{

}