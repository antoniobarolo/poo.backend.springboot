package br.espm.poo.backend.models;

import javax.persistence.Table;

import nonapi.io.github.classgraph.json.Id;

@Entity
@Table(name = "users")
public class UserModel {
	
	@Id
	private String idUsers;
	private String txName;
	
	
}
