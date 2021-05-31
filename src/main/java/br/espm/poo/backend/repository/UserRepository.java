package br.espm.poo.backend.repository;

import br.espm.poo.backend.models.UserModel;
import org.springframework.data.repository.CrudRepository;

public class UserRepository extends CrudRepository<UserModel, String>{
	
	UserModel save(UserModel user);
}
