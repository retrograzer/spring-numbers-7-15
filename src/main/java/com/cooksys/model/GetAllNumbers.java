package com.cooksys.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.entity.AppUser;

public class GetAllNumbers {
	
	private long id;
	
	private String firstName;

	public GetAllNumbers(long id, String username) {
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static ArrayList<GetAllNumbers> list(List<AppUser> list, String state) {
		ArrayList<GetAllNumbers> result = new ArrayList<>();
		for(AppUser user : list) {
			if (user.getUsername().equals(state)){
				result.add(new GetAllNumbers(user.getId(), user.getUsername()));
			} else if (user.getUsername() == null) {
				result.add(new GetAllNumbers(1, "Dumbass!"));
			} else {
				System.out.println("No State with that name!");
			}
			//result.add(new GetAllUsersResponse(user.getId(), user.getState(), user.getFirstName()));
		}
		return result;
	}
}
