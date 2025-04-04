package com.magasin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magasin.models.Users;

@Repository
public interface UserRespository extends JpaRepository<Users, Long> {
	Optional<Users> findByUsername(String username);

	Optional<Users> findByUsernameAndPassword(String username, String password);

//    Optional<Users> findByUsernameToken(String id);
}
