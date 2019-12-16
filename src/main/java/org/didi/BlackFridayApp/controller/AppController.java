package org.didi.BlackFridayApp.controller;

import org.didi.BlackFridayApp.db.entity.User;
import org.didi.BlackFridayApp.db.finder.ProductFinder;
import org.didi.BlackFridayApp.db.finder.UserFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class AppController implements CommandLineRunner {
	@Autowired
	private ProductFinder productFinder;
	@Autowired
	private UserFinder userFinder;

	@Override
	public void run(String... args) throws Exception {
		User user = userFinder.findById(4).orElse(null);
		user.setUsername("didi");
		userFinder.saveAndFlush(user);

	}

}
