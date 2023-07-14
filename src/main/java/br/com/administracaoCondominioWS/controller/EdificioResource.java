package br.com.administracaoCondominioWS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.administracaoCondominioWS.model.dto.EdificioDTO;
import br.com.administracaoCondominioWS.service.EdificioService;

@RestController
@RequestMapping(value = "/edificios")
public class EdificioResource {
	@Autowired
	private EdificioService service;

	@PostMapping
	public ResponseEntity<EdificioDTO> salvar(@RequestBody EdificioDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(service.salvar(dto));
	}

	@GetMapping
	public ResponseEntity<List<EdificioDTO>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(service.listar());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<EdificioDTO> buscar(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<EdificioDTO> excluir(Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.excluir(id));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<EdificioDTO> atualizar(@PathVariable Long id, EdificioDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(id, dto));
	}
}
