package classes.users;

import classes.Segnalazione;
import classes.enums.enumTipoUtente;
import classes.media.Video;

public class ContributorAutorizzato extends Turista {

	public ContributorAutorizzato() {
		super();
	}

	public ContributorAutorizzato(String nome, String cognome, String userName, String password, int punteggio, enumTipoUtente tipoUser){
		super(nome, cognome, userName, password, punteggio, tipoUser);
	}

	//region Methods

	/**
	 * 
	 * @param segnalazione
	 */
	public boolean segnalazioneFoto(Segnalazione segnalazione) {
		// TODO - implement ContributorAutorizzato.segnalazioneFoto
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param segnalazione
	 */
	public boolean segnalazioneVideo(Video segnalazione) {
		// TODO - implement ContributorAutorizzato.segnalazioneVideo
		throw new UnsupportedOperationException();
	}

	//endregion

}