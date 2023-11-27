package com.example.demo.repository;

import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Jornada;
@Repository
public interface JornadaRepository extends JpaRepository<Jornada, Integer>{
	@Query(value = "select j.*\r\n"
			+ "from proyecto p \r\n"
			+ "join jornada j on p.id_proyecto = j.id_proyecto\r\n"
			+ "where j.id_proyecto = ?", nativeQuery = true)
	List<Map<String, Object>> searchByProyecto(int id);
	
	@Query(value = "SELECT J.NOMBRE_JORNADA, J.FECHA, P.OBJETIVO, P.DESCIPCION\r\n"
			+ "FROM PROYECTO P\r\n"
			+ "JOIN JORNADA J ON J.ID_PROYECTO = P.ID_PROYECTO WHERE J.ID_JORNADA = ?", nativeQuery = true)
	List<Map<String, Object>> jornadaByProyecto(int id);
	
	@Query(value = "SELECT P.NOMBRE, P.APELLIDO, A.CODIGO_ALUMNO, RA.NOMBRE_ROL\r\n"
			+ "FROM JORNADA J\r\n"
			+ "JOIN EQUIPO E ON J.ID_JORNADA = E.ID_JORNADA\r\n"
			+ "JOIN EQUIPO_ALUMNO EA ON EA.ID_EQUIPO = E.ID_EQUIPO\r\n"
			+ "JOIN ALUMNO A ON EA.ID_ALUMNO = A.ID_ALUMNO\r\n"
			+ "JOIN PERSONA P ON P.ID_PERSONA = A.ID_ALUMNO\r\n"
			+ "JOIN PROYECTO_ROL PR ON PR.ID_PROYECTO_ROL = EA.ID_PROYECTO_ROL\r\n"
			+ "JOIN ROLDEALUMNO RA ON RA.ID_ROLDEALUMNO = PR.ID_ROLDEALUMNO\r\n"
			+ "WHERE J.ID_JORNADA = ?", nativeQuery = true)
	List<Map<String, Object>> jornadaByPersona(int id);
}	