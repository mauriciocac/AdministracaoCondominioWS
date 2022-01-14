package br.com.administracaoCondominioWS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.administracaoCondominioWS.model.Morador;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long> {

}
