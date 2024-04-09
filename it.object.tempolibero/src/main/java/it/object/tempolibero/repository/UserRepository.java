package it.object.tempolibero.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.object.tempolibero.model.User;

public interface UserRepository extends JpaRepository<User, Long> {}
