package classes;

import classes.POI.Divertimento;
import classes.POI.Itinerario;
import classes.POI.Ristorante;
import classes.enums.enumValutazione;
import classes.users.Turista;
import classes.users.UserNonAutenticato;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Recensione {

	@Id

	@SequenceGenerator(
			name = "recensione_sequence",
			sequenceName = "recensione_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "recensione_sequence"
	)

	//region Vars

	private long ID;
	private String descrizione;
	private int valutazione;	//da 1 a 5
	private boolean verificata;

	@ManyToOne
	@JoinColumn(name = "divertimento_id")
	private Divertimento divertimento;

	@ManyToOne
	@JoinColumn(name = "itinerario_id")
	private Itinerario itinerario;

	@ManyToOne
	@JoinColumn(name = "ristorante_id")
	private Ristorante ristorante;

	@ManyToOne
	@JoinColumn(name = "turista_id")
	private Turista turista;

	@ManyToMany(mappedBy = "recensioni")
	private List<UserNonAutenticato> una;



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

	public int getValutazione() {
		return valutazione;
	}

	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}

	public boolean isVerificata() {
		return verificata;
	}

	public void setVerificata(boolean verificata) {
		this.verificata = verificata;
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

	public Ristorante getRistorante() {
		return ristorante;
	}

	public void setRistorante(Ristorante ristorante) {
		this.ristorante = ristorante;
	}

	public Turista getTurista() {
		return turista;
	}

	public void setTurista(Turista turista) {
		this.turista = turista;
	}

	//endregion

	//region Constr

	public Recensione() {

	}

	//endregion

	//region Methods

	public void verifica() {
		// TODO - implement Recensione.verifica
		throw new UnsupportedOperationException();
	}

	//endregion

}