package br.com.administracaoCondominioWS.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import br.com.administracaoCondominioWS.model.Edificio;
import br.com.administracaoCondominioWS.model.dto.EdificioDTO;
import br.com.administracaoCondominioWS.repository.EdificioRepository;

@Service
public class EdificioService {
	@Autowired
	private EdificioRepository repo;
	@Autowired
	private ModelMapper mapper;

	public EdificioDTO salvar(EdificioDTO dto) {
		try {
			return toDto(repo.save(toObj(dto)));
		} catch (InvalidDataAccessApiUsageException e) {
			throw new NoSuchElementException("Há um problema ao salvar a constraint " + e.getMessage());
		}
	}

	public EdificioDTO buscar(Long id) {
		return toDto(repo.findById(id).get());
	}

	public EdificioDTO excluir(Long id) {
		EdificioDTO buscar = buscar(id);
		if (buscar == null) {
			throw new NoSuchElementException("Não foi encontrado");
		}
		repo.deleteById(id);
		return buscar;
	}

	public EdificioDTO atualizar(Long id, EdificioDTO dto) {
		if (id != null) {
			repo.save(toObj(dto));
		}
		return null;
	}

	public List<EdificioDTO> listar() {
		return toDtoList(repo.findAll());
	}

	private Edificio toObj(EdificioDTO dto) {
		return mapper.map(dto, Edificio.class);
	}

	private EdificioDTO toDto(Edificio obj) {
		return mapper.map(obj, EdificioDTO.class);
	}

	private List<EdificioDTO> toDtoList(List<Edificio> list) {
		return list.stream().map(obj -> mapper.map(obj, EdificioDTO.class)).collect(Collectors.toList());
	}
}
