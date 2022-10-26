package br.com.administracaoCondominioWS.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Apartamento extends AbstractEntity<Long> {

	private String numero;
	private Boolean habilitado;

	@ManyToOne
	@JoinColumn(name = "edificio_id", nullable = true)
	private Edificio edificio;
	@OneToMany(mappedBy = "apartamento")
	private List<Morador> moradores;
	@OneToMany(mappedBy = "apartamento")
	private List<Mensalidade> mensalidades;

	@OneToMany(mappedBy = "apartamento")
	private List<AluguelFesta> aluguelFestas;
	@OneToMany(mappedBy = "apartamento")
	private List<AluguelJogos> aluguelJogos;
	@OneToMany(mappedBy = "apartamento")
	private List<AluguelAcademia> aluguelAcademias;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	public List<Morador> getMoradores() {
		return moradores;
	}

	public void setMoradores(List<Morador> moradores) {
		this.moradores = moradores;
	}

	public List<Mensalidade> getMensalidades() {
		return mensalidades;
	}

	public void setMensalidades(List<Mensalidade> mensalidades) {
		this.mensalidades = mensalidades;
	}

	public List<AluguelFesta> getAluguelFestas() {
		return aluguelFestas;
	}

	public void setAluguelFestas(List<AluguelFesta> aluguelFestas) {
		this.aluguelFestas = aluguelFestas;
	}

	public List<AluguelJogos> getAluguelJogos() {
		return aluguelJogos;
	}

	public void setAluguelJogos(List<AluguelJogos> aluguelJogos) {
		this.aluguelJogos = aluguelJogos;
	}

	public List<AluguelAcademia> getAluguelAcademias() {
		return aluguelAcademias;
	}

	public void setAluguelAcademias(List<AluguelAcademia> aluguelAcademias) {
		this.aluguelAcademias = aluguelAcademias;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

}
