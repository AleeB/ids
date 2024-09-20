package it.unicam.cs.ItalianWonder.classes;

import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.classes.POI.Ristorante;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Localizzazione {

	@Id

	@SequenceGenerator(
			name = "localizzazione_sequence",
			sequenceName = "localizzazione_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "localizzazione_sequence"
	)

	//region Vars

	private long ID;
	private String lat;
	private String lon;

	@OneToOne(mappedBy = "localizzazione")
	private Divertimento divertimento;

	@ManyToMany(mappedBy = "localizzazioni")
	private List<Itinerario> itinerari;

	@OneToOne(mappedBy = "localizzazione")
	private Ristorante ristorante;

	@OneToMany(mappedBy = "localizzazione")
	private List<Comune> comuni;

	//endregion

	//region Constr

	public Localizzazione() {
	}

	public Localizzazione(long ID, String lon, String lat) {
		this.ID = ID;
		this.lon = lon;
		this.lat = lat;
	}

	//endregion

	//region Prop

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
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

	public List<Itinerario> getItinerari() {
		return itinerari;
	}

	public void setItinerari(List<Itinerario> itinerari) {
		this.itinerari = itinerari;
	}

	public List<Comune> getComuni() {
		return comuni;
	}

	public void setComuni(List<Comune> comuni) {
		this.comuni = comuni;
	}

	//endregion

	//region Methods



	//endregion

}