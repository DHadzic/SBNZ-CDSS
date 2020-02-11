package com.siit.sbnz.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siit.sbnz.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	User findByUsername(String username);
	ArrayList<User> findAll();
}
