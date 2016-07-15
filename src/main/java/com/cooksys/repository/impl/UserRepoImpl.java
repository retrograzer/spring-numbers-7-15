package com.cooksys.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cooksys.entity.AppUser;
import com.cooksys.entity.Titles;
import com.cooksys.repository.UserRepo;

@Repository
public class UserRepoImpl implements UserRepo {
	
	@Autowired
	EntityManager em;

	@Override
	public int incrementLocation(Integer location) {
		return location++;
	}

	@Override
	public String newLocation(String title, Integer location) {
		em.createQuery("insert into Titles values(:location, :username)", Titles.class)
				.setParameter("location", location);
		return "New Location Set";
	}

	@Override
	public int newUser(String userName, String password, Integer location) {
		return em.createQuery("insert into AppUser values(:location, :username, :password)", AppUser.class)
				.setParameter("location", location)
				.setParameter("username", userName)
				.setParameter("password", password)
				.getFirstResult();
	}

	@Override
	public String logIn(String userName, String password, Integer location) {
		List<AppUser> userList = new ArrayList<>();
		userList = em.createQuery("from AppUser", AppUser.class).getResultList();
		if (userList.contains(userName)){
			System.out.println("This seems like too simple of a method...");
		}
		return "Hello, Dolly";
	}

	@Override
	public String countForNum(String userName, String password, Integer location) {
		return null;
	}

	@Override
	public List<Titles> getAll() {
		return em.createQuery("from Titles", Titles.class)
				.getResultList();
	}

	@Override
	public List<Titles> getAllUsersFromNum(int users) {
		return em.createQuery("select id.id from Titles id where id.id = :users ", Titles.class)
				.setParameter("users", users)
				.getResultList();
	}

	@Override
	public String conversionByNum(String users) {
		return null;
	}

}
