package it.object.tempolibero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import it.object.tempolibero.model.User;
import it.object.tempolibero.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository ur;
	
	
	public void addUserService (User user) {
		ur.save(user);
	}


	public List<User> getAllService () {
		List<User> listaUtenti = ur.findAll();
		return listaUtenti;
	}
}
