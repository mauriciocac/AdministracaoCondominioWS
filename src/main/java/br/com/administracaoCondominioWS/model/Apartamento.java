package br.com.administracaoCondominioWS.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Apartamento extends AbstractEntity<Long> {
	private static final long serialVersionUID = 1L;

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

}
