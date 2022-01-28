package br.com.administracaoCondominioWS.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AluguelJogos extends AbstractEntity<Long> {

	private String horaAluguel;
	private Boolean isPago;
	@ManyToOne
	@JoinColumn(name = "apartamento_id", nullable = false)
	private Apartamento apartamento;
	@ManyToOne
	@JoinColumn(name = "salaoJogos_id", nullable = false)
	private SalaoJogos salaoJogos;
}
