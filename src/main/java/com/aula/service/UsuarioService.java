package com.aula.service;

import org.springframework.stereotype.Service;

import com.aula.dto.UsuarioDto;
import com.aula.model.Usuario;
import com.aula.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	
	public UsuarioDto findById(Long id) {
		return new UsuarioDto(usuarioRepository.getReferenceById(id));
	}
	
	@Transactional
	public UsuarioDto save(UsuarioDto usuarioDto) {
		Usuario usuario = Usuario.fromDto(usuarioDto);
		return new UsuarioDto(usuarioRepository.save(usuario));
	}
	
	@Transactional
	public UsuarioDto update(Long id, UsuarioDto usuarioDto) {
		Usuario usuario = Usuario.fromDto(usuarioDto);
		usuario.setId(id);
		return new UsuarioDto(usuarioRepository.save(usuario));
	}
}
