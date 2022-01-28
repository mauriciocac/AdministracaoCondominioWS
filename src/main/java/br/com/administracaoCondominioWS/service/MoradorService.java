package br.com.administracaoCondominioWS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.administracaoCondominioWS.model.Morador;
import br.com.administracaoCondominioWS.repository.MoradorRepository;

@Service
public class MoradorService {
	@Autowired
	private MoradorRepository repositorio;

	public List<Morador> listarMoradores() {
		return repositorio.findAll();
	}

	public Morador salvarMoradores(Morador morador) {
		return repositorio.save(morador);
	}

	public void removerMorador(Long id) {
		repositorio.deleteById(id);

	}

	public Morador atualizarMoradores(Morador dto, Long id) {
		dto.setId(id);
		return repositorio.save(dto);
	}

	public Optional<Morador> obterMorador(Long id) {
		return repositorio.findById(id);
	}
}
