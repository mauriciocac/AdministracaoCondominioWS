package br.com.administracaoCondominioWS.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

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

	public MoradorDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipoMorador() {
		return tipoMorador;
	}

	public void setTipoMorador(String tipoMorador) {
		this.tipoMorador = tipoMorador;
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
