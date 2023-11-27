package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.EquipoDto;
import com.example.demo.entity.Equipo;
import com.example.demo.entity.Jornada;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EquipoRepository;
import com.example.demo.repository.JornadaRepository;
 import com.example.demo.service.EquipoService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;

@Service
public class EquipoServiceImpl implements EquipoService<Equipo>{
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	@Autowired
	private JornadaRepository jornadaRepository;
	 @PersistenceContext
	    private EntityManager entityManager;


	
	
	@Override
	public Equipo update(int id, EquipoDto equipoDto ) {
	    Optional<Equipo> optionalEquipo = equipoRepository.findById(id);

	    if (optionalEquipo.isPresent()) {
	    	Equipo equipo = optionalEquipo.get();
	    	equipo.setNombre_equipo(equipoDto.getNombre_equipo());
	    	equipo.setArchivo_informe(equipoDto.getArchivo_informe());	    
	    	equipo.setJornada(jornadaRepository.findById(equipoDto.getJornada()).orElse(null));
	        return equipoRepository.save(equipo);
	    } else {
	        throw new ResourceNotFoundException("equipo no encontrado con ID: " + id);
	    }
	}
	

	@Override
	public void delete(int id) {
		equipoRepository.deleteById(id);
	}

	@Override
	public Optional<Equipo> read(int id) {
		return equipoRepository.findById(id);
	}

	@Override
	public List<Equipo> readAll() {
		return equipoRepository.findAll();
	}
	

	@Override
	public void guardarEquipo(EquipoDto equipoDto) {
	    try {
	    	
	        Jornada jornada = new Jornada(equipoDto.getJornada());
	        Equipo equipo = new Equipo();
	        equipo.setNombre_equipo(equipoDto.getNombre_equipo());
	        equipo.setArchivo_informe(equipoDto.getArchivo_informe());
	        equipo.setHora(equipoDto.getHora());
	        equipo.setJornada(jornada);

	        System.out.println(equipo.getNombre_equipo() + " - " + equipo.getArchivo_informe());
	        System.out.println(equipo.getHora() + " - " + equipo.getJornada().getId());
	    
	        equipoRepository.insertEquipo(equipo.getArchivo_informe(), equipo.getNombre_equipo(), equipo.getJornada().getId(), equipo.getHora());
	    } catch (Exception e) {
	        // Loggea la excepción utilizando un logger
	        // logger.error("Error al guardar equipo", e);
	        throw new RuntimeException("Error al guardar equipo", e);
	    }
	}
	

    private void reiniciarSecuencia(String nombreSecuencia) {
        entityManager.createNativeQuery("ALTER SEQUENCE " + nombreSecuencia + " INCREMENT BY 1").executeUpdate();
        entityManager.createNativeQuery("SELECT " + nombreSecuencia + ".NEXTVAL FROM dual").getSingleResult();
        entityManager.createNativeQuery("ALTER SEQUENCE " + nombreSecuencia + " INCREMENT BY 1").executeUpdate();
    }
	
	public List<Equipo> getEquipoByJornada(int id){
		return equipoRepository.getEquipos(id);
	}
	
	
	public List<Map<String, Object>> getInforme(int id){
		return equipoRepository.getInformes(id);
	}
	

}