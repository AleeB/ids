package it.unicam.cs.ItalianWonder.classes;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import jakarta.persistence.*;

@Entity
@Table
public class Comune {

	@Id
	//region Vars

	private String nome;
	private String cap;

	@OneToOne(mappedBy = "comune")
	private Turista turista;

	@ManyToOne
	@JoinColumn(name = "provincia_id")
	private Provincia provincia;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "ID")
	@JsonManagedReference
	private Localizzazione localizzazione;

	//endregion

	//region Props

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	//endregion

	//region Constr

	public Comune(String nome, Localizzazione localizazione) {
		this.nome = nome;
	}

	public Comune() {
		this.nome = "";
	}

	//endregion

	//region Methods

	public Comune mostraComuni() {
		// TODO - implement Comune.mostraComuni
		throw new UnsupportedOperationException();
	}

	//endregion

}