package br.com.administracaoCondominioWS.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.administracaoCondominioWS.model.Apartamento;
import br.com.administracaoCondominioWS.model.dto.ApartamentoDTO;
import br.com.administracaoCondominioWS.repository.ApartamentoRepository;

@Service
public class ApartamentoService {

	@Autowired
	private ApartamentoRepository repo;
	@Autowired
	private ModelMapper mapper;

	public ApartamentoDTO salvar(ApartamentoDTO dto) {
		return toDto(repo.save(toObj(dto)));
	}

	public ApartamentoDTO buscar(Long id) {
		Optional<Apartamento> asd = obterApartamento(id);
		if (asd.isPresent()) {
			throw new NoSuchElementException("ID " + id + " não foi encontrado");
		}
		return toDto(asd.get());
	}

	public List<ApartamentoDTO> listar() {
		return repo.findAll().stream().map(ap -> toDto(ap)).collect(Collectors.toList());
	}

	public ApartamentoDTO desabilitar(Long id, ApartamentoDTO dto) {
		Optional<Apartamento> opt = obterApartamento(id);
		if (opt.isPresent()) {
			throw new NoSuchElementException("Esse apartamento não pode ser desabilitado");

		}
		dto.setId(id);
		return toDto(repo.save(toObj(dto)));
	}

	private Optional<Apartamento> obterApartamento(Long id) {
		Optional<Apartamento> opt = repo.findById(id);
		return opt;
	}

	private Apartamento toObj(ApartamentoDTO dto) {
		return mapper.map(dto, Apartamento.class);
	}

	private ApartamentoDTO toDto(Apartamento obj) {
		return mapper.map(obj, ApartamentoDTO.class);
	}
}