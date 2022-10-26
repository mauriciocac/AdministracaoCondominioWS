package br.com.administracaoCondominioWS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.administracaoCondominioWS.model.Morador;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long> {

	@Query("select m from Morador m where m.tipoMorador = 'INQ'")
	public List<Morador> listarMoradoresInquilinos();
}
