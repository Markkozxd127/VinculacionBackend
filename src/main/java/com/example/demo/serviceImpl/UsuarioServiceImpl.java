package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService<Usuario>{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario create(Usuario t) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(t);
	}

	@Override
	public Usuario update(Usuario t) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

	@Override
	public Optional<Usuario> read(int id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
	}

	@Override
	public List<Usuario> readAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}
	// métodos q llaman a los métodos correspondientes en tu usuarioRepository 
	public List<Map<String, Object>> getInitSesion(String user,String pass){
		return usuarioRepository.getInitSesion(user, pass);
	}
	
	public List<Map<String, Object>> getModules(int id){
		return usuarioRepository.getModules(id);
	}
}
