package org.didi.BlackFridayApp.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.didi.BlackFridayApp.GenericResponse;
import org.didi.BlackFridayApp.db.entity.User;
import org.didi.BlackFridayApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user/list")
	public Collection<User> list() {

		return userService.list();
	}

	@PostMapping("/user/register")
	public ResponseEntity<?> register(User user, HttpSession session) {
		User registeredUser = userService.signUp(user);

		if (registeredUser == null) {
			return ResponseEntity.status(400).body(new GenericResponse<>("Failde"));
		}

		return ResponseEntity.ok(registeredUser);
	}

	@PostMapping("/user/login")
	public ResponseEntity<?> login(User user, HttpSession session) {
		User userFromDb = userService.signIn(user);

		if (userFromDb == null) {
			return ResponseEntity.status(401).body(new GenericResponse<>("The username or password is not correct"));
		}

		session.setAttribute("userId", userFromDb.getId());
		session.setAttribute("username", userFromDb.getUsername());
		session.setAttribute("userRole", userFromDb.getRole());

		return ResponseEntity.ok(userFromDb);
	}

	@DeleteMapping("/user/remove/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return ResponseEntity.status(401).body("unauth");
		} else if (!session.getAttribute("userRole").equals("employee")) {
			return ResponseEntity.status(403).body("forbidden");
		}

		userService.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/user/getUserById/{id}")
	public User getUserById(@PathVariable Integer id) {

		User user = userService.getUserById(id);
		return user;
	}

	@PostMapping("/user/logout")
	public boolean logout(HttpSession session) {

		session.invalidate();

		return true;
	}

}