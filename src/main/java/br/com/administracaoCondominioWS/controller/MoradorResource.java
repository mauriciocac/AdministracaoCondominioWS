package br.com.administracaoCondominioWS.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import br.com.administracaoCondominioWS.repository.MoradorRepository;

@RestController
@RequestMapping(value = "/moradores")
public class MoradorResource {
	@Autowired
	private MoradorRepository repositorio;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<MoradorDTO>> listarMoradores() {
		List<MoradorDTO> moradores = repositorio.findAll().stream()
				.map(morador -> modelMapper.map(morador, MoradorDTO.class)).collect(Collectors.toList());
		if (moradores.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(moradores);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<MoradorDTO> obterMorador(@PathVariable Long id) {
		Optional<Morador> optionalMorador = repositorio.findById(id);
		if (optionalMorador.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(optionalMorador.get(), MoradorDTO.class));
	}

	@PostMapping
	public ResponseEntity<MoradorDTO> salvarMoradores(@RequestBody Morador morador) {
		Morador moradorSalvo = repositorio.save(morador);
		return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(moradorSalvo, MoradorDTO.class));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<MoradorDTO> excluirMorador(@PathVariable Long id) {
		Optional<Morador> optionalMorador = repositorio.findById(id);
		if (!optionalMorador.isEmpty()) {
			repositorio.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(optionalMorador.get(), MoradorDTO.class));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<MoradorDTO> atualizarMorador(@PathVariable Long id, @RequestBody Morador dto) {
		Optional<Morador> optionalMorador = repositorio.findById(id);
		if (!optionalMorador.isEmpty()) {
			dto.setId(id);
			repositorio.save(dto);
			return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(optionalMorador.get(), MoradorDTO.class));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
