package org.didi.BlackFridayApp.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService users;

	@GetMapping("/user/list")
	public Collection<User> list(HttpSession session) {
		Object userId = session.getAttribute("user");
		if (userId == null) {
			throw new RuntimeException("Not authenticated");
		}

		return users.list();
	}

	@PostMapping("/user/register")
	public User register(User user, HttpSession session) {
		return users.signUp(user);
	}

	@DeleteMapping("/user/remove/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {

		users.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/user/getUserById/{id}")
	public User getUserById(@PathVariable Integer id) {

		User user = users.getUserById(id);
		return user;
	}

	@PostMapping("/user/login")
	public User login(String username, String pass, HttpSession session) {
		User user = users.get(username, pass);

		if (user == null) {
			throw new RuntimeException("The username or password is not correct");

			// TODO throw not registered
		}

		session.setAttribute("user", user.getId());

		return user;
	}

	/**
	 *
	 * @param username
	 * @param pass
	 * @param email
	 * @param phonenumber
	 * @param address
	 * @param role
	 * @param session
	 * @return
	 */
	@PostMapping("/user/betterLogin")
	@ResponseBody
	public ResponseEntity<?> betterLogin(String username, String pass, HttpSession session) {
		User user = users.get(username, pass);

		if (user == null) {
			return ResponseEntity.status(401).body(new GenericResponse<>("The username or password is not correct"));
		}

		session.setAttribute("user", user.getId());

		return ResponseEntity.ok(user);
	}

	@PostMapping("/user/logout")
	public boolean logout(HttpSession session) {

		session.removeAttribute("user");

		return true;
	}

//TODO:
	@PutMapping("/user/update/{id}")
	public List<User> update(@PathVariable Iterable<Integer> id, @RequestBody Map<String, String> body) {

		return users.update(id, body);

	}
}