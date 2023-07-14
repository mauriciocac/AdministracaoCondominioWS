package br.com.administracaoCondominioWS.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApartamentoDTO {

	private Long id;
	private String numero;
	private Boolean habilitado;

}
