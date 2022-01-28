package br.com.administracaoCondominioWS.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AluguelFesta extends AbstractEntity<Long> {

	private String dataAluguel;
	private Boolean isPago;
	@ManyToOne
	@JoinColumn(name = "apartamento_id", nullable = false)
	private Apartamento apartamento;
	@ManyToOne
	@JoinColumn(name = "salaoFestas_id", nullable = false)
	private SalaoFestas salaoFestas;
}
