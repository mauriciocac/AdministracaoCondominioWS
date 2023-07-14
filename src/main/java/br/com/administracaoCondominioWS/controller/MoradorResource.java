package br.com.administracaoCondominioWS.controller;

import java.util.List;

import javax.validation.Valid;

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

import br.com.administracaoCondominioWS.model.dto.MoradorDTO;
import br.com.administracaoCondominioWS.service.MoradorService;

@RestController
@RequestMapping(value = "/moradores")
public class MoradorResource {

	@Autowired
	private MoradorService service;

	@PostMapping
	public ResponseEntity<MoradorDTO> salvar(@RequestBody @Valid MoradorDTO morador) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(morador));
	}

	@GetMapping
	public ResponseEntity<List<MoradorDTO>> listar() {
		List<MoradorDTO> moradores = service.listar();
		if (moradores.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(moradores);
	}

	@GetMapping("/inquilinos")
	public ResponseEntity<List<MoradorDTO>> listarInquilinos() {
		List<MoradorDTO> moradores = service.listarInquilinos();
		if (moradores.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(moradores);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<MoradorDTO> buscar(@PathVariable Long id) {
		MoradorDTO optionalMorador = service.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(optionalMorador);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<MoradorDTO> excluir(@PathVariable Long id) {
		service.remover(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<MoradorDTO> atualizarMorador(@PathVariable Long id, @Valid @RequestBody MoradorDTO dto) {
		service.atualizar(dto, id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
