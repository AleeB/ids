package classes;

import classes.enums.enumValutazione;
import jakarta.persistence.*;

@Entity
@Table
public class Recensione {

	@Id

	@SequenceGenerator(
			name = "recensione_sequence",
			sequenceName = "recensione_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "recensione_sequence"
	)

	//region Vars

	private long ID;
	private String descrizione;
	private int valutazione;	//da 1 a 5
	private boolean verificata;

	//endregion

	//region Props

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getValutazione() {
		return valutazione;
	}

	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}

	public boolean isVerificata() {
		return verificata;
	}

	public void setVerificata(boolean verificata) {
		this.verificata = verificata;
	}

	//endregion

	//region Constr

	public Recensione() {
		this.ID = Long.MAX_VALUE;
		this.descrizione = "";
		this.valutazione = 0;
		this.verificata = false;
	}

	public Recensione(long ID, String descrizione, int valutazione, boolean verificata) {
		this.ID = ID;
		this.descrizione = descrizione;
		this.valutazione = valutazione;
		this.verificata = verificata;
	}

	//endregion

	//region Methods

	public void verifica() {
		// TODO - implement Recensione.verifica
		throw new UnsupportedOperationException();
	}

	//endregion

}