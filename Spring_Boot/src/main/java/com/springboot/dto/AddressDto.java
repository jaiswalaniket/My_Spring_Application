package com.springboot.dto;

import com.springboot.model.UserTable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AddressDto {


	private long addressId;


	private String type; // PERMANENT OR TEMPORARY

	private String addressLine1, addressLine2;

	private String city;

	private String state;

	private String country;

	private String pincode;

	private UserTable usertable;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

//	public long getUsertable() {
//		return usertable;
//	}
//
//	public void setUsertable(long usertable) {
//		this.usertable = usertable;
//	}

	public AddressDto(@NotEmpty @Size(min = 2, max = 14, message = "Type should have atleast 2 characters") String type,
			@NotEmpty @Size(min = 2, max = 14, message = "Address line should have atleast 2 characters") String addressLine1,
			@NotEmpty @Size(min = 2, max = 14, message = "Address line should have atleast 2 characters") String addressLine2,
			@NotEmpty @Size(min = 2, max = 14, message = "city should have atleast 2 characters") String city,
			@NotEmpty @Size(min = 2, max = 14, message = "state should have atleast 2 characters") String state,
			@NotEmpty @Size(min = 2, max = 14, message = "country should have atleast 2 characters") String country,
			@NotEmpty @Size(min = 2, max = 14, message = "pincode should have atleast 2 characters") String pincode,
			@NotEmpty @Size(min = 2, max = 14, message = "usertable should have atleast 2 characters") long usertable) {
		super();
		this.type = type;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		//this.usertable = usertable;
	}

	public AddressDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public void setUsertable(UserTable usertable) {
		this.usertable = usertable;
	}
}
