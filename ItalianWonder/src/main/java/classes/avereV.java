package classes;

//design pattern mediator
public class avereV {

	//region Vars

	private long numeroVoti;
	private long idVideo;

	//endregion

	//region Props

	public long getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(long idVideo) {
		this.idVideo = idVideo;
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

	public avereV(long numeroVoti, long idFoto) {
		this.numeroVoti = numeroVoti;
		this.idVideo = idFoto;
	}

	public avereV(){
		this.numeroVoti = 0;
		this.idVideo = 0;
	}

	//endregion

}