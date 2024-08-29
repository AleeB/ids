package classes.POI;

import classes.enums.enumDifficolta;

import java.util.*;

public class Itinerario {

	//region Vars

	private long ID;
	private String titolo;
	private float lunghezza;
	private float costo;
	private String descrizione;
	private boolean approvazione;
	private enumDifficolta difficolta;

	//endregion

	//region Constr

	public Itinerario(long id, String tit, float lun, float costo, String descrizione, boolean approvazione, enumDifficolta difficolta) {
		this.ID = id;
		this.titolo = tit;
		this.lunghezza = lun;
		this.costo = costo;
		this.descrizione = descrizione;
		this.approvazione = approvazione;
		this.difficolta = difficolta;
	}

	//endregion

	//region Props

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public float getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(float lunghezza) {
		this.lunghezza = lunghezza;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public boolean isApprovazione() {
		return approvazione;
	}

	public void setApprovazione(boolean approvazione) {
		this.approvazione = approvazione;
	}

	public enumDifficolta getDifficolta() {
		return difficolta;
	}

	public void setDifficolta(enumDifficolta difficolta) {
		this.difficolta = difficolta;
	}

	//endregion

	//region Methods

	public void itinerario() {
		// TODO - implement Itinerario.itinerario
		throw new UnsupportedOperationException();
	}

	public boolean approvazione() {
		// TODO - implement Itinerario.approvazione
		throw new UnsupportedOperationException();
	}

	public boolean modificaCosto() {
		// TODO - implement Itinerario.modificaCosto
		throw new UnsupportedOperationException();
	}

	public boolean modificaLunghezza() {
		// TODO - implement Itinerario.modificaLunghezza
		throw new UnsupportedOperationException();
	}

	public List<Itinerario> mostraItinerarioComune() {
		// TODO - implement Itinerario.mostraItinerarioComune
		throw new UnsupportedOperationException();
	}

	public boolean modificaDifficolta() {
		// TODO - implement Itinerario.modificaDifficolta
		throw new UnsupportedOperationException();
	}

	//endregion

}