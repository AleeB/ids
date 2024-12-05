package it.unicam.cs.ItalianWonder.classes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.classes.POI.PuntoRistoro;
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

	@OneToOne(mappedBy = "localizzazione", fetch = FetchType.LAZY)
	@JsonBackReference(value = "jdivertimento")
	private Divertimento divertimento;

	@ManyToMany(mappedBy = "localizzazioni")
	@JsonBackReference(value = "jitinerari")
	private List<Itinerario> itinerari;

	@OneToOne(mappedBy = "localizzazione")
	@JsonBackReference(value = "jPuntoRistoro")
	private PuntoRistoro puntoRistoro;

	@OneToOne(mappedBy = "localizzazione")
	@JsonBackReference(value = "jcomune")
	private Comune comune;

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

	public PuntoRistoro getPuntoRistoro() {
		return puntoRistoro;
	}

	public void setPuntoRistoro(PuntoRistoro puntoRistoro) {
		this.puntoRistoro = puntoRistoro;
	}

	public List<Itinerario> getItinerari() {
		return itinerari;
	}

	public void setItinerari(List<Itinerario> itinerari) {
		this.itinerari = itinerari;
	}

	public Comune getComune() {
		return comune;
	}

	public void setComune(Comune comuni) {
		this.comune = comuni;
	}

	//endregion

}