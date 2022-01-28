package br.com.administracaoCondominioWS.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Apartamento extends AbstractEntity<Long> {

	private String numero;

	@ManyToOne
	@JoinColumn(name = "apartamento_id", nullable = false)
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
}
