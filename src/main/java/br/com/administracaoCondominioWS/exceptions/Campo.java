package br.com.administracaoCondominioWS.exceptions;

public class Campo {
	public String nome;
	public String msg;

	public Campo(String nome, String msg) {
		super();
		this.nome = nome;
		this.msg = msg;
	}

	public Campo() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
