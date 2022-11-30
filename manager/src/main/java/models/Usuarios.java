package models;
// Generated 30 nov 2022 23:00:38 by Hibernate Tools 5.5.9.Final

import lombok.Data;

@Data
public class Usuarios implements java.io.Serializable {

	private Integer id;
	private String user;
	private String password;

	public Usuarios() {
	}

	public Usuarios(String user, String password) {
		this.user = user;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuarios{" +
				"user='" + user + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
