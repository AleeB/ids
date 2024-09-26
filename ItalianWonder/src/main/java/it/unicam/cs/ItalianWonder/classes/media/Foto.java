package it.unicam.cs.ItalianWonder.classes.media;

import it.unicam.cs.ItalianWonder.classes.Contest;
import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.classes.POI.Ristorante;
import it.unicam.cs.ItalianWonder.classes.avereF;
import it.unicam.cs.ItalianWonder.classes.users.Contributor;
import it.unicam.cs.ItalianWonder.classes.users.ContributorAutorizzato;
import it.unicam.cs.ItalianWonder.classes.users.TuristaAutorizzato;
import jakarta.persistence.*;

import java.io.File;

@Entity
@Table
public class Foto {

	@Id

	@SequenceGenerator(
			name = "foto_sequence",
			sequenceName = "foto_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "foto_sequence"
	)

	//region Vars

	private long ID;
	private String descrizione;
	private File foto;
	private boolean approvazione;

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
	@JoinColumn(name = "af_id")
	private avereF af;

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

	public File getFoto() {
		return foto;
	}

	public void setFoto(File foto) {
		this.foto = foto;
	}

	public boolean isApprovato() {
		return approvazione;
	}

	public void setApprovazione(boolean approvazione) {
		this.approvazione = approvazione;
	}

	public Ristorante getRistorante() {
		return ristorante;
	}

	public void setRistorante(Ristorante ristorante) {
		this.ristorante = ristorante;
	}

	public Divertimento getDivertimento() {
		return divertimento;
	}

	public void setDivertimento(Divertimento divertimento) {
		this.divertimento = divertimento;
	}

	public Itinerario getItinerario() {
		return itinerario;
	}

	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
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

	public ContributorAutorizzato getContributorAutorizzato() {
		return contributorAutorizzato;
	}

	public void setContributorAutorizzato(ContributorAutorizzato contributorAutorizzatico) {
		this.contributorAutorizzato = contributorAutorizzatico;
	}

	public Contest getContest() {
		return contest;
	}

	public void setContest(Contest contest) {
		this.contest = contest;
	}

	//endregion

	//region Constuctors

	public Foto() {
	}


	//endregion


}