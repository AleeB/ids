package classes.users;

import classes.Recensione;
import classes.Segnalazione;
import classes.enums.enumTipoUtente;
import jakarta.persistence.*;
/*
@Entity
@Table */
public class Turista extends UserNonAutenticato {

	/*

	@Id

	@SequenceGenerator(
			name = "turista_sequence",
			sequenceName = "turista_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "turista_sequence"
	)
*/
	//region Vars

	private String userName;
	private String nome;
	private String cognome;
	private String password;
	private int punteggio;
	private enumTipoUtente tipoUser;

	//endregion

	//region Constr

	public Turista(String nome, String cognome, String userName, String password, int punteggio, enumTipoUtente tipoUser) {
		this.nome = nome;
		this.cognome = cognome;
		this.userName = userName;
		this.password = password;
		this.punteggio = punteggio;
		this.tipoUser = tipoUser;
	}

	public Turista() {
		this.nome = "";
		this.cognome = "";
		this.userName = "";
		this.password = "";
		this.punteggio = 0;
		tipoUser = enumTipoUtente.Turista;
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