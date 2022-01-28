package br.com.administracaoCondominioWS.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mensalidade extends AbstractEntity<Long> {

	private String dataPagamento;
	private String dataValidade;
	private String valor;
	private Boolean isPago;
	private String mesAnoReferencia;
	@ManyToOne
	@JoinColumn(name = "apartamento_id", nullable = false)
	private Apartamento apartamento;

}
