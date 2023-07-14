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
public class AluguelFesta extends AbstractEntity<Long> {
	private static final long serialVersionUID = 1L;

	private String dataAluguel;
	private Boolean isPago;
	@ManyToOne
	@JoinColumn(name = "apartamento_id", nullable = false)
	private Apartamento apartamento;
	@ManyToOne
	@JoinColumn(name = "salaoFestas_id", nullable = false)
	private SalaoFestas salaoFestas;
}
