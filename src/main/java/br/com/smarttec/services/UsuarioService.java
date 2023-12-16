package br.com.smarttec.services;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.smarttec.dtos.AutenticarUsuarioRequestDto;
import br.com.smarttec.dtos.AutenticarUsuarioResponseDto;
import br.com.smarttec.dtos.CriarUsuarioRequestDto;
import br.com.smarttec.dtos.CriarUsuarioResponseDto;
import br.com.smarttec.entities.Usuario;
import br.com.smarttec.helpers.Sha1CryptoHelper;
import br.com.smarttec.repositories.UsuarioRepository;
import br.com.smarttec.security.JwtBearerSecurity;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	JwtBearerSecurity jwtBearerSecurity;
	
	public CriarUsuarioResponseDto criarUsuario (CriarUsuarioRequestDto request) {
	
		if (usuarioRepository.find(request.getEmail()) != null) {
			throw new IllegalArgumentException("Já existe um usuário cadastrado com esse e-mail informado.");
		}
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(UUID.randomUUID());
		usuario.setNome(request.getNome());
		usuario.setEmail(request.getEmail());
		usuario.setSenha(Sha1CryptoHelper.get(request.getSenha()));
		
		usuarioRepository.save(usuario);
		
		CriarUsuarioResponseDto response = new CriarUsuarioResponseDto();
		response.setIdUsuario(usuario.getIdUsuario());
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getEmail());
		response.setDataHoraCriacao(Instant.now());
		
		return response;
	}
	
	public AutenticarUsuarioResponseDto autenticarUsuario (AutenticarUsuarioRequestDto request) {
		
		Usuario usuario = usuarioRepository.find(request.getEmail(), Sha1CryptoHelper.get( request.getSenha()));
		
		if (usuario != null) {
			
			AutenticarUsuarioResponseDto response = new AutenticarUsuarioResponseDto();
			response.setIdUsuario(usuario.getIdUsuario());
			response.setNome(usuario.getNome());
			response.setEmail(usuario.getEmail());
			response.setDataHoraAcesso(Instant.now());
			response.setDataHoraExpiracao(jwtBearerSecurity.getExpiration().toInstant()); 
			response.setAccessToken(jwtBearerSecurity.getToken(usuario.getEmail())); 
			
			return response;
		}
		
		throw new IllegalArgumentException("Acesso negado. Usuário inválido");
		
	}

}
