package it.unicam.cs.ItalianWonder.classes.users;

import it.unicam.cs.ItalianWonder.classes.Segnalazione;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class GestoreDellaPiattaforma extends Curatore {

	//region Vars

	@ManyToMany
	@JoinTable(
			name = "gestoreDellaPiattaforma_segnalazione",
			joinColumns = @JoinColumn(name = "gestoreDellaPiattaforma_id"),
			inverseJoinColumns = @JoinColumn(name = "segnalazione_id")
	)
	private List<Segnalazione> segnalazioni;

	//endregion

	//region Props



	//endregion

	public GestoreDellaPiattaforma() {
		super();
	}

	public GestoreDellaPiattaforma(Turista tur) {
		super(tur);
	}


}