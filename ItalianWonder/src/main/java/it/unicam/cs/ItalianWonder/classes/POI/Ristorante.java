package it.unicam.cs.ItalianWonder.classes.POI;

import it.unicam.cs.ItalianWonder.classes.Localizzazione;
import it.unicam.cs.ItalianWonder.classes.Recensione;
import it.unicam.cs.ItalianWonder.classes.Salvare;
import it.unicam.cs.ItalianWonder.classes.media.Foto;
import it.unicam.cs.ItalianWonder.classes.media.Video;
import it.unicam.cs.ItalianWonder.classes.users.Contributor;
import it.unicam.cs.ItalianWonder.classes.users.ContributorAutorizzato;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import it.unicam.cs.ItalianWonder.classes.users.UserNonAutenticato;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Ristorante {

	@Id

	@SequenceGenerator(
			name = "ristorante_sequence",
			sequenceName = "ristorante_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "ristorante_sequence"
	)

	//region Vars

	private long ID;
	private String nome;
	private String numeroTelefono;
	private int valutazione;		//inserito quando viene caricato il ristorante (no media)
	private float costoMedio;
	private boolean approvazione;

	@OneToMany(mappedBy = "ristorante")
	private List<Foto> foto;

	@OneToMany(mappedBy = "ristorante")
	private List<Video> video;

	@OneToMany(mappedBy = "ristorante")
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

	//endregion

	//region Constr

	public Ristorante() {
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