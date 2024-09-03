package classes.users;

import classes.enums.enumTipoUtente;
import jakarta.persistence.*;


public class Animatore extends ContributorAutorizzato {



	public Animatore(String nome, String cognome, String userName, String password, int punteggio, enumTipoUtente tipoUser){
		super(nome, cognome, userName, password, punteggio, tipoUser);
	}

	public Animatore() {
		super();
	}

	//region Methods

	public void assegnazioniPunteggiContest() {
		// TODO - implement Animatore.assegnazioniPunteggiContest
		throw new UnsupportedOperationException();
	}

	public void animatore() {
		// TODO - implement Animatore.animatore
		throw new UnsupportedOperationException();
	}

	//endregion

}