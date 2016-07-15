package com.cooksys.repository;

import java.util.List;

import com.cooksys.entity.AppUser;
import com.cooksys.entity.Titles;

public interface UserRepo {

	int incrementLocation(Integer location);

	String newLocation(String title, Integer location);

	int newUser(String userName, String password, Integer location);

	String logIn(String userName, String password, Integer location);

	String countForNum(String userName, String password, Integer location);

	List<Titles> getAll();

	List<Titles> getAllUsersFromNum(int location);

	String conversionByNum(String users);

}
