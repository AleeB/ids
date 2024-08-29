package classes;
import classes.media.Foto;

import java.time.LocalDateTime;
import java.util.*;

public class Contest {

	//region Vars

	private long ID;
	private LocalDateTime dataInizio;
	private LocalDateTime dataFine;
	private String titolo;

	//endregion

	//region Props

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public LocalDateTime getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDateTime getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	//endregion

	//region Constr

	public Contest() {
		this.ID = Integer.MAX_VALUE;
		this.dataInizio = LocalDateTime.now();
		this.dataFine = LocalDateTime.now();
		this.titolo = "";
	}

	public Contest(long id ,LocalDateTime dataInizio, LocalDateTime dataFine, String titolo) {
		this.ID = id;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.titolo = titolo;
	}

	//endregion

	//region Methods

	/**
	 * 
	 * @param idContest
	 */
	public List<Foto> mostraFotoContest(long idContest) {
		// TODO - implement Contest.mostraFotoContest
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idContest
	 */
	public List<Foto> creaClassificaContest(long idContest) {
		// TODO - implement Contest.creaClassificaContest
		throw new UnsupportedOperationException();
	}

	/**
	 * imposta la data di chiusura a datetime.now
	 */
	public boolean chiudiContest() {
		// TODO - implement Contest.chiudiContest
		throw new UnsupportedOperationException();
	}

	//endregion

}