package br.com.administracaoCondominioWS.model.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class MoradorDTO {
	@NotEmpty(message = "Campo Obrigatório")
	@Length(min = 10, max = 99, message = "Atenção ao tamanho do campo")
	private String nome;
	private String cpf;
	private String email;

	public MoradorDTO() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
