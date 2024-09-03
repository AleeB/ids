package classes.media;

import jakarta.persistence.*;

import java.io.File;
import java.sql.Blob;

@Entity
@Table
public class Video {

	@Id

	@SequenceGenerator(
			name = "video_sequence",
			sequenceName = "video_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "video_sequence"
	)

	//region Vars

	private long ID;
	private String descrizione;
	private File video;
	private boolean approvazione;

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

	//region Constr

	public Video() {
		this.approvazione = false;
		this.video = null;
		this.descrizione = null;
	}

	public Video(String descrizione, File video, boolean approvazione) {
		this.descrizione = descrizione;
		this.video = video;
		this.approvazione = approvazione;
	}

	//endregion

	//region Methods

	public void video() {
		// TODO - implement Video.video
		throw new UnsupportedOperationException();
	}

	public void approvato() {
		// TODO - implement Video.approvato
		throw new UnsupportedOperationException();
	}

	//endregion

}