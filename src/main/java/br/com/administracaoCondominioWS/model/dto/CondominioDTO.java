package br.com.administracaoCondominioWS.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.administracaoCondominioWS.model.Edificio;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CondominioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private String cnpj;
	private String numero;
	private String bairro;
	private String rua;
	private String cidade;
	private String estado;
	private String cep;
	private List<Edificio> edificios = new ArrayList<>();


}
