package classes;

import jakarta.persistence.*;

import java.util.*;

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
		this.numeroVoti = 0;
	}

	//endregion

}