package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.AppUser;
import com.cooksys.entity.Titles;
import com.cooksys.repository.UserRepo;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserRepo userRepo;
	
	@RequestMapping("encourage")
	public String howdy() {
		return "Howdy, pardner. You can do this.";
	}
	
	@RequestMapping(value = "/increment", method = RequestMethod.POST)
	public int incr (@RequestBody Integer location) {
		return userRepo.incrementLocation(location);
	}
	
	@RequestMapping(value = "/newLocation", method = RequestMethod.POST)
	public String newLocation (@RequestBody String title, Integer location) {
		return userRepo.newLocation(title, location);
	}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public int newUser (@RequestBody String userName, String password, Integer location) {
		return userRepo.newUser(userName, password, location);
	}
	
	@RequestMapping(value = "/newLocation", method = RequestMethod.POST)
	public String logIn (@RequestBody String userName, String password, Integer location) {
		return userRepo.logIn(userName, password, location);
	}
	
	@RequestMapping(value = "/countForNum", method = RequestMethod.GET)
	public String countForNum (@RequestBody String userName, String password, Integer location) {
		return userRepo.countForNum(userName, password, location);
	}
	
	@RequestMapping("/allNums")
	public List<Titles> getAll() {
		return userRepo.getAll();
	}
	
	@RequestMapping("/allNums/{users}")
	public List<Titles> usersByNum(@PathVariable("users") int location) {
		return userRepo.getAllUsersFromNum(location);
	}
	
	@RequestMapping("/allNums/{conversion}")
	public String usersByNum(@PathVariable("conversion") String users) {
		return userRepo.conversionByNum(users);
	}

}
