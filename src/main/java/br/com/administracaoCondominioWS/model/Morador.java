package br.com.administracaoCondominioWS.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Morador extends AbstractEntity<Long> {

	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String tipoMorador;

	@ManyToOne
	@JoinColumn(name = "apartamento_id", nullable = true)
	private Apartamento apartamento;

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

	public Apartamento getApartamento() {
		return apartamento;
	}

	public void setApartamento(Apartamento apartamento) {
		this.apartamento = apartamento;
	}

}
