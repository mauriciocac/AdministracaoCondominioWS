package br.com.administracaoCondominioWS.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.administracaoCondominioWS.model.Apartamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EdificioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private CondominioDTO condominio = new CondominioDTO();
	private List<Apartamento> apartamento = new ArrayList<>();

}
