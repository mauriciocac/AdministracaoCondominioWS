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
public class Morador extends AbstractEntity<Long> {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String tipoMorador;

	@ManyToOne
	@JoinColumn(name = "apartamento_id", nullable = true)
	private Apartamento apartamento;

}
