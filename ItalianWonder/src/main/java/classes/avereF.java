package classes;

import java.util.*;

//design pattern mediator
public class avereF {

	//region Vars

	private long numeroVoti;
	private long idFoto;

	//endregion

	//region Props

	public long getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(long idFoto) {
		this.idFoto = idFoto;
	}

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

	public avereF(long numeroVoti, long idFoto) {
		this.numeroVoti = numeroVoti;
		this.idFoto = idFoto;
	}

	public avereF(){
		this.numeroVoti = 0;
		this.idFoto = 0;
	}

	//endregion

}