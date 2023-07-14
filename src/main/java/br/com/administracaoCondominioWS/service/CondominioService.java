package br.com.administracaoCondominioWS.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.administracaoCondominioWS.model.Condominio;
import br.com.administracaoCondominioWS.model.dto.CondominioDTO;
import br.com.administracaoCondominioWS.repository.CondominioRepository;

@Service
public class CondominioService {

	@Autowired
	private CondominioRepository repo;
	@Autowired
	private ModelMapper mapper;

	public CondominioDTO salvar(CondominioDTO dto) {
		return toDto(repo.save(toObj(dto)));
	}

	public CondominioDTO buscar(Long id) {
		Optional<Condominio> asd = obter(id);
		if (!asd.isPresent()) {
			throw new NoSuchElementException("ID " + id + " não foi encontrado");
		}
		return toDto(asd.get());
	}

	public List<CondominioDTO> listar() {
		return repo.findAll().stream().map(ap -> toDto(ap)).collect(Collectors.toList());
	}

	public CondominioDTO desabilitar(Long id, CondominioDTO dto) {
		Optional<Condominio> opt = obter(id);
		if (opt.isPresent()) {
			throw new NoSuchElementException("Esse Condominio não pode ser desabilitado");

		}
		dto.setId(id);
		return toDto(repo.save(toObj(dto)));
	}

	private Optional<Condominio> obter(Long id) {
		Optional<Condominio> opt = repo.findById(id);
		return opt;
	}

	private Condominio toObj(CondominioDTO dto) {
		return mapper.map(dto, Condominio.class);
	}

	private CondominioDTO toDto(Condominio obj) {
		return mapper.map(obj, CondominioDTO.class);
	}
}