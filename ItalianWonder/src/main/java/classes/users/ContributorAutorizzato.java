package classes.users;

import classes.POI.Divertimento;
import classes.POI.Itinerario;
import classes.POI.Ristorante;
import classes.Salvare;
import classes.Segnalazione;
import classes.enums.enumTipoUtente;
import classes.media.Foto;
import classes.media.Video;
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
	private List<Ristorante> ristoranti;

	@ManyToMany
	@JoinTable(
			name = "contributorAutorizzato_segnalazione",
			joinColumns = @JoinColumn(name = "contributorAutorizzato_id"),
			inverseJoinColumns = @JoinColumn(name = "segnalazione_id")
	)
	private List<Segnalazione> segnalazioni;

	@OneToMany(mappedBy = "contributorAutorizzato")
	private List<Salvare> salvare;

	//endregion

	//region Constr

	public ContributorAutorizzato() {
		super();
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

	public List<Ristorante> getRistoranti() {
		return ristoranti;
	}

	public void setRistoranti(List<Ristorante> ristoranti) {
		this.ristoranti = ristoranti;
	}

	public List<Segnalazione> getSegnalazioni() {
		return segnalazioni;
	}

	public void setSegnalazioni(List<Segnalazione> segnalazioni) {
		this.segnalazioni = segnalazioni;
	}

	public List<Salvare> getSalvare() {
		return salvare;
	}

	public void setSalvare(List<Salvare> salvare) {
		this.salvare = salvare;
	}

	//endregion

	//region Methods

	/**
	 * 
	 * @param segnalazione
	 */
	public boolean segnalazioneFoto(Segnalazione segnalazione) {
		// TODO - implement ContributorAutorizzato.segnalazioneFoto
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param segnalazione
	 */
	public boolean segnalazioneVideo(Video segnalazione) {
		// TODO - implement ContributorAutorizzato.segnalazioneVideo
		throw new UnsupportedOperationException();
	}

	//endregion

}