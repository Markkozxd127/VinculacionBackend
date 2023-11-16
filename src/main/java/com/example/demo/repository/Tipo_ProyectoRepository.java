package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Tipo_Proyecto;
@Repository
public interface Tipo_ProyectoRepository extends JpaRepository<Tipo_Proyecto, Integer>{

}