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

	public Animatore(Turista tur){
		super(tur);
	}

	public List<Contest> getContest() {
		return contest;
	}

	public void setContest(List<Contest> contest) {
		this.contest = contest;
	}


}