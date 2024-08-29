package classes.media;

import java.io.File;

public class Foto {

	//region Vars

	private long ID;
	private String descrizione;
	private File foto;
	private boolean approvazione;

<<<<<<< Updated upstream
	//endregion

	//region Props

	public boolean isApprovazione() {
		return approvazione;
	}

	public void setApprovazione(boolean approvazione) {
		this.approvazione = approvazione;
	}

	public File getFoto() {
		return foto;
	}

	public void setFoto(File foto) {
		this.foto = foto;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
=======
	//region Constuctors

	public Foto(long iD, String descrizione, Blob foto, boolean approvazione) {
		ID = iD;
		this.descrizione = descrizione;
		this.foto = foto;
		this.approvazione = approvazione;
	}

	public Foto(){
		this.approvazione = false;
		this.descrizione = "";
		this.foto = null;
	}	
	
	//endregion

	//region Properties
>>>>>>> Stashed changes

	public long getID() {
		return ID;
	}

<<<<<<< Updated upstream
	public void setID(long ID) {
		this.ID = ID;
	}

	//endregion

	public Foto() {
		this.ID = Integer.MAX_VALUE;
		this.descrizione = "";
		this.foto = null;
		this.approvazione = false;
	}

	public Foto(long ID, String descrizione, File foto, boolean approvazione) {
		this.ID = ID;
		this.descrizione = descrizione;
		this.foto = foto;
		this.approvazione = approvazione;
	}

	public boolean approvato(int index) {
=======

	public void setID(long iD) {
		ID = iD;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public Blob getFoto() {
		return foto;
	}


	public void setFoto(Blob foto) {
		this.foto = foto;
	}


	public boolean isApprovazione() {
		return approvazione;
	}


	public void setApprovazione(boolean approvazione) {
		this.approvazione = approvazione;
	}
	
	//endregion

	public boolean approvato(int idFoto) {
>>>>>>> Stashed changes
		// TODO - implement Foto.approvato
		throw new UnsupportedOperationException();
	}

}