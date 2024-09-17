package classes;

import classes.POI.Divertimento;
import classes.POI.Itinerario;
import classes.POI.Ristorante;
import classes.users.Turista;
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

	@OneToOne(mappedBy = "comune")
	private Turista turista;

	@ManyToOne
	@JoinColumn(name = "provincia_id")
	private Provincia provincia;

	@ManyToOne
	@JoinColumn(name = "localizzazione_id")
	private Localizzazione localizzazione;

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