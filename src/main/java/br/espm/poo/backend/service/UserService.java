package br.espm.poo.backend.service;

import br.espm.poo.backend.datatype.UserBean;
import org.springframework.stereotype.Component;

import com.sun.javafx.collections.MappingChange.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Component
public class UserService {

	private static HashMap<UUID, UserBean> users =  new HashMap<UUID, UserBean>();
		static {
		UserBean u1 = new UserBean(UUID.randomUUID(),"antonio");
		UserBean u2 = new UserBean(UUID.randomUUID(),"julia");
		UserBean u3 = new UserBean(UUID.randomUUID(),"surubatur");
		users.put(u1.getId(), u1);
		users.put(u2.getId(), u2);
		users.put(u3.getId(), u3);
		};

	public List<UserBean> listAll() {
		return new ArrayList<>(users.values());
	}
	
	public UserBean findBy(UUID id) {
		return users.get(id);
	}
	
	public UserBean create(UserBean user) {
		if (user.getId() == null) {
			user.setId(UUID.randomUUID());
		}
		users.put(user.getId(), user);
		return user;
	}
	
	public void delete(UUID id) {
		users.remove(id);
	}
}
