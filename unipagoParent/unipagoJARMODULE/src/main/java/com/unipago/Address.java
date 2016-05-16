package com.unipago;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	private int people_idPerson;
	private String address;
	private String city;
	private String country;
	private String emailAddress;
	private String address_references;
	private String state_province;
	private String street;
	private String zipcode;
	private People people;

	public Address() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false)
	public int getPeople_idPerson() {
		return this.people_idPerson;
	}

	public void setPeople_idPerson(int people_idPerson) {
		this.people_idPerson = people_idPerson;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Column(name="email_address")
	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getAddressReferences() {
		return this.address_references;
	}

	public void setAddressReferences(String address_references) {
		this.address_references = address_references;
	}


	@Column(name="stateprovince")
	public String getState_province() {
		return this.state_province;
	}

	public void setState_province(String state_province) {
		this.state_province = state_province;
	}


	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}


	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	//bi-directional one-to-one association to People
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	public People getPeople() {
		return this.people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

}