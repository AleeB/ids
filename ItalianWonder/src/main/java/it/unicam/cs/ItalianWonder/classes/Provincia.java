package it.unicam.cs.ItalianWonder.classes;

import jakarta.persistence.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * le province verranno caricate in modo statico, si potranno aggiornare tramite metodi
 */
@Entity
@Table
public class Provincia {


	@Id

	@SequenceGenerator(
			name = "provincia_sequence",
			sequenceName = "provincia_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			generator = "provincia_sequence",
			strategy = GenerationType.SEQUENCE
	)

	//region Vars

	private String nomeProvincia;
	private String sigla;

	@OneToMany(mappedBy = "provincia")
	private List<Comune> comuni;

	//endregion

	//region Constructors

	public Provincia(String nomeProvincia, String sigla) {
		this.nomeProvincia = nomeProvincia;
		this.sigla = sigla;
	}

	public Provincia() {
		this.nomeProvincia = "";
		this.sigla = "";
	}
	
	//endregion

	//region Properties

	public String getNomeProvincia() {
		return nomeProvincia;
	}

	public void setNomeProvincia(String nomeProvincia) {
		this.nomeProvincia = nomeProvincia;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	//endregion

}