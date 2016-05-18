package org.unipago.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.unipago.*;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *no contract first (I ran outta time)
 */
@WebService
@Stateless
public class PeopleBean implements PeopleBeanLocal {

    
   @PersistenceContext(unitName = "unipagoJARMODULE")
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public PeopleBean() {
        // TODO Auto-generated constructor stub
    }

    @WebMethod
	public void addPerson(People person) {
		entityManager.persist(person);
		
	
	}

    @WebMethod
	public void editPerson(People person) {
		// TODO Auto-generated method stub
		
	}

    @WebMethod
	public void deletePerson(int personId) {
		// TODO Auto-generated method stub
		
	}

	@WebMethod
	public People getPerson(int personId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<People> getAllPeople() {
		// TODO Auto-generated method stub
		return null;
	}

}
