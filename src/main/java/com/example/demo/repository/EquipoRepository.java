package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Equipo;
@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer>{
	
	@Query(value = "select e.*\r\n"
			+ "from jornada j join equipo e on j.id_jornada =e.id_jornada\r\n"
			+ "where  j.id_jornada=?", nativeQuery = true)
	List<Equipo> getEquipos(int id);
	
	@Query(value = "SELECT EA.ID_EQUIPO_ALUMNO,P.NOMBRE, P.APELLIDO, RA.NOMBRE_ROL ,EA.NOTA, EA.CALIFICACION,EA.HORAS_REALIZADAS,EA.ESTADO,EA.ESTADO_ASISTENCIA\r\n"
			+ "FROM JORNADA J\r\n"
			+ "JOIN EQUIPO E ON J.ID_JORNADA = E.ID_JORNADA\r\n"
			+ "JOIN EQUIPO_ALUMNO EA ON EA.ID_EQUIPO = E.ID_EQUIPO\r\n"
			+ "JOIN ALUMNO A ON EA.ID_ALUMNO = A.ID_ALUMNO\r\n"
			+ "JOIN PERSONA P ON P.ID_PERSONA = A.ID_ALUMNO\r\n"
			+ "JOIN PROYECTO_ROL PR ON PR.ID_PROYECTO_ROL = EA.ID_PROYECTO_ROL\r\n"
			+ "JOIN ROLDEALUMNO RA ON RA.ID_ROLDEALUMNO = PR.ID_ROLDEALUMNO\r\n"
			+ "WHERE E.ID_EQUIPO = ?", nativeQuery = true)
	List<Map<String, Object>> getInformes(int id);
	
	@Query(value = "INSERT INTO EQUIPO (ID_EQUIPO, ARCHIVO_INFORME, NOMBRE_EQUIPO, ID_JORNADA, HORAS) "
			+ "VALUES (PYMARKPING.SEQ_EQUIPO.NEXTVAL, :archivo, :nombreEquipo, :idJornada, :horas)", nativeQuery = true)
void insertEquipo(@Param("archivo") String archivo, @Param("nombreEquipo") String nombre_equipo, 
                  @Param("idJornada") int id_jornada, @Param("horas") int horas);


}