package org.unipago.ejb;

import java.util.List;

import javax.ejb.Local;

import org.unipago.People;

@Local
public interface PeopleBeanLocal {
	  void addPerson(People person);

	    void editPerson(People person);

	    void deletePerson(int personId);

	    People getPerson(int personId);

	    List<People> getAllPeople();
}
