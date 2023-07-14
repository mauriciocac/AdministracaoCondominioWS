package br.com.administracaoCondominioWS.model.enums;

import lombok.Getter;

@Getter
public enum EnumTipoMorador {
	PRO(1, "Proprietario"), INQ(2, "Inquilino");

	private String descricao;
	private Integer id;

	EnumTipoMorador(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

}
