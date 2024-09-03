package classes.users;

import classes.*;
import classes.POI.Divertimento;
import classes.POI.Itinerario;
import classes.POI.Ristorante;
import jakarta.persistence.*;

import java.util.*;
/*
@Entity
@Table */
public class UserNonAutenticato {
/*
	@Id

	@SequenceGenerator(
			name = "usernonautenticato_sequence",
			sequenceName = "usernonautenticato_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.IDENTITY,
			generator = "usernonautenticato_sequence"
	)
*/
	private Long id;
	private final String ip;

	public UserNonAutenticato() {
		this.ip = "";
	}

	public UserNonAutenticato(String ip) {
		this.ip = ip;
	}

	//region Methods

	public List<Divertimento> ricercaDivertimenti(Comune comune, List<Divertimento> divertimenti) {
		// TODO - implement UserNonAutenticato.ricercaDivertimenti
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nome
	 */
	public List<Ristorante> ricercaRistorante(String nome) {
		// TODO - implement UserNonAutenticato.ricercaRistorante
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nome
	 */
	public List<Comune> ricercaComune(String nome) {
		// TODO - implement UserNonAutenticato.ricercaComune
		throw new UnsupportedOperationException();
	}

	public List<Itinerario> ricercaItinerario() {
		// TODO - implement UserNonAutenticato.ricercaItinerario
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param comune
	 */
	public List<Object> ricercaPuntiInteresseComune(Comune comune) {
		// TODO - implement UserNonAutenticato.ricercaPuntiInteresseComune
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param puntoDiInteresse
	 */
	public List<Recensione> leggereRecensioni(Object puntoDiInteresse) {
		// TODO - implement UserNonAutenticato.leggereRecensioni
		throw new UnsupportedOperationException();
	}

	//endregion

}