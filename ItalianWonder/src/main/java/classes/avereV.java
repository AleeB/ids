package classes;

import classes.media.Video;
import jakarta.persistence.*;

//design pattern mediator
@Entity
@Table
public class avereV {

	@Id

	@SequenceGenerator(
			name = "averev_sequence",
			sequenceName = "averev_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			generator = "averev_sequence",
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

	public avereV(){
		this.numeroVoti = 0;
	}

	//endregion

}