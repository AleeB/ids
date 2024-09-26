package it.unicam.cs.ItalianWonder.classes.users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.classes.POI.Ristorante;
import it.unicam.cs.ItalianWonder.classes.Recensione;
import it.unicam.cs.ItalianWonder.classes.Salvare;
import it.unicam.cs.ItalianWonder.classes.Segnalazione;
import it.unicam.cs.ItalianWonder.classes.media.Foto;
import it.unicam.cs.ItalianWonder.classes.media.Video;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Contributor extends Turista {

	@OneToMany(mappedBy = "contributor")
	private List<Foto> foto;

	@OneToMany(mappedBy = "contributor")
	private List<Video> video;

	@OneToMany(mappedBy = "contributor")
	private List<Divertimento> divertimenti;

	@OneToMany(mappedBy = "contributor")
	private List<Itinerario> itinerari;

	@OneToMany(mappedBy = "contributor")
	private List<Ristorante> ristoranti;

	@ManyToMany
	@JoinTable(
			name = "contributor_segnalazione",
			joinColumns = @JoinColumn(name = "contributor_id"),
			inverseJoinColumns = @JoinColumn(name = "segnalazione_id")
	)
	private List<Segnalazione> segnalazioni;

	@ManyToMany
	@JoinTable(
			name = "contributor_recensione",
			joinColumns = @JoinColumn(name = "contributor_id"),
			inverseJoinColumns = @JoinColumn(name = "recensione_id")
	)
	private List<Recensione> recensioni;


	public Contributor() {
		super();
	}

	public Contributor(Turista turista){
		super(turista);
	}


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

	public List<Recensione> getRecensioni() {
		return recensioni;
	}

	public void setRecensioni(List<Recensione> recensioni) {
		this.recensioni = recensioni;
	}

	//endregion

}