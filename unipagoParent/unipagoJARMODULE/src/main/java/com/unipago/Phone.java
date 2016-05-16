package com.unipago;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the phones database table.
 * 
 */
@Entity
@Table(name="phones")
@NamedQuery(name="Phone.findAll", query="SELECT p FROM Phone p")
public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;
//	private PhonePK id;
	private String phoneNumber;
	private String phoneType;
	private People people;
	private int idphone;
	//private int people_idPerson;

	public Phone() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdphone() {
		return this.idphone;
	}
	
	public int setIdphone(int idphone){
		return this.idphone = idphone;
		
	}
	
/*	
	@EmbeddedId
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public PhonePK getId() {
		return this.id;
	}

	public void setId(PhonePK id) {
		this.id = id;
	}

*/
	@Column(name="phone_number")
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Column(name="phone_type")
	public String getPhoneType() {
		return this.phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}


	//bi-directional many-to-one association to People
	@ManyToOne
	@JoinColumn(name="PHONES_IDPERSON", referencedColumnName="IDPERSON")
	public People getPeople() {
		return this.people;
	}

	public void setPeople(People people) {
		this.people = people;
	}
	

}