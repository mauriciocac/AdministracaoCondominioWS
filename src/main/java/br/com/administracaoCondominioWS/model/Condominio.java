package br.com.administracaoCondominioWS.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Condominio extends AbstractEntity<Long> {
	private static final long serialVersionUID = 1L;

	private String descricao;
	private String cnpj;
	private String numero;
	private String bairro;
	private String rua;
	private String cidade;
	private String estado;
	private String cep;

	@OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Edificio> edificios;

}
