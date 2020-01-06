package org.didi.BlackFridayApp.service;

import java.util.Collection;

import javax.validation.Valid;

import org.didi.BlackFridayApp.db.entity.User;
import org.didi.BlackFridayApp.db.finder.UserFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

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

	public User getById(Integer id) {
		User user = new User();
		return userFinder.findOne(Example.of(user)).orElseGet(() -> null);
	}

	public void update(@Valid User userForm) {
		// TODO Auto-generated method stub

	}

}
