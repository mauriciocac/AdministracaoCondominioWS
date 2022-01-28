package br.com.administracaoCondominioWS.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

public class Erro {
	public String menssagem;
	public Date hora;
	public String status;
	private List<Campo> campos = new ArrayList<>();

	public Erro() {
		super();
	}

	public Erro(String menssagem, Date hora, HttpStatus status) {
		super();
		this.menssagem = menssagem;
		this.hora = hora;
		this.status = status.value() + " - " + status.name();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getMenssagem() {
		return menssagem;
	}

	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}

	public List<Campo> getErros() {
		return campos;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}

}
