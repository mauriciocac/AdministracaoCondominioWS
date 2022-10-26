package br.com.administracaoCondominioWS.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Edificio extends AbstractEntity<Long> {

	private String nome;
	@ManyToOne
	@JoinColumn(name = "condominio_id", nullable = false)
	private Condominio condominio;
	@OneToMany(mappedBy = "edificio")
	private List<Apartamento> apartamento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

	public List<Apartamento> getApartamento() {
		return apartamento;
	}

	public void setApartamento(List<Apartamento> apartamento) {
		this.apartamento = apartamento;
	}

}
