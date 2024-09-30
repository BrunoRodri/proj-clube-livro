package com.aula.model;

import com.aula.dto.UsuarioDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 80, nullable = false)
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String endereco;
	
	public static Usuario fromDto(UsuarioDto usuarioDto) {
		return new Usuario(null, usuarioDto.nome(), usuarioDto.email(), usuarioDto.senha(), usuarioDto.telefone(), usuarioDto.endereco());
	}

}
