package br.com.administracaoCondominioWS.model.enums;

public enum EnumTipoMorador {
	PRO("Proprietario"), INQ("Inquilino");

	String tipo;

	EnumTipoMorador(String tipo) {
		this.tipo = tipo;
	}

}
