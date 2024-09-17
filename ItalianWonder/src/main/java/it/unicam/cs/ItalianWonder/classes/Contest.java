package it.unicam.cs.ItalianWonder.classes;
import it.unicam.cs.ItalianWonder.classes.media.Foto;
import it.unicam.cs.ItalianWonder.classes.media.Video;
import it.unicam.cs.ItalianWonder.classes.users.Animatore;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table
public class Contest {

	@Id

	@SequenceGenerator(
			name = "contest_sequence",
			sequenceName = "contest_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			generator = "contest_sequence",
			strategy = GenerationType.SEQUENCE
	)

	//region Vars

	private long Id;
	private LocalDateTime dataInizio;
	private LocalDateTime dataFine;
	private String titolo;

	@OneToMany(mappedBy = "contest")
	private List<Foto> foto;

	@OneToMany(mappedBy = "contest")
	private List<Video> video;

	@ManyToOne
	@JoinColumn(name = "animatore_id")
	private Animatore animatore;

	@ManyToMany(mappedBy = "contest")
	private List<Turista> turisti;

	//endregion

	//region Props

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		this.Id = id;
	}

	public LocalDateTime getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDateTime getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Foto> getFoto() {
		return foto;
	}

	public void setFoto(List<Foto> foto) {
		this.foto = foto;
	}

	public List<Video> getVideo() {
		return video;
	}

	public void setVideo(List<Video> video) {
		this.video = video;
	}

	public Animatore getAnimatore() {
		return animatore;
	}

	public void setAnimatore(Animatore animatore) {
		this.animatore = animatore;
	}

	//endregion

	//region Constr



	//endregion

	//region Methods

	/**
	 * 
	 * @param idContest
	 */
	public List<Foto> mostraFotoContest(long idContest) {
		// TODO - implement Contest.mostraFotoContest
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idContest
	 */
	public List<Foto> creaClassificaContest(long idContest) {
		// TODO - implement Contest.creaClassificaContest
		throw new UnsupportedOperationException();
	}

	/**
	 * imposta la data di chiusura a datetime.now
	 */
	public boolean chiudiContest() {
		// TODO - implement Contest.chiudiContest
		throw new UnsupportedOperationException();
	}

	//endregion

}