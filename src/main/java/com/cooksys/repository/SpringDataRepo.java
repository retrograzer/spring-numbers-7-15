package com.cooksys.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.entity.AppUser;

public interface SpringDataRepo extends JpaRepository<AppUser, Long> {

	public Page<AppUser> findByUsername(String s, Pageable page);
	
}
