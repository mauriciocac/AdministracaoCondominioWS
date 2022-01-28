package br.com.administracaoCondominioWS.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AluguelAcademia extends AbstractEntity<Long> {

	private String dataAluguel;
	private String horaAluguel;
	@ManyToOne
	@JoinColumn(name = "apartamento_id", nullable = false)
	private Apartamento apartamento;
	@ManyToOne
	@JoinColumn(name = "academia_id", nullable = false)
	private SalaoAcademia salaoAcademia;
}
