package classes.users;

import classes.Comune;
import classes.Contest;
import classes.POI.Divertimento;
import classes.POI.Itinerario;
import classes.POI.Ristorante;
import classes.Recensione;
import classes.Segnalazione;
import classes.enums.enumTipoUtente;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Turista{

	//region Vars

	@Id

	@SequenceGenerator(
			name = "turista_sequence",
			sequenceName = "turista_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			generator = "turista_sequence",
			strategy = GenerationType.SEQUENCE
	)

	private String userName;
	private String nome;
	private String cognome;
	private String password;
	private int punteggio;
	private enumTipoUtente tipoUser;


	@ManyToMany
	@JoinTable(
			name = "turista_contest",
			joinColumns = @JoinColumn(name = "turista_id"),
			inverseJoinColumns = @JoinColumn(name = "contest_id")
	)
	private List<Contest> contest;

	@ManyToMany
	@JoinTable(
			name = "turista_segnalazione",
			joinColumns = @JoinColumn(name = "turista_id"),
			inverseJoinColumns = @JoinColumn(name = "segnalazione_id")
	)
	private List<Segnalazione> segnalazioni;

	@OneToMany(mappedBy = "turista")
	private List<Recensione> recensioni;

	@OneToOne
	@JoinColumn(name = "comune_id")
	private Comune comune;

	@ManyToMany(mappedBy = "turisti")
	private List<Divertimento> divertimenti;

	@ManyToMany(mappedBy = "turisti")
	private List<Itinerario> itinerario;

	@ManyToMany(mappedBy = "turisti")
	private List<Ristorante> ristoranti;

	//endregion

	//region Constr

	public Turista() {

	}

	//endregion


	//region Prop

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUserName() {
		return userName;
	}

	public void setID_UserName(String ID_UserName) {
		this.userName = ID_UserName;
	}

	/**
	 * la password sarà salvata nel db dopo averne eseguito l'hash
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}

	public enumTipoUtente getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(enumTipoUtente tipoUser) {
		this.tipoUser = tipoUser;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Contest> getContest() {
		return contest;
	}

	public void setContest(List<Contest> contest) {
		this.contest = contest;
	}



	//endregion



	//region Methods

	//hashcode password per crittografia
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	/**
	 * 
	 * @param infoSegnalazione
	 */
	public boolean inviareSegnalazione(Segnalazione infoSegnalazione) {
		// TODO - implement Turista.inviareSegnalazione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param infoRecensione
	 */
	public boolean scrivereRecensioni(Recensione infoRecensione) {
		// TODO - implement Turista.scrivereRecensioni
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idRecensione
	 * @param nuovaRecensione
	 */
	public boolean modificareRecensionePropria(long idRecensione, Recensione nuovaRecensione) {
		// TODO - implement Turista.modificareRecensionePropria
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idRecensione
	 */
	public boolean eliminareRecensioniProprie(long idRecensione) {
		// TODO - implement Turista.eliminareRecensioniProprie
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idContest
	 * @param idMateriale
	 * @param tipoMateriale 1 foto
	 * 0 video
	 *  
	 */
	public boolean votazioneContest(long idContest, long idMateriale, boolean tipoMateriale) {
		// TODO - implement Turista.votazioneContest
		throw new UnsupportedOperationException();
	}

	public void turista() {
		// TODO - implement Turista.turista
		throw new UnsupportedOperationException();
	}

	public Object cambiaTipoOggetto() {
		// TODO - implement Turista.cambiaTipoOggetto
		throw new UnsupportedOperationException();
	}

	//endregion
	
}