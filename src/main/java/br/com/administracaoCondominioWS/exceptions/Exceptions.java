package br.com.administracaoCondominioWS.exceptions;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exceptions {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Erro> validationNoSuchElementException(NoSuchElementException e) {
		Erro erro = new Erro(e.getLocalizedMessage(), new Date(System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Erro> validationMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		Erro erro = new Erro("Erro de validação", new Date(System.currentTimeMillis()), HttpStatus.NOT_FOUND);
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			erro.getErros().add(new Campo(x.getField(), x.getDefaultMessage()));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Erro> validationHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		Erro erro = new Erro("Há um erro no payload da requisição", new Date(System.currentTimeMillis()),
				HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
