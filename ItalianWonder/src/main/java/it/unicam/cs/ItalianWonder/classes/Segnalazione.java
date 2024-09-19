package it.unicam.cs.ItalianWonder.classes;

import it.unicam.cs.ItalianWonder.classes.enums.enumTipoSegnalazione;
import it.unicam.cs.ItalianWonder.classes.users.Contributor;
import it.unicam.cs.ItalianWonder.classes.users.ContributorAutorizzato;
import it.unicam.cs.ItalianWonder.classes.users.GestoreDellaPiattaforma;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Segnalazione {

	@Id

	@SequenceGenerator(
			name = "segnalazione_sequence",
			sequenceName = "segnalazione_sequence",
			allocationSize = 1

	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "segnalazione_sequence"
	)

	//region Vars

	private long ID;
	private enumTipoSegnalazione tipo;
	private boolean verificata;

	@ManyToMany(mappedBy = "segnalazioni")
	private List<Contributor> contributors;

	@ManyToMany(mappedBy = "segnalazioni")
	private List<ContributorAutorizzato> contributorAutorizzati;

	@ManyToOne
	@JoinColumn(name = "turista_id")
	private	Turista turista;

	@ManyToMany(mappedBy = "segnalazioni")
	private List<GestoreDellaPiattaforma> gestoriDellaPiattaforma;



	//endregion

	//region Props

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public enumTipoSegnalazione getTipo() {
		return tipo;
	}

	public void setTipo(enumTipoSegnalazione tipo) {
		this.tipo = tipo;
	}

	public boolean isVerificata() {
		return verificata;
	}

	public void setVerificata(boolean verificata) {
		this.verificata = verificata;
	}

	public List<Contributor> getContributors() {
		return contributors;
	}

	public void setContributors(List<Contributor> contributors) {
		this.contributors = contributors;
	}

	public List<ContributorAutorizzato> getContributorAutorizzati() {
		return contributorAutorizzati;
	}

	public void setContributorAutorizzati(List<ContributorAutorizzato> contributorAutorizzati) {
		this.contributorAutorizzati = contributorAutorizzati;
	}

	public Turista getTurista() {
		return turista;
	}

	public void setTurista(Turista turista) {
		this.turista = turista;
	}

	//endregion

	//region Constr

	public Segnalazione() {

	}

	//endregion

	//region Methods

	public boolean verifica() {
		// TODO - implement Segnalazione.verifica
		throw new UnsupportedOperationException();
	}

	//endregion

}