package classes.POI;

import java.util.*;

public class Divertimento {

	private long ID;
	private String titolo;
	private float tipo;
	private Date dataInizio;
	private Date dataFine;
	private float costo;
	private Boolean approvazione;

	public Divertimento(long id, String tit, float type, Date start, Date end, float cost, Boolean app) {
		this.ID = id;
		this.titolo = tit;
		this.tipo = type;
		this.dataInizio = start;
		this.dataFine = end;
		this.costo = cost;
		this.approvazione = app;
	}

	public long getID() {
		return ID;
	}

	public String getTitolo() {
		return titolo;
	}

	public float getTipo() {
		return tipo;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public float getCosto() {
		return costo;
	}

	public Boolean getApprovazione() {
		return approvazione;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setTipo(float tipo) {
		this.tipo = tipo;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public void setApprovazione(Boolean approvazione) {
		this.approvazione = approvazione;
	}

	public void divertimento() {
		// TODO - implement Divertimento.divertimento
		throw new UnsupportedOperationException();
	}

	public boolean modificaCosto() {
		// TODO - implement Divertimento.modificaCosto
		throw new UnsupportedOperationException();
	}

	public boolean modificaDataInizioFine() {
		// TODO - implement Divertimento.modificaDataInizioFine
		throw new UnsupportedOperationException();
	}

	public boolean approvazione() {
		// TODO - implement Divertimento.approvazione
		throw new UnsupportedOperationException();
	}



}