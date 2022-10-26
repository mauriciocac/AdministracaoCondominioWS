package br.com.administracaoCondominioWS.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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

import br.com.administracaoCondominioWS.model.Morador;
import br.com.administracaoCondominioWS.model.dto.MoradorDTO;
import br.com.administracaoCondominioWS.service.MoradorService;

@RestController
@RequestMapping(value = "/moradores")
public class MoradorResource {

	@Autowired
	private MoradorService service;

	@Autowired
	private ModelMapper mMap;

	public int raio1, raio2, soma = 20;

	@GetMapping("/teste")
	public ResponseEntity<String> setRaios(int raio) {
		raio1 = raio;
		raio2 = soma - raio1;

		return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(raio2));
	}

	@GetMapping
	public ResponseEntity<List<MoradorDTO>> listarMoradores() {
		List<MoradorDTO> moradores = service.listarMoradores().stream()
				.map(morador -> mMap.map(morador, MoradorDTO.class)).collect(Collectors.toList());
		if (moradores.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(moradores);
	}

	@GetMapping("/inquilinos")
	public ResponseEntity<List<MoradorDTO>> listarMoradoresInquilinos() {
		List<MoradorDTO> moradores = service.listarMoradoresInquilinos().stream()
				.map(morador -> mMap.map(morador, MoradorDTO.class)).collect(Collectors.toList());
		if (moradores.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(moradores);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<MoradorDTO> obterMorador(@PathVariable Long id) {
		Optional<Morador> optionalMorador = service.obterMorador(id);
		return ResponseEntity.status(HttpStatus.OK).body(mMap.map(optionalMorador.get(), MoradorDTO.class));
	}

	@PostMapping
	public ResponseEntity<MoradorDTO> salvarMorador(@RequestBody @Valid MoradorDTO morador) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(mMap.map(service.salvarMoradores(mMap.map(morador, Morador.class)), MoradorDTO.class));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<MoradorDTO> excluirMorador(@PathVariable Long id) {
		service.removerMorador(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<MoradorDTO> atualizarMorador(@PathVariable Long id, @Valid @RequestBody MoradorDTO dto) {
		service.atualizarMoradores(mMap.map(dto, Morador.class), id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
