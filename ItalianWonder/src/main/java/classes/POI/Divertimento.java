package classes.POI;

import classes.Comune;
import classes.Localizzazione;
import classes.Recensione;
import classes.Salvare;
import classes.media.Foto;
import classes.media.Video;
import classes.users.Contributor;
import classes.users.ContributorAutorizzato;
import classes.users.Turista;
import classes.users.UserNonAutenticato;
import jakarta.persistence.*;
import org.apache.catalina.User;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table
public class Divertimento {

	@Id

	@SequenceGenerator(
			name = "divertimento_sequence",
			sequenceName = "divertimento_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "divertimento_sequence"
	)


	//region Vars

	private long ID;
	private String titolo;
	private float tipo;
	private LocalDateTime dataInizio;
	private LocalDateTime dataFine;
	private float costo;
	private Boolean approvazione;

	@OneToMany(mappedBy = "divertimento")
	private List<Foto> foto;

	@OneToMany(mappedBy = "divertimento")
	private List<Video> video;

	@OneToMany(mappedBy = "divertimento")
	private List<Recensione> recensioni;

	@ManyToOne
	@JoinColumn(name = "contributor_id")
	private Contributor contributor;

	@ManyToOne
	@JoinColumn(name = "contributorAutorizzato_id")
	private ContributorAutorizzato contributorAutorizzato;

	@OneToOne
	@JoinColumn(name = "localizzazione_id")
	private Localizzazione localizzazione;

	@OneToMany(mappedBy = "divertimento")
	private List<Salvare> salvare;

	@ManyToMany
	@JoinTable(
			name = "userNonAutenticato_divertimento",
			joinColumns = @JoinColumn(name = "divertimento_id"),
			inverseJoinColumns = @JoinColumn(name = "userNonAutenticato_id")
	)
	private List<UserNonAutenticato> una;

	@ManyToMany
	@JoinTable(
			name = "turista_divertimento",
			joinColumns = @JoinColumn(name = "divertimento_id"),
			inverseJoinColumns = @JoinColumn(name = "turista_id")
	)
	private List<Turista> turisti;

	//endregion

	//region Constr

	public Divertimento() {
	}

	//endregion

	//region Props

	public long getID() {
		return ID;
	}

	public String getTitolo() {
		return titolo;
	}

	public float getTipo() {
		return tipo;
	}

	public LocalDateTime getDataInizio() {
		return dataInizio;
	}

	public LocalDateTime getDataFine() {
		return dataFine;
	}

	public float getCosto() {
		return costo;
	}

	public Boolean getApprovazione() {
		return approvazione;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setTipo(float tipo) {
		this.tipo = tipo;
	}

	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}

	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public void setApprovazione(Boolean approvazione) {
		this.approvazione = approvazione;
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

	public List<Recensione> getRecensioni() {
		return recensioni;
	}

	public void setRecensioni(List<Recensione> recensioni) {
		this.recensioni = recensioni;
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

	public Localizzazione getLocalizzazione() {
		return localizzazione;
	}

	public void setLocalizzazione(Localizzazione localizzazione) {
		this.localizzazione = localizzazione;
	}

	public List<Salvare> getSalvare() {
		return salvare;
	}

	public void setSalvare(List<Salvare> salvare) {
		this.salvare = salvare;
	}

	public List<UserNonAutenticato> getUna() {
		return una;
	}

	public void setUna(List<UserNonAutenticato> una) {
		this.una = una;
	}

	//endregion

	//region Methods

	public void divertimento() {
		// TODO - implement Divertimento.divertimento
		throw new UnsupportedOperationException();
	}

	public boolean modificaCosto() {
		// TODO - implement Divertimento.modificaCosto
		throw new UnsupportedOperationException();
	}

	public boolean modificaDataInizioFine() {
		// TODO - implement Divertimento.modificaDataInizioFine
		throw new UnsupportedOperationException();
	}

	public boolean approvazione() {
		// TODO - implement Divertimento.approvazione
		throw new UnsupportedOperationException();
	}

	//endregion

}