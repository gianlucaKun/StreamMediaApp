package it.object.tempolibero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import it.object.tempolibero.model.User;
import it.object.tempolibero.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService us;

	@PostMapping
	public void addUserController (@RequestBody User user) {
		us.addUserService(user);
	}
	
	@GetMapping
	public List<User> getAllController () {
		return us.getAllService();
	}
}
