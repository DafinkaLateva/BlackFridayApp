package org.didi.BlackFridayApp.service;

import java.util.Collection;

import org.apache.commons.codec.digest.DigestUtils;
import org.didi.BlackFridayApp.db.entity.User;
import org.didi.BlackFridayApp.db.finder.UserFinder;
import org.didi.BlackFridayApp.model.EditUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserFinder userFinder;

	public User signUp(User user) {
		// TODO Validate ex. the user already exists.
		user.setPassword(DigestUtils.sha256Hex(user.getPassword()));

		return userFinder.saveAndFlush(user);
	}

	public User signIn(User user) {
		User userFromDb = userFinder.findByUsername(user.getUsername());

		if (userFromDb == null || !userFromDb.getPassword().equals(DigestUtils.sha256Hex(user.getPassword()))) {
			return null;
		}

		return userFromDb;
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

	public User updateUser(Integer id, EditUserModel userModel) {
		User updatedUser = getUserById(id);
		updatedUser.setUsername(userModel.getUsername());
		updatedUser.setPassword(userModel.getPassword());
		updatedUser.setEmail(userModel.getEmail());
		updatedUser.setPhoneNumber(userModel.getPhoneNumber());
		updatedUser.setAddress(userModel.getAddress());
		updatedUser.setRole(userModel.getRole());
		updatedUser.updateFields(updatedUser);
		return userFinder.save(updatedUser);
	}

}
