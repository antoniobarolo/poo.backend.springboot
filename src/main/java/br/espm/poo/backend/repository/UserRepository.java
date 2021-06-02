package br.espm.poo.backend.repository;

import org.springframework.data.repository.CrudRepository;

import br.espm.poo.backend.models.UserModel;

public class UserRepository extends CrudRepository<UserModel, String>{
	
	UserModel save(UserModel user){};
}
