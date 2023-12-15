package br.com.smarttec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.smarttec.dtos.AutenticarUsuarioRequestDto;
import br.com.smarttec.dtos.AutenticarUsuarioResponseDto;
import br.com.smarttec.dtos.CriarUsuarioRequestDto;
import br.com.smarttec.dtos.CriarUsuarioResponseDto;
import br.com.smarttec.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	@PostMapping("criar")
	public CriarUsuarioResponseDto criarUsuario(@RequestBody @Valid CriarUsuarioRequestDto request) {
		return usuarioService.criarUsuario(request);
	}
	
	@PostMapping("autenticar")
	public AutenticarUsuarioResponseDto autenticarUsuario(@RequestBody @Valid AutenticarUsuarioRequestDto request) {
		return usuarioService.autenticarUsuario(request);
	}
	
	
}
