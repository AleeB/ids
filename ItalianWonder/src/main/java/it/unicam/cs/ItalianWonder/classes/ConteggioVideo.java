package it.unicam.cs.ItalianWonder.classes;

import it.unicam.cs.ItalianWonder.classes.media.Video;
import jakarta.persistence.*;

//design pattern mediator
@Entity
@Table
public class ConteggioVideo {

	@Id

	@SequenceGenerator(
			name = "conteggioVideo_sequence",
			sequenceName = "conteggioVideo_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			generator = "conteggioVideo_sequence",
			strategy = GenerationType.SEQUENCE
	)

	//region Vars

	private long numeroVoti;

	@OneToOne(mappedBy = "av")
	private Video video;

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

	public ConteggioVideo(){
		this.numeroVoti = 0;
	}

	//endregion

}