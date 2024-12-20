package it.unicam.cs.ItalianWonder.classes.users;

import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.classes.POI.PuntoRistoro;
import it.unicam.cs.ItalianWonder.classes.Segnalazione;
import it.unicam.cs.ItalianWonder.classes.media.Foto;
import it.unicam.cs.ItalianWonder.classes.media.Video;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ContributorAutorizzato extends Turista {

	//region Vars

	@OneToMany(mappedBy = "contributorAutorizzato")
	private List<Foto> foto;

	@OneToMany(mappedBy = "contributorAutorizzato")
	private List<Video> video;

	@OneToMany(mappedBy = "contributorAutorizzato")
	private List<Divertimento> divertimenti;

	@OneToMany(mappedBy = "contributorAutorizzato")
	private List<Itinerario> itinerari;

	@OneToMany(mappedBy = "contributorAutorizzato")
	private List<PuntoRistoro> ristoranti;

	@ManyToMany
	@JoinTable(
			name = "contributorAutorizzato_segnalazione",
			joinColumns = @JoinColumn(name = "contributorAutorizzato_id"),
			inverseJoinColumns = @JoinColumn(name = "segnalazione_id")
	)
	private List<Segnalazione> segnalazioni;

	//endregion

	//region Constr

	public ContributorAutorizzato() {
		super();
	}

	public ContributorAutorizzato(Turista tur) {
		super(tur);
	}

	//endregion

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

	public List<Divertimento> getDivertimenti() {
		return divertimenti;
	}

	public void setDivertimenti(List<Divertimento> divertimenti) {
		this.divertimenti = divertimenti;
	}

	public List<Itinerario> getItinerari() {
		return itinerari;
	}

	public void setItinerari(List<Itinerario> itinerari) {
		this.itinerari = itinerari;
	}

	public List<PuntoRistoro> getRistoranti() {
		return ristoranti;
	}

	public void setRistoranti(List<PuntoRistoro> ristoranti) {
		this.ristoranti = ristoranti;
	}

	public List<Segnalazione> getSegnalazioni() {
		return segnalazioni;
	}

	public void setSegnalazioni(List<Segnalazione> segnalazioni) {
		this.segnalazioni = segnalazioni;
	}

	//endregion

}