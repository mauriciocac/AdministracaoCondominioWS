package br.com.administracaoCondominioWS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.administracaoCondominioWS.controller.CondominioResource;
import br.com.administracaoCondominioWS.controller.EdificioResource;
import br.com.administracaoCondominioWS.model.dto.CondominioDTO;
import br.com.administracaoCondominioWS.model.dto.EdificioDTO;

@SpringBootApplication
public class AdministracaoCondominioWsApplication implements CommandLineRunner {
	@Autowired
	private CondominioResource condResource;
	@Autowired
	private EdificioResource edificioResource;

	public static void main(String[] args) {
		System.out.println("Iniciando a aplicação");
		SpringApplication.run(AdministracaoCondominioWsApplication.class, args);
		System.out.println("Aplicação INICIADA");
	}

	@Override
	public void run(String... args) throws Exception {
		CondominioDTO dto = new CondominioDTO();
		dto.setId(1L);
		dto.setDescricao("Condominio Mix Aricanduva 1");
		dto.setCnpj("09.877.0001/44-98");
		dto.setBairro("Jardim Santa Terezinha");
		dto.setCep("03572-020");
		dto.setEstado("São Paulo");
		dto.setNumero("320");
		dto.setRua("AvOlga Fadel Abarca");
		dto.setCidade("São Paulo");
		condResource.salvar(dto);

		EdificioDTO dtoEdficio = new EdificioDTO();
		dtoEdficio.setId(1L);
		dtoEdficio.setDescricao("Edificio Unico");
		dtoEdficio.setCondominio(dto);
		edificioResource.salvar(dtoEdficio);
	}

}
