package it.unicam.cs.ItalianWonder.classes.users;

import it.unicam.cs.ItalianWonder.classes.Contest;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Animatore extends ContributorAutorizzato {

	@OneToMany(mappedBy = "animatore")
	private List<Contest> contest;

	public Animatore() {
		super();
	}

	public List<Contest> getContest() {
		return contest;
	}

	public void setContest(List<Contest> contest) {
		this.contest = contest;
	}

	//region Methods

	public void assegnazioniPunteggiContest() {
		// TODO - implement Animatore.assegnazioniPunteggiContest
		throw new UnsupportedOperationException();
	}

	public void animatore() {
		// TODO - implement Animatore.animatore
		throw new UnsupportedOperationException();
	}

	//endregion

}