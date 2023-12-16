package br.com.smarttec.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AutenticarUsuarioRequestDto {

	@Email(message = "Por favor, informe um endereço de e-mail válido.")
	@NotBlank(message = "Por favor, informe o e-mail do usuário.")
	private String email;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
					message = "Por vaor, informe uma senha com letras maiúsculas, letras minusculas, números, símbolos e pelo menos 8 caracteres.")
	@NotBlank(message = "Por favor, informe o senha do usuário.")
	private String senha;
}
