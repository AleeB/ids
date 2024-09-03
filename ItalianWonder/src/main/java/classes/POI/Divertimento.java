package classes.POI;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table
public class Divertimento {

	@Id

	@SequenceGenerator(
			name = "divertimento_sequence",
			sequenceName = "divertimento_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "divertimento_sequence"
	)


	//region Vars

	private long ID;
	private String titolo;
	private float tipo;
	private LocalDateTime dataInizio;
	private LocalDateTime dataFine;
	private float costo;
	private Boolean approvazione;

	//endregion

	//region Constr

	public Divertimento(String tit, float type, LocalDateTime start, LocalDateTime end, float cost, Boolean app) {
		this.titolo = tit;
		this.tipo = type;
		this.dataInizio = start;
		this.dataFine = end;
		this.costo = cost;
		this.approvazione = app;
	}

	public Divertimento() {
		this.titolo = "";
		this.tipo = 0;
		this.dataInizio = LocalDateTime.now();
		this.dataFine = LocalDateTime.now();
		this.costo = 0;
		this.approvazione = false;
	}

	//endregion

	//region Props

	public long getID() {
		return ID;
	}

	public String getTitolo() {
		return titolo;
	}

	public float getTipo() {
		return tipo;
	}

	public LocalDateTime getDataInizio() {
		return dataInizio;
	}

	public LocalDateTime getDataFine() {
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

	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}

	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public void setApprovazione(Boolean approvazione) {
		this.approvazione = approvazione;
	}

	//endregion

	//region Methods

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

	//endregion

}