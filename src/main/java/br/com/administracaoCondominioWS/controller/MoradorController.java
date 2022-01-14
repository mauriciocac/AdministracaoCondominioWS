package br.com.administracaoCondominioWS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.administracaoCondominioWS.model.Morador;
import br.com.administracaoCondominioWS.repository.MoradorRepository;

@RestController
@RequestMapping("/moradores")
public class MoradorController {
	@Autowired
	private MoradorRepository repositorio;

	@GetMapping
	public ResponseEntity<List<Morador>> obterMoradores() {
		List<Morador> moradores = repositorio.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(moradores);
	}

	@PostMapping
	public ResponseEntity<Morador> salvarMoradores(@RequestBody Morador morador) {
		repositorio.save(morador);
		return ResponseEntity.status(HttpStatus.CREATED).body(morador);
	}
}
