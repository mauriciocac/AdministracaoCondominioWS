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
public class SalaoFestas extends AbstractEntity<Long> {
	private static final long serialVersionUID = 1L;

	private String nome;

	@ManyToOne
	@JoinColumn(name = "condominio_id", nullable = false)
	private Condominio condominio;

	@OneToMany(mappedBy = "salaoFestas")
	private List<AluguelFesta> aluguelFestas;


}
