package it.unicam.cs.ItalianWonder.classes;

import it.unicam.cs.ItalianWonder.classes.media.Foto;
import jakarta.persistence.*;

//design pattern mediator
@Entity
@Table
public class avereF {

	@Id

	@SequenceGenerator(
			name = "averef_sequence",
			sequenceName = "averef_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			generator = "averef_sequence",
			strategy = GenerationType.SEQUENCE
	)

	//region Vars

	private long numeroVoti;

	@OneToOne(mappedBy = "af")
	private Foto foto;

	//endregion

	//region Props

	public long getNumeroVoti() {
		return numeroVoti;
	}

	public void setNumeroVoti(long numeroVoti) {
		this.numeroVoti = numeroVoti;
	}

	public void addNumeroVoti() {
		this.numeroVoti++;
	}

	//endregion

	//region Constr

	public avereF(){
	}

	//endregion

}