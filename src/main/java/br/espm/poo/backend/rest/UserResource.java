package br.espm.poo.backend.rest;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Exceptions.RecordNotFoundException;
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
		UserBean foundUser = userService.findBy(id);
		if (foundUser == null) {
			throw new RecordNotFoundException(id.toString());
		}

		return userService.findBy(id);
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> create(@RequestBody UserBean user) {
		UserBean savedUser = userService.create(user);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId().toString()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{id}")
	public void deleteBy(@PathVariable UUID id) {
		userService.delete(id);
	}
}
