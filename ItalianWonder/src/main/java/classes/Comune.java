package classes;

import java.util.*;

public class Comune {

	//region Vars

	private String nome;
	private Localizzazione localizazione;

	//endregion

	//region Props

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Localizzazione getLocalizazione() {
		return localizazione;
	}

	public void setLocalizazione(Localizzazione localizazione) {
		this.localizazione = localizazione;
	}

	//endregion

	//region Constr

	public Comune(String nome, Localizzazione localizazione) {
		this.nome = nome;
		this.localizazione = localizazione;
	}

	public Comune() {
		this.nome = "";
		this.localizazione = new Localizzazione();
	}

	//endregion

	//region Methods

	public Comune mostraComuni() {
		// TODO - implement Comune.mostraComuni
		throw new UnsupportedOperationException();
	}

	//endregion

}