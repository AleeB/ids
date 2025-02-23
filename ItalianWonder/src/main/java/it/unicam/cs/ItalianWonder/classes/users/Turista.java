package it.unicam.cs.ItalianWonder.classes.users;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import it.unicam.cs.ItalianWonder.classes.Comune;
import it.unicam.cs.ItalianWonder.classes.Contest;
import it.unicam.cs.ItalianWonder.classes.Recensione;
import it.unicam.cs.ItalianWonder.classes.Segnalazione;
import it.unicam.cs.ItalianWonder.classes.enums.enumTipoUtente;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.EXISTING_PROPERTY,
		property = "tipoUser", visible = true)
@JsonSubTypes({
		@JsonSubTypes.Type(value = Turista.class, name = "Turista"),
		@JsonSubTypes.Type(value = TuristaAutorizzato.class, name = "TuristaAutorizzato"),
		@JsonSubTypes.Type(value = Contributor.class, name = "Contributor"),
		@JsonSubTypes.Type(value = ContributorAutorizzato.class, name = "ContributorAutorizzato"),
		@JsonSubTypes.Type(value = Animatore.class, name = "Animatore"),
		@JsonSubTypes.Type(value = Curatore.class, name = "Curatore"),
		@JsonSubTypes.Type(value = GestoreDellaPiattaforma.class, name = "GestoreDellaPiattaforma"),
})
public class Turista{

	//region Vars

	@Id

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

	//endregion

	//region Constr

	public Turista() {

	}

	public Turista(Map<String, Object> data){
		this.userName = (String) data.get("userName");
		this.nome = (String) data.get("nome");
		this.cognome = (String) data.get("cognome");
		this.password = (String) data.get("password");
		this.punteggio = (int) data.get("punteggio");
		this.tipoUser = (enumTipoUtente) data.get("tipoUser");
		this.contest = (List<Contest>) data.get("contest");
	}

	public Turista(Turista tur){
		this.userName = tur.getUserName();
		this.nome = tur.getNome();
		this.cognome = tur.getCognome();
		this.password = tur.getPassword();
		this.punteggio = tur.getPunteggio();
		this.tipoUser = tur.getTipoUser();
		this.contest = tur.getContest();
		this.segnalazioni = tur.getSegnalazioni();
		this.contest = tur.getContest();
		this.recensioni = tur.getRecensioni();
		this.comune = tur.getComune();
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

	public List<Segnalazione> getSegnalazioni() {
		return segnalazioni;
	}

	public void setSegnalazioni(List<Segnalazione> segnalazioni) {
		this.segnalazioni = segnalazioni;
	}

	public List<Recensione> getRecensioni() {
		return recensioni;
	}

	public void setRecensioni(List<Recensione> recensioni) {
		this.recensioni = recensioni;
	}

	public Comune getComune() {
		return comune;
	}

	public void setComune(Comune comune) {
		this.comune = comune;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Turista turista)) return false;
        return Objects.equals(userName, turista.userName) && Objects.equals(password, turista.password) && tipoUser == turista.tipoUser;
	}
	
}