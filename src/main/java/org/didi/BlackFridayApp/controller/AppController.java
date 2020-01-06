/*
 * package org.didi.BlackFridayApp.controller;
 *
 * import java.util.Scanner;
 *
 * import org.didi.BlackFridayApp.service.UserService; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.CommandLineRunner; import
 * org.springframework.stereotype.Controller;
 *
 * @Controller public class AppController implements CommandLineRunner {
 *
 * @Autowired private UserService userService; private Scanner scanner = new
 * Scanner(System.in);
 *
 * @Override public void run(String... args) throws Exception {
 *
 * System.out.println("1.Sign up"); System.out.println("2.Sign in"); String
 * command = this.scanner.nextLine(); switch (command) { case "1":
 * this.signUp(); break; default: throw new
 * IllegalArgumentException("Invalid input");
 *
 * } }
 *
 * private void signUp() { System.out.print("Username:"); String username =
 * this.scanner.nextLine(); System.out.print("Password:"); String password =
 * this.scanner.nextLine(); System.out.print("pHONE NUMBER:"); String
 * phoneNumber = this.scanner.nextLine(); userService.signUp(username, password,
 * phoneNumber); } }
 */