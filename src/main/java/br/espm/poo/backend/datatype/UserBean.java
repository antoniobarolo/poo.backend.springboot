package br.espm.poo.backend.datatype;

import java.util.UUID;

public class UserBean {

	private UUID id;
	private String name;
	
	public UserBean(){
		
	}
	public UserBean(UUID id, String name){
		this.id = id;
		this.name = name;
	}
	
	
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public UUID getId(){
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
}
