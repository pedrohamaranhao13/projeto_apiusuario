package br.com.smarttec.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CriarUsuarioRequestDto {

	@Size(min = 8, max = 150,  message = "Por vaor, informe de 8 a 150 caracteres.")
	@NotBlank(message = "Por favor, informe o nome do usuário.")
	private String nome;
	
	@Email(message = "Por favor, informe um endereço de e-mail válido.")
	@NotBlank(message = "Por favor, informe o e-mail do usuário.")
	private String email;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
					message = "Por favor, informe uma senha com letras maiúsculas, letras minusculas, números, símbolos e pelo menos 8 caracteres.")
	@NotBlank(message = "Por favor, informe o senha do usuário.")
	private String senha;
}
