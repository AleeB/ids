package classes;

public class Turista extends UserNonAutenticato {

	private String nome;
	private String Cognome;
	private String ID_UserName;
	/**
	 * la password sarà salvata nel db dopo aver eseguito l'hash
	 */
	private String Password;
	private int punteggio;
	private enumTipoUtente tipoUser;

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