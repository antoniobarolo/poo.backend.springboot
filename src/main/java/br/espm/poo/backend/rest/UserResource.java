package br.espm.poo.backend.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.espm.poo.backend.datatype.UserBean;
import br.espm.poo.backend.service.UserService;

@RestController
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping(path = "/users")
	public List<UserBean> listAll() {
		return userService.listAll();
	}

	@GetMapping(path = "/users/{id}")
	public UserBean findBy(@PathVariable UUID id) {
		return userService.findBy(id);
	}

	@PostMapping(path = "/users")
	public void create(@RequestBody UserBean user) {
		userService.create(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteBy(@PathVariable UUID id) {
		userService.delete(id);
	}
}
