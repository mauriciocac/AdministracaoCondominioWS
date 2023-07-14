package br.com.administracaoCondominioWS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.administracaoCondominioWS.model.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {

}
