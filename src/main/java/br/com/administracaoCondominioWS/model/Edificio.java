package br.com.administracaoCondominioWS.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Edificio extends AbstractEntity<Long> {
	private static final long serialVersionUID = 1L;

	private String descricao;
	@ManyToOne
	@JoinColumn(name = "condominio")
	private Condominio condominio;
	@Nullable
	@OneToMany(mappedBy = "edificio")
	private List<Apartamento> apartamento;

}
