package classes.users;

import classes.Recensione;
import classes.Segnalazione;
import classes.enums.enumTipoUtente;

public class Turista extends UserNonAutenticato {

	private String nome;
	private String cognome;
	private String userName;
	private String password;
	private int punteggio;
	private enumTipoUtente tipoUser;

	

	public Turista() {
		this.nome = "";
		this.cognome = "";
		this.userName = "";
		this.password = "";
		this.punteggio = 0;
		tipoUser = enumTipoUtente.Turista;
	}

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

	
}