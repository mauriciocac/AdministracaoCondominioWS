package br.com.administracaoCondominioWS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.administracaoCondominioWS.model.dto.CondominioDTO;
import br.com.administracaoCondominioWS.service.CondominioService;

@RestController
@RequestMapping(value = "/condominios")
public class CondominioResource {
	@Autowired
	private CondominioService service;

	@PostMapping
	public ResponseEntity<CondominioDTO> salvar(@RequestBody CondominioDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
	}

	@GetMapping
	public ResponseEntity<List<CondominioDTO>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(service.listar());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CondominioDTO> buscar(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
	}

	@DeleteMapping
	public ResponseEntity<CondominioDTO> excluir(Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.desabilitar(id, null));
	}

}
