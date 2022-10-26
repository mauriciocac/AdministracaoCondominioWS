package br.com.administracaoCondominioWS.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.administracaoCondominioWS.model.dto.EdificioDTO;

@RestController
@RequestMapping(value = "/edificios")
public class EdificioResource {

	@GetMapping
	public ResponseEntity<List<EdificioDTO>> listarMoradores() {

		return ResponseEntity.status(HttpStatus.OK).body(Arrays.asList(new EdificioDTO()));
	}
}
