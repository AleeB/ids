package it.unicam.cs.ItalianWonder.classes.POI;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.unicam.cs.ItalianWonder.classes.Localizzazione;
import it.unicam.cs.ItalianWonder.classes.Recensione;
import it.unicam.cs.ItalianWonder.classes.media.Foto;
import it.unicam.cs.ItalianWonder.classes.media.Video;
import it.unicam.cs.ItalianWonder.classes.users.Contributor;
import it.unicam.cs.ItalianWonder.classes.users.ContributorAutorizzato;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class PuntoRistoro {

	@Id

	@SequenceGenerator(
			name = "PuntoRistoro_sequence",
			sequenceName = "PuntoRistoro_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "PuntoRistoro_sequence"
	)

	//region Vars

	private long ID;
	private String nome;
	private String numeroTelefono;
	private int valutazione;		//inserito quando viene caricato il PuntoRistoro (no media)
	private float costoMedio;
	private boolean approvazione;

	@OneToMany(mappedBy = "puntoRistoro")
	private List<Foto> foto;

	@OneToMany(mappedBy = "puntoRistoro")
	private List<Video> video;

	@OneToMany(mappedBy = "puntoRistoro")
	private List<Recensione> recensioni;

	@ManyToOne
	@JoinColumn(name = "contributor_id")
	private Contributor contributor;

	@ManyToOne
	@JoinColumn(name = "contributorAutorizzato_id")
	private ContributorAutorizzato contributorAutorizzato;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "ID", name = "loc_ris")
	@JsonManagedReference(value = "jPuntoRistoro")
	private Localizzazione localizzazione;

	//endregion

	//region Constr

	public PuntoRistoro() {
	}

	//endregion

	//region Props

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public int getValutazione() {
		return valutazione;
	}

	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}

	public float getCostoMedio() {
		return costoMedio;
	}

	public void setCostoMedio(float costoMedio) {
		this.costoMedio = costoMedio;
	}

	public boolean isApprovazione() {
		return approvazione;
	}

	public void setApprovazione(boolean approvazione) {
		this.approvazione = approvazione;
	}

	public List<Foto> getFoto() {
		return foto;
	}

	public void setFoto(List<Foto> foto_id) {
		this.foto = foto_id;
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