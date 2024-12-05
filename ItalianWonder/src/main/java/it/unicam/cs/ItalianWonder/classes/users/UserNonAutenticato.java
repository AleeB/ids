package it.unicam.cs.ItalianWonder.classes.users;

import jakarta.persistence.*;

@Entity
@Table
public class UserNonAutenticato {

	@Id

	@SequenceGenerator(
			name = "usernonautenticato_sequence",
			sequenceName = "usernonautenticato_sequence",
			allocationSize = 1
	)

	@GeneratedValue(
			strategy = GenerationType.IDENTITY,
			generator = "usernonautenticato_sequence"
	)

	//region Vars

	private Long id;
	private final String ip;

	//endregion

	//region Props

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	//endregion

	public UserNonAutenticato() {
		this.ip = "";
	}

	public UserNonAutenticato(String ip) {
		this.ip = ip;
	}

}