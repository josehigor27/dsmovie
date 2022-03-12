package com.aprendendoaprogramar.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendoaprogramar.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
