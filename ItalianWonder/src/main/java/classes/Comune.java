package classes;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table
public class Comune {

	@Id

	@SequenceGenerator(
			name = "averef_sequence",
			sequenceName = "averef_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			generator = "averef_sequence",
			strategy = GenerationType.SEQUENCE
	)

	//region Vars

	private String nome;

	//endregion

	//region Props

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//endregion

	//region Constr

	public Comune(String nome, Localizzazione localizazione) {
		this.nome = nome;
	}

	public Comune() {
		this.nome = "";
	}

	//endregion

	//region Methods

	public Comune mostraComuni() {
		// TODO - implement Comune.mostraComuni
		throw new UnsupportedOperationException();
	}

	//endregion

}