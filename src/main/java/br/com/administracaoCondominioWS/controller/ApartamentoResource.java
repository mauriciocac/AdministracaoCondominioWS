package br.com.administracaoCondominioWS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.administracaoCondominioWS.model.dto.ApartamentoDTO;
import br.com.administracaoCondominioWS.service.ApartamentoService;

@RestController
@RequestMapping(value = "/apartamentos")
public class ApartamentoResource {
	@Autowired
	private ApartamentoService service;

	@PostMapping
	public ResponseEntity<ApartamentoDTO> salvar(@RequestBody ApartamentoDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
	}

	@GetMapping
	public ResponseEntity<List<ApartamentoDTO>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(service.listar());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ApartamentoDTO> buscar(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ApartamentoDTO> desabilitar(@PathVariable Long id, @RequestBody ApartamentoDTO dto) {
		return ResponseEntity.status(HttpStatus.OK).body(service.desabilitar(id, dto));
	}
}
