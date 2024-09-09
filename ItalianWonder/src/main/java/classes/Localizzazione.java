package classes;

import jakarta.persistence.*;

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

	//endregion

	//region Constr

	public Localizzazione() {
		this.ID = Integer.MAX_VALUE;
		this.lat = "";
		this.lon = "";
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

	//endregion

	//region Methods



	//endregion

}