package classes.media;

import jakarta.persistence.*;

import java.io.File;

@Entity
@Table
public class Foto {

	@Id

	@SequenceGenerator(
			name = "foto_sequence",
			sequenceName = "foto_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "foto_sequence"
	)

	//region Vars

	private long ID;
	private String descrizione;
	private File foto;
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

	public File getFoto() {
		return foto;
	}

	public void setFoto(File foto) {
		this.foto = foto;
	}

	public boolean isApprovato() {
		return approvazione;
	}

	public void setApprovazione(boolean approvazione) {
		this.approvazione = approvazione;
	}


	//endregion

	//region Constuctors

	public Foto() {
		this.descrizione = "";
		this.foto = null;
		this.approvazione = false;
	}

	public Foto(long ID, String descrizione, File foto, boolean approvazione) {
		this.descrizione = descrizione;
		this.foto = foto;
		this.approvazione = approvazione;
	}
	
	//endregion

	public boolean approvato(int idFoto) {
		// TODO - implement Foto.approvato
		throw new UnsupportedOperationException();
	}

}