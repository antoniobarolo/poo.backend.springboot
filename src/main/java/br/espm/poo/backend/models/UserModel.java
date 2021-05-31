package br.espm.poo.backend.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel {
	
	@Id
	private String idUsers;
	private String txName;
	
	
}
