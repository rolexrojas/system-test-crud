package com.unipago;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;


/**
 * The persistent class for the people database table.
 * 
 */

@Entity
@NamedQueries({
	@NamedQuery(name="People.findAll", query="SELECT p FROM People p"),
	@NamedQuery(name="People.findbyName", query="SELECT p FROM People p WHERE p.firstName = :firstName")
})
public class People implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idPerson;
	private String dateofbirth;
	private String firstName;
	private String gender;
	private String lastName;
	private String middleName;
	private String secondLastName;
	private Address address;
	private List<Phone> phones;

	public People() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}


	public String getDateofbirth() {
		return this.dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}


	@Column(name="first_name")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	@Column(name="last_name")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Column(name="middle_name")
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	@Column(name="second_last_name")
	public String getSecondLastName() {
		return this.secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}


	//bi-directional one-to-one association to Address
	@OneToOne(mappedBy="people", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@PrimaryKeyJoinColumn
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	//bi-directional many-to-one association to Phone
	@OneToMany(mappedBy="people", cascade={CascadeType.ALL, CascadeType.REMOVE})
	@JoinColumn
	public List<Phone> getPhones() {
		return this.phones;
		
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
		
	}

	public Phone addPhone(Phone phone) {
		getPhones().add(phone);
		phone.setPeople(this);

		return phone;
	}

	public Phone removePhone(Phone phone) {
		getPhones().remove(phone);
		phone.setPeople(null);

		return phone;
	}

}