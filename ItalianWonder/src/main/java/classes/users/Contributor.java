package classes.users;

import classes.Segnalazione;
import classes.enums.enumTipoUtente;

public class Contributor extends Turista {

	public Contributor() {
		super();
	}

	public Contributor(String nome, String cognome, String userName, String password, int punteggio, enumTipoUtente tipoUser) {
		super(nome, cognome, userName, password, punteggio, tipoUser);
	}

	//region Methods

	/**
	 * con la verifica impostata su true
	 * @param recensione
	 */
	public Segnalazione segnalazioneRecensione(Segnalazione recensione) {
		// TODO - implement Contributor.segnalazioneRecensione
		throw new UnsupportedOperationException();
	}

	public void contributor() {
		// TODO - implement Contributor.contributor
		throw new UnsupportedOperationException();
	}

	//endregion

}