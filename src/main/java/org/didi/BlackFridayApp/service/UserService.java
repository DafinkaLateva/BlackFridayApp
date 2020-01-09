package org.didi.BlackFridayApp.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.didi.BlackFridayApp.db.entity.User;
import org.didi.BlackFridayApp.db.finder.UserFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {
	@Autowired
	private UserFinder userFinder;

	public User signUp(User user) {
		// TODO Validate ex. the user already exists.

		return userFinder.saveAndFlush(user);
	}

	public Collection<User> list() {
		return userFinder.findAll();
	}

	public User get(String username, String pass) {

		User user = new User();
		user.setUsername(username);
		user.setPassword(pass);

		return userFinder.findOne(Example.of(user)).orElseGet(() -> null);
	}

	public void deleteById(Integer id) {

		userFinder.deleteById(id);

	}

	public User getUserById(Integer id) {
		User user = new User();
		user.setId(id);
		return userFinder.findOne(Example.of(user)).orElseGet(() -> null);
	}

	public List<User> update(Iterable<Integer> id, @RequestBody Map<String, String> body) {
		// TODO Auto-generated method stub
		List<User> user = userFinder.findAllById(id);
		((User) user).setUsername(body.get("username"));
		((User) user).setPassword(body.get("password"));
		return userFinder.saveAll(user);
	}

}
