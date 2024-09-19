package it.unicam.cs.ItalianWonder.classes.users;

import it.unicam.cs.ItalianWonder.classes.Segnalazione;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Curatore extends ContributorAutorizzato {

	//region Vars

	@ManyToMany
	@JoinTable(
			name = "curatore_segnalazione",
			joinColumns = @JoinColumn(name = "curatore_id"),
			inverseJoinColumns = @JoinColumn(name = "segnalazione_id")
	)
	private List<Segnalazione> segnalazioni;

	//endregion

	//region Props

	@Override
	public List<Segnalazione> getSegnalazioni() {
		return segnalazioni;
	}

	@Override
	public void setSegnalazioni(List<Segnalazione> segnalazioni) {
		this.segnalazioni = segnalazioni;
	}


	//endregion

	public Curatore() {
		super();
	}

	//region Methods

	/**
	 * 
	 * @param segnalazione
	 */
	public boolean segnalazioneComune(Segnalazione segnalazione) {
		// TODO - implement Curatore.segnalazioneComune
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param segnalazione
	 */
	public boolean segnalazioneDivertimento(Segnalazione segnalazione) {
		// TODO - implement Curatore.segnalazioneDivertimento
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param segnalazione
	 */
	public boolean segnalazioneRistorante(Segnalazione segnalazione) {
		// TODO - implement Curatore.segnalazioneRistorante
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param segnalazione
	 */
	public boolean segnalzioneItinerario(Segnalazione segnalazione) {
		// TODO - implement Curatore.segnalzioneItinerario
		throw new UnsupportedOperationException();
	}

	//endregion

}