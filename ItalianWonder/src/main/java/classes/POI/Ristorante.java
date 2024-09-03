package classes.POI;

import classes.enums.enumValutazione;
import jakarta.persistence.*;

@Entity
@Table
public class Ristorante {

	@Id

	@SequenceGenerator(
			name = "ristorante_sequence",
			sequenceName = "ristorante_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "ristorante_sequence"
	)

	//region Vars

	private long ID;
	private String nome;
	private String numeroTelefono;
	private int valutazione;		//inserito quando viene caricato il ristorante (no media)
	private float costoMedio;
	private boolean approvazione;

	//endregion

	//region Constr

	public Ristorante(long ID, String nome, String numeroTelefono, int valutazione, float costoMedio, boolean approvazione) {
		this.ID = ID;
		this.nome = nome;
		this.numeroTelefono = numeroTelefono;
		this.valutazione = valutazione;
		this.costoMedio = costoMedio;
		this.approvazione = approvazione;
	}

	public Ristorante(){
		this.nome = "";
		this.numeroTelefono = "";
		this.valutazione = 0;
		this.costoMedio = 0;
		this.approvazione = false;
	}

	//endregion

	//region Props

	public long getID() {
		return ID;
	}

	public void setID(long ID) {
		this.ID = ID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public int getValutazione() {
		return valutazione;
	}

	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}

	public float getCostoMedio() {
		return costoMedio;
	}

	public void setCostoMedio(float costoMedio) {
		this.costoMedio = costoMedio;
	}

	public boolean isApprovazione() {
		return approvazione;
	}

	public void setApprovazione(boolean approvazione) {
		this.approvazione = approvazione;
	}

	//endregion

	//region Methods

	public void ristorante() {
		// TODO - implement Ristorante.ristorante
		throw new UnsupportedOperationException();
	}

	public boolean approvazione() {
		// TODO - implement Ristorante.approvazione
		throw new UnsupportedOperationException();
	}

	public boolean modificaNumeroTelefono() {
		// TODO - implement Ristorante.modificaNumeroTelefono
		throw new UnsupportedOperationException();
	}

	public boolean modificaCostoMedio() {
		// TODO - implement Ristorante.modificaCostoMedio
		throw new UnsupportedOperationException();
	}

	//endregion

}