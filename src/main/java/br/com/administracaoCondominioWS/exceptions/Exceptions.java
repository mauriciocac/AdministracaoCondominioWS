package br.com.administracaoCondominioWS.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exceptions {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Erro> validationMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		Erro erro = new Erro("Erro de validação", new Date(System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			erro.getErros().add(new Campo(x.getField(), x.getDefaultMessage()));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

}
