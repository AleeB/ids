package classes;

import classes.enums.enumTipoSegnalazione;
import jakarta.persistence.*;

@Entity
@Table
public class Segnalazione {

	@Id

	@SequenceGenerator(
			name = "segnalazione_sequence",
			sequenceName = "segnalazione_sequence",
			allocationSize = 1

	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "segnalazione_sequence"
	)

	//region Vars

	private long ID;
	private enumTipoSegnalazione tipo;
	private boolean verificata;

	//endregion

	//region Props

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public enumTipoSegnalazione getTipo() {
		return tipo;
	}

	public void setTipo(enumTipoSegnalazione tipo) {
		this.tipo = tipo;
	}

	public boolean isVerificata() {
		return verificata;
	}

	public void setVerificata(boolean verificata) {
		this.verificata = verificata;
	}


	//endregion

	//region Constr

	public Segnalazione() {
		this.ID = 0;
		this.tipo = enumTipoSegnalazione.foto;
		this.verificata = false;
	}

	public Segnalazione(long ID, enumTipoSegnalazione tipo, long idContenuto, boolean verificata) {
		this.ID = ID;
		this.tipo = tipo;
		this.verificata = verificata;
	}

	//endregion

	//region Methods

	public boolean verifica() {
		// TODO - implement Segnalazione.verifica
		throw new UnsupportedOperationException();
	}

	//endregion

}