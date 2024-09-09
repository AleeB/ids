package classes.users;

import classes.enums.enumTipoUtente;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
public class TuristaAutorizzato extends Turista {



	public TuristaAutorizzato() {
		super();
	}

	public TuristaAutorizzato(String nome, String cognome, String userName, String password, int punteggio, enumTipoUtente tipoUser){
		super(nome, cognome, userName, password, punteggio, tipoUser);
	}

	//region Methods

	public boolean salvaInformazione() {
		// TODO - implement TuristaAutorizzato.salvaInformazione
		throw new UnsupportedOperationException();
	}

	//endregion

}