package com.springboot.dto;

import com.springboot.model.Address;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class UserDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private long id;

	@NotEmpty
	@Size(min = 2, max = 14,message = "UserName should have atleast 2 characters")
	private String userName;

	@NotEmpty
	@Size(min = 2, max = 14,message = "Latitude name should have atleast 2 characters")
	private String latitude;

	@NotEmpty
	@Size(min = 2, max = 14,message = "Longitude name should have atleast 2 characters")
	private String longitude;

	@NotEmpty
	@Size(min = 2, max = 14,message = "Salary should have atleast 2 characters")
	private String salary;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pfid",referencedColumnName = "user_id")
	@Valid
	private List<Address> addresses;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public UserDto(
			@NotEmpty @Size(min = 2, max = 14, message = "UserName should have atleast 2 characters") String userName,
			@NotEmpty @Size(min = 2, max = 14, message = "Latitude name should have atleast 2 characters") String latitude,
			@NotEmpty @Size(min = 2, max = 14, message = "Longitude name should have atleast 2 characters") String longitude,
			@NotEmpty @Size(min = 2, max = 14, message = "Salary should have atleast 2 characters") String salary) {
		super();
		this.userName = userName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.salary = salary;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
}
