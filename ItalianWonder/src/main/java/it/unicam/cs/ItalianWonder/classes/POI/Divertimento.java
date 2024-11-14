package it.unicam.cs.ItalianWonder.classes.POI;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.unicam.cs.ItalianWonder.classes.Localizzazione;
import it.unicam.cs.ItalianWonder.classes.Recensione;
import it.unicam.cs.ItalianWonder.classes.enums.enumTipoDivertimento;
import it.unicam.cs.ItalianWonder.classes.media.Foto;
import it.unicam.cs.ItalianWonder.classes.media.Video;
import it.unicam.cs.ItalianWonder.classes.users.Contributor;
import it.unicam.cs.ItalianWonder.classes.users.ContributorAutorizzato;
import jakarta.persistence.*;

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
	private enumTipoDivertimento tipo;
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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "ID", name = "loc_div")
	@JsonManagedReference(value = "jdivertimento")
	private Localizzazione localizzazione;

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

	public enumTipoDivertimento getTipo() {
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

	public void setTipo(enumTipoDivertimento tipo) {
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
	//endregion

}