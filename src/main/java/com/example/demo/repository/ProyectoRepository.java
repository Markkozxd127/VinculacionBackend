package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Proyecto;


@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer>{
	
	@Query(value = "select p* from proyecto p join semestre s on p.id_semestre = s.id_semestre where s.id_semestre = ? ", nativeQuery = true)
	List<Proyecto> getProyectoBySemestre(@Param("id_semestre") Integer id_semestre);
}