package it.object.tempolibero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.object.tempolibero.model.Role;
import it.object.tempolibero.repository.RoleRepository;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class RoleService {

	@Autowired
	RoleRepository rr;
	
	public void addRole (Role role) {
		rr.save(role);
	}
}
