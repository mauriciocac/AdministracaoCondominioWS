package br.com.administracaoCondominioWS.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mensalidade extends AbstractEntity<Long> {
	private static final long serialVersionUID = 1L;

	private String dataPagamento;
	private String dataValidade;
	private String valor;
	private Boolean isPago;
	private String mesAnoReferencia;
	@ManyToOne
	@JoinColumn(name = "apartamento_id", nullable = false)
	private Apartamento apartamento;

}
