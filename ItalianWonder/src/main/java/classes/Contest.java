package classes;
import classes.media.Foto;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table
public class Contest {

	@Id

	@SequenceGenerator(
			name = "contest_sequence",
			sequenceName = "contest_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			generator = "contest_sequence",
			strategy = GenerationType.SEQUENCE
	)

	//region Vars

	private long Id;
	private LocalDateTime dataInizio;
	private LocalDateTime dataFine;
	private String titolo;

	//endregion

	//region Props

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		this.Id = id;
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
		this.Id = Integer.MAX_VALUE;
		this.dataInizio = LocalDateTime.now();
		this.dataFine = LocalDateTime.now();
		this.titolo = "";
	}

	public Contest(long id ,LocalDateTime dataInizio, LocalDateTime dataFine, String titolo) {
		this.Id = id;
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