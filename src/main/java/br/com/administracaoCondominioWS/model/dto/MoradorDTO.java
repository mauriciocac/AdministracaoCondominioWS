package br.com.administracaoCondominioWS.model.dto;

import br.com.administracaoCondominioWS.model.AbstractEntity;

public class MoradorDTO extends AbstractEntity<Long> {
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
