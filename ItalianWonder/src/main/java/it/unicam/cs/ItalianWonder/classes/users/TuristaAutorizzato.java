package it.unicam.cs.ItalianWonder.classes.users;

import it.unicam.cs.ItalianWonder.classes.Salvare;
import it.unicam.cs.ItalianWonder.classes.media.Foto;
import it.unicam.cs.ItalianWonder.classes.media.Video;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TuristaAutorizzato extends Turista {

	@OneToMany(mappedBy = "turistaAutorizzato")
	private List<Foto> foto;

	@OneToMany(mappedBy = "turistaAutorizzato")
	private List<Video> video;

	@OneToMany(mappedBy = "turistaAutorizzato")
	private List<Salvare> salvare;

	//region Props

	public List<Foto> getFoto() {
		return foto;
	}

	public void setFoto(List<Foto> foto) {
		this.foto = foto;
	}

	public List<Video> getVideo() {
		return video;
	}

	public void setVideo(List<Video> video) {
		this.video = video;
	}

	//endregion


	public TuristaAutorizzato() {
		super();
	}

	//region Methods

	public boolean salvaInformazione() {
		// TODO - implement TuristaAutorizzato.salvaInformazione
		throw new UnsupportedOperationException();
	}

	//endregion

}