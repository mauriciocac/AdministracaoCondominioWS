package br.com.administracaoCondominioWS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.administracaoCondominioWS.model.Condominio;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Long> {

}
