package classes.users;

import classes.Segnalazione;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class GestoreDellaPiattaforma extends Curatore {

	//region Vars



	//endregion

	//region Props



	//endregion

	public GestoreDellaPiattaforma() {
		super();
	}

	//region Methods

	/**
	 * 
	 * @param utente
	 */
	public boolean cambiaRuolo(Object utente) {
		// TODO - implement GestoreDellaPiattaforma.cambiaRuolo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param segnalazione
	 */
	public boolean segnalazioneBug(Segnalazione segnalazione) {
		// TODO - implement GestoreDellaPiattaforma.segnalazioneBug
		throw new UnsupportedOperationException();
	}

	//endregion

}