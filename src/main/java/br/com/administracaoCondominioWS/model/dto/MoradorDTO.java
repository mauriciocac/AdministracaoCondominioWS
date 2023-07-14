package br.com.administracaoCondominioWS.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoradorDTO {
	public Long id;
	@NotEmpty(message = "Campo Obrigatório")
	@Length(min = 10, max = 99, message = "Atenção ao tamanho do campo")
	private String nome;
	@Length(min = 11, max = 11, message = "O tamanho do campo é de 11 caracteres")
	@NotEmpty(message = "Campo Obrigatório")
	private String cpf;
	@Email(message = "Informe um email válido")
	@NotEmpty(message = "Campo Obrigatório")
	private String email;
	@NotEmpty(message = "Campo Obrigatório")
	private String telefone;
	private String tipoMorador;

}
