package com.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="address_id")
	private long addressId;
	@NotEmpty
	@Size(min = 2, max = 14,message = "Type should have atleast 2 characters")
	private String type; // PERMANENT OR TEMPORARY
	@NotEmpty
	@Size(min = 2, max = 14,message = "Address line should have atleast 2 characters")
	private String addressLine1, addressLine2;
	@NotEmpty
	@Size(min = 2, max = 14,message = "city should have atleast 2 characters")
	private String city;
	@NotEmpty
	@Size(min = 2, max = 14,message = "state should have atleast 2 characters")
	private String state;
	@NotEmpty
	@Size(min = 2, max = 14,message = "country should have atleast 2 characters")
	private String country;
	@NotEmpty
	@Size(min = 2, max = 14,message = "pincode should have atleast 2 characters")
	private String pincode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	public UserTable usertable;
	
//	@ManyToOne
//    @JoinColumn(name = "pfid")
//	private UserTable usertable;

//	public UserTable getUsertable() {
//		return usertable;
//	}
//
//	public void setUsertable(UserTable usertable) {
//		this.usertable = usertable;
//	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

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

}
