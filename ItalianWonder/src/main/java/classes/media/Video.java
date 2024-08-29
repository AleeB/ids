package classes.media;

import java.io.File;
import java.sql.Blob;

public class Video {

	private long ID;
	private String descrizione;
	private File video;
	private boolean approvazione;

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

	public File getVideo() {
		return video;
	}

	public void setVideo(File video) {
		this.video = video;
	}

	public boolean isApprovazione() {
		return approvazione;
	}

	public void setApprovazione(boolean approvazione) {
		this.approvazione = approvazione;
	}


	//endregion


	public void video() {
		// TODO - implement Video.video
		throw new UnsupportedOperationException();
	}

	public void approvato() {
		// TODO - implement Video.approvato
		throw new UnsupportedOperationException();
	}

}