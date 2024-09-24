package it.unicam.cs.ItalianWonder.classes.users;

import it.unicam.cs.ItalianWonder.classes.Segnalazione;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Curatore extends ContributorAutorizzato {

	//region Vars

	@ManyToMany
	@JoinTable(
			name = "curatore_segnalazione",
			joinColumns = @JoinColumn(name = "curatore_id"),
			inverseJoinColumns = @JoinColumn(name = "segnalazione_id")
	)
	private List<Segnalazione> segnalazioni;

	//endregion

	//region Props

	@Override
	public List<Segnalazione> getSegnalazioni() {
		return segnalazioni;
	}

	@Override
	public void setSegnalazioni(List<Segnalazione> segnalazioni) {
		this.segnalazioni = segnalazioni;
	}


	//endregion

	public Curatore() {
		super();
	}

	public Curatore(Turista tur) {
		super(tur);
	}


}