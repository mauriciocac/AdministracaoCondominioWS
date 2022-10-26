package br.com.administracaoCondominioWS.service;

import java.util.List;
import java.util.NoSuchElementException;
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

	public List<Morador> listarMoradoresInquilinos() {
		return repositorio.listarMoradoresInquilinos();
	}

	public Morador salvarMoradores(Morador morador) {
		return repositorio.save(morador);
	}

	public void removerMorador(Long id) {
		obterMorador(id);
		repositorio.deleteById(id);
	}

	public Morador atualizarMoradores(Morador obj, Long id) {
		obterMorador(id);
		obj.setId(id);
		return repositorio.save(obj);
	}

	public Optional<Morador> obterMorador(Long id) {
		Optional<Morador> optional = repositorio.findById(id);
		if (optional.isPresent()) {
			throw new NoSuchElementException("ID " + id + " não foi encontrado");
		}
		return optional;
	}
}
