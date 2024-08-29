package classes.media;

import java.io.File;

public class Foto {

	//region Vars

	private long ID;
	private String descrizione;
	private File foto;
	private boolean approvazione;

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

	public long getID() {
		return ID;
	}

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
		// TODO - implement Foto.approvato
		throw new UnsupportedOperationException();
	}

}