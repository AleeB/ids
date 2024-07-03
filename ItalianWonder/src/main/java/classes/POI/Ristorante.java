package classes.POI;

import classes.enums.enumValutazione;

public class Ristorante {

	private long ID;
	private String nome;
	private String numeroTelefono;
	private enumValutazione valutazione;		//inserito quando viene caricato il ristorante (no media)
	private float costoMedio;
	private boolean approvazione;

	public Ristorante(long ID, String nome, String numeroTelefono, enumValutazione valutazione, float costoMedio, boolean approvazione) {
		this.ID = ID;
		this.nome = nome;
		this.numeroTelefono = numeroTelefono;
		this.valutazione = valutazione;
		this.costoMedio = costoMedio;
		this.approvazione = approvazione;
	}

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public enumValutazione getValutazione() {
		return valutazione;
	}

	public void setValutazione(enumValutazione valutazione) {
		this.valutazione = valutazione;
	}

	public float getCostoMedio() {
		return costoMedio;
	}

	public void setCostoMedio(float costoMedio) {
		this.costoMedio = costoMedio;
	}

	public boolean isApprovazione() {
		return approvazione;
	}

	public void setApprovazione(boolean approvazione) {
		this.approvazione = approvazione;
	}


	public void ristorante() {
		// TODO - implement Ristorante.ristorante
		throw new UnsupportedOperationException();
	}

	public boolean approvazione() {
		// TODO - implement Ristorante.approvazione
		throw new UnsupportedOperationException();
	}

	public boolean modificaNumeroTelefono() {
		// TODO - implement Ristorante.modificaNumeroTelefono
		throw new UnsupportedOperationException();
	}

	public boolean modificaCostoMedio() {
		// TODO - implement Ristorante.modificaCostoMedio
		throw new UnsupportedOperationException();
	}

}