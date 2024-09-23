package it.unicam.cs.ItalianWonder.classes.POI;

import it.unicam.cs.ItalianWonder.classes.Localizzazione;
import it.unicam.cs.ItalianWonder.classes.Recensione;
import it.unicam.cs.ItalianWonder.classes.Salvare;
import it.unicam.cs.ItalianWonder.classes.enums.enumDifficolta;
import it.unicam.cs.ItalianWonder.classes.media.Foto;
import it.unicam.cs.ItalianWonder.classes.media.Video;
import it.unicam.cs.ItalianWonder.classes.users.Contributor;
import it.unicam.cs.ItalianWonder.classes.users.ContributorAutorizzato;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import it.unicam.cs.ItalianWonder.classes.users.UserNonAutenticato;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table
public class Itinerario {

	@Id

	@SequenceGenerator(
			name = "itinerario_sequence",
			sequenceName = "itinerario_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "itinerario_sequence"
	)

	//region Vars

	private long ID;
	private String titolo;
	private float lunghezza;
	private float costo;
	private String descrizione;
	private boolean approvazione;
	private enumDifficolta difficolta;

	@OneToMany(mappedBy = "itinerario")
	private List<Foto> foto;

	@OneToMany(mappedBy = "itinerario")
	private List<Video> video;

	@OneToMany(mappedBy = "itinerario")
	private List<Recensione> recensioni;

	@ManyToOne
	@JoinColumn(name = "contributor_id")
	private Contributor contributor;

	@ManyToOne
	@JoinColumn(name = "contributorAutorizzato_id")
	private ContributorAutorizzato contributorAutorizzato;

	@ManyToMany
	@JoinTable(
			name = "itinerario_localizzazione",
			joinColumns = @JoinColumn(name = "itinerario_id"),
			inverseJoinColumns = @JoinColumn(name = "localizzazione_id")
	)
	private List<Localizzazione> localizzazioni;

	//endregion

	//region Constr

	public Itinerario() {
	}

	//endregion

	//region Props

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public float getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(float lunghezza) {
		this.lunghezza = lunghezza;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public boolean isApprovazione() {
		return approvazione;
	}

	public void setApprovazione(boolean approvazione) {
		this.approvazione = approvazione;
	}

	public enumDifficolta getDifficolta() {
		return difficolta;
	}

	public void setDifficolta(enumDifficolta difficolta) {
		this.difficolta = difficolta;
	}

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

	public Contributor getContributor() {
		return contributor;
	}

	public void setContributor(Contributor contributor) {
		this.contributor = contributor;
	}

	public ContributorAutorizzato getContributorAutorizzato() {
		return contributorAutorizzato;
	}

	public void setContributorAutorizzato(ContributorAutorizzato contributorAutorizzato) {
		this.contributorAutorizzato = contributorAutorizzato;
	}

	public List<Localizzazione> getLocalizzazione() {
		return localizzazioni;
	}

	public void setLocalizzazione(List<Localizzazione> localizzazioni) {
		this.localizzazioni = localizzazioni;
	}

	public List<Recensione> getRecensioni() {
		return recensioni;
	}

	public void setRecensioni(List<Recensione> recensioni) {
		this.recensioni = recensioni;
	}

	//endregion

	//region Methods

	public void itinerario() {
		// TODO - implement Itinerario.itinerario
		throw new UnsupportedOperationException();
	}

	public boolean approvazione() {
		// TODO - implement Itinerario.approvazione
		throw new UnsupportedOperationException();
	}

	public boolean modificaCosto() {
		// TODO - implement Itinerario.modificaCosto
		throw new UnsupportedOperationException();
	}

	public boolean modificaLunghezza() {
		// TODO - implement Itinerario.modificaLunghezza
		throw new UnsupportedOperationException();
	}

	public List<Itinerario> mostraItinerarioComune() {
		// TODO - implement Itinerario.mostraItinerarioComune
		throw new UnsupportedOperationException();
	}

	public boolean modificaDifficolta() {
		// TODO - implement Itinerario.modificaDifficolta
		throw new UnsupportedOperationException();
	}

	//endregion

}