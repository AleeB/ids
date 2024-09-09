package classes;

import classes.enums.enumTipoSegnalazione;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Segnalazione {



	//region Vars

	private long ID;
	private enumTipoSegnalazione tipo;
	private long idContenuto;
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

	public long getIdContenuto() {
		return idContenuto;
	}

	public void setIdContenuto(long idContenuto) {
		this.idContenuto = idContenuto;
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
		this.idContenuto = 0;
		this.verificata = false;
	}

	public Segnalazione(long ID, enumTipoSegnalazione tipo, long idContenuto, boolean verificata) {
		this.ID = ID;
		this.tipo = tipo;
		this.idContenuto = idContenuto;
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