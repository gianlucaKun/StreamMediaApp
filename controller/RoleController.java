package it.object.tempolibero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.object.tempolibero.model.Role;
import it.object.tempolibero.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService rs;
	
	@PostMapping
	public void addRole (@RequestBody Role role) {
		rs.addRole(role);
	}
}
