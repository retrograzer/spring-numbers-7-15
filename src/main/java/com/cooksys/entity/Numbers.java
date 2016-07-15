package com.cooksys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Numbers {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "locationNum")
	private int locationNum;
	
}
