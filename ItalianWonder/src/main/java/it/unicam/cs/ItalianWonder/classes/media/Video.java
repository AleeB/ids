package it.unicam.cs.ItalianWonder.classes.media;

import it.unicam.cs.ItalianWonder.classes.Contest;
import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.classes.POI.Ristorante;
import it.unicam.cs.ItalianWonder.classes.ConteggioVideo;
import it.unicam.cs.ItalianWonder.classes.users.Contributor;
import it.unicam.cs.ItalianWonder.classes.users.ContributorAutorizzato;
import it.unicam.cs.ItalianWonder.classes.users.TuristaAutorizzato;
import jakarta.persistence.*;

import java.io.File;

@Entity
@Table
public class Video {

	@Id

	@SequenceGenerator(
			name = "video_sequence",
			sequenceName = "video_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "video_sequence"
	)

	//region Vars

	private long ID;
	private String descrizione;
	private File video;
	private boolean approvazione;

	//endregion

	//region FKs

	@ManyToOne
	@JoinColumn(name = "itinerario_id")
	private Itinerario itinerario;

	@ManyToOne
	@JoinColumn(name = "divertimento_id")
	private Divertimento divertimento;

	@ManyToOne
	@JoinColumn(name = "ristorante_id")
	private Ristorante ristorante;

	@ManyToOne
	@JoinColumn(name = "turistaAutorizzato_id")
	private TuristaAutorizzato turistaAutorizzato;

	@ManyToOne
	@JoinColumn(name = "contributor_id")
	private Contributor contributor;

	@ManyToOne
	@JoinColumn(name = "contributorAutorizzato_id")
	private ContributorAutorizzato contributorAutorizzato;

	@ManyToOne
	@JoinColumn(name = "contest_id")
	private Contest contest;

	@OneToOne
	@JoinColumn(name = "avereV_id")
	private ConteggioVideo av;

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

	public File getVideo() {
		return video;
	}

	public void setVideo(File video) {
		this.video = video;
	}

	public boolean isApprovazione() {
		return approvazione;
	}

	public void setApprovazione(boolean approvazione) {
		this.approvazione = approvazione;
	}

	public Itinerario getItinerario() {
		return itinerario;
	}

	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}

	public Divertimento getDivertimento() {
		return divertimento;
	}

	public void setDivertimento(Divertimento divertimento) {
		this.divertimento = divertimento;
	}

	public Ristorante getRistorante() {
		return ristorante;
	}

	public void setRistorante(Ristorante ristorante) {
		this.ristorante = ristorante;
	}

	public TuristaAutorizzato getTuristaAutorizzato() {
		return turistaAutorizzato;
	}

	public void setTuristaAutorizzato(TuristaAutorizzato turistaAutorizzato) {
		this.turistaAutorizzato = turistaAutorizzato;
	}

	public Contributor getContributor() {
		return contributor;
	}

	public void setContributor(Contributor contributor) {
		this.contributor = contributor;
	}

	public Contest getContest() {
		return contest;
	}

	public void setContest(Contest contest) {
		this.contest = contest;
	}

	public ContributorAutorizzato getContributorAutorizzato() {
		return contributorAutorizzato;
	}

	public void setContributorAutorizzato(ContributorAutorizzato contributorAutorizzato) {
		this.contributorAutorizzato = contributorAutorizzato;
	}

	//endregion

	//region Constr

	public Video() {
	}

	//endregion

}