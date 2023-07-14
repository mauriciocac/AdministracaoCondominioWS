package br.com.administracaoCondominioWS.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.administracaoCondominioWS.model.Morador;
import br.com.administracaoCondominioWS.model.dto.MoradorDTO;
import br.com.administracaoCondominioWS.repository.MoradorRepository;

@Service
public class MoradorService {
	@Autowired
	private MoradorRepository repositorio;
	@Autowired
	private ModelMapper mapper;

	public List<MoradorDTO> listar() {
		return toList(repositorio.findAll());
	}

	public List<MoradorDTO> listarInquilinos() {
		return toList(repositorio.listarInquilinos());
	}

	public MoradorDTO salvar(MoradorDTO morador) {
		return toDto(repositorio.save(toObj(morador)));
	}

	public void remover(Long id) {
		buscar(id);
		repositorio.deleteById(id);
	}

	public Morador atualizar(MoradorDTO obj, Long id) {
		buscar(id);
		obj.setId(id);
		return repositorio.save(toObj(obj));
	}

	public MoradorDTO buscar(Long id) {
		return toDto(repositorio.findById(id).get());
	}

	private MoradorDTO toDto(Morador optional) {
		return mapper.map(optional, MoradorDTO.class);
	}

	private Morador toObj(MoradorDTO optional) {
		return mapper.map(optional, Morador.class);
	}

	private List<MoradorDTO> toList(List<Morador> list) {
		return list.stream().map(obj -> mapper.map(obj, MoradorDTO.class)).collect(Collectors.toList());
	}
}
