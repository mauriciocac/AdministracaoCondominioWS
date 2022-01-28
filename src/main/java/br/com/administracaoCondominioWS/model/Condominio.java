package br.com.administracaoCondominioWS.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Condominio extends AbstractEntity<Long> {

	private String nome;
	private String cnpj;
	private String numero;
	private String bairro;
	private String rua;
	private String cidade;
	private String estabo;
	private String cep;

	@OneToMany(mappedBy = "condominio")
	private List<Edificio> edificios;

}
