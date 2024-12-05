package it.unicam.cs.ItalianWonder.classes;

import it.unicam.cs.ItalianWonder.classes.media.Foto;
import jakarta.persistence.*;

//design pattern mediator
@Entity
@Table
public class ConteggioFoto {

	@Id

	@SequenceGenerator(
			name = "conteggioFoto_sequence",
			sequenceName = "conteggioFoto_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			generator = "conteggioFoto_sequence",
			strategy = GenerationType.SEQUENCE
	)

	//region Vars

	private long numeroVoti;

	@OneToOne(mappedBy = "cf")
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

	public ConteggioFoto(){
	}

	//endregion

}