package org.unipago;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReadOnly;

//@ReadOnly
//@Embeddable
public class PhonePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int idphone;
	private int people_idPerson;

	public PhonePK() {
	}
    
	public int getIdphone() {
		return this.idphone;
	}
	
	public void setIdphone(int idphone) {
		this.idphone = idphone;
	}
/*
	@Column(insertable=false, updatable=false)
	public int getPeople_idPerson() {
		return this.people_idPerson;
	}
	public void setPeople_idPerson(int people_idPerson) {
		this.people_idPerson = people_idPerson;
	}
*/
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PhonePK)) {
			return false;
		}
		PhonePK castOther = (PhonePK)other;
		return 
			(this.idphone == castOther.idphone)
			&& (this.people_idPerson == castOther.people_idPerson);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idphone;
		hash = hash * prime + this.people_idPerson;
		
		return hash;
	}
}