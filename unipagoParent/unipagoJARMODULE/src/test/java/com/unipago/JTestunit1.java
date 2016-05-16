package com.unipago;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.results.PrintableResult;

import junit.framework.TestResult;


/**
 * Unit test for simple App.
 */
public class JTestunit1
{
    private static final String PERSISTENCE_UNIT_NAME = "unipagoJARMODULE";
	private EntityManagerFactory factory;
	  
	@Before
    public void setUp()
    {
		 System.out.println("Executing insertPerson Method");
  //getting few people ready for testing
    	  factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    EntityManager em = factory.createEntityManager();

		    // Begin a new local transaction so that we can persist a new entity
		    em.getTransaction().begin();
		    // read the existing entries
		    Query q = em.createQuery("select m from People m");
		    // Persons should be empty

		    // do we have entries?
		    boolean createNewEntries = (q.getResultList().size() == 0);
		   
		    
		    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		    Date date = new Date();
		    String datef = dateFormat.format(date);
		    
		    // No, so lets create new entries
		    if (createNewEntries) {
		    	System.out.println("Inserting new entities...");
		    	
		      for (int i = 0; i < 10; i++) {
		    	  //CREATING OBJECTS
		    	  
		    	  People person = new People();
		    	  Address addr = new Address();
		    	  Phone myPhones1 = new Phone();
		    	  Phone myPhones2 = new Phone();
		    	  Phone myPhones3 = new Phone();
		    	  
		    	  //SETTING UP PERSON DATA
		    	   person.setFirstName("Jose_" + i);                
			        person.setMiddleName("alberto_" + i);
			        person.setLastName("Perez_" + i);
			        person.setSecondLastName("Baez_" + i);
			        person.setGender("M");
			        person.setDateofbirth(datef);
			        
			        /*  SETTING UP AN ADDRESS*/
			        addr.setCity("Santo Domingo_"+ i);              
			        addr.setCountry("United States_"+ i);
			        addr.setState_province("somewhere_"+ i);
			        addr.setEmailAddress("myemail@fakemail.com_"+ i);
			        addr.setStreet("myfakestreet_"+ i);
			        addr.setZipcode("33894_"+ i);
			        addr.setAddressReferences("Close to the bank of america_"+ i);
			        addr.setPeople(person);
			        addr.setAddress("residencial Paul Misk #3 aptf-3_"+ i); 
			        person.setAddress(addr);//adding to person
			        
			        //SETTING UP PERSON PHONES
			        myPhones1.setPhoneNumber("809-231-269" + i);
			        myPhones1.setPhoneType("Residential_" + i);
			        myPhones1.setPeople(person);
			       // myPhones1.setId(myKey);
			        
			        myPhones2.setPhoneNumber("809-231-269"+ i);
			        myPhones2.setPhoneType("Mobile_"+ i);
			        myPhones2.setPeople(person);

			        myPhones3.setPhoneNumber("1(305)334-445"+ i);
			        myPhones3.setPhoneType("international_"+ i);
			        myPhones3.setPeople(person);
			       List<Phone> phonelist = new ArrayList<Phone>();
			       
			       //setting up multiple phones to the same person
			       phonelist.add(myPhones1); 
			       phonelist.add(myPhones2);
			       phonelist.add(myPhones3);
			       
			      person.setPhones(phonelist);

			        em.persist(person);
		      }
		      
		    }
		    em.getTransaction().commit();
		    em.close();
    }
    
     @Test
	  public void CheckAvailablePeople() {
    	 System.out.println("Executing readingPerson Method");
	    // now lets check the database and see if the created entries are there
	    // create a fresh, new EntityManager
    	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	 
	    em.getTransaction().begin();
	    // Perform a simple query for all the Message entities
	    
	    People plp = em.find(People.class, 1);
	    	assertNotNull(plp);
	    	System.out.println( plp.getFirstName());
	    	System.out.println( plp.getMiddleName());
	    	System.out.println( plp.getLastName());
	    	System.out.println( plp.getGender());
	    	System.out.println("Displaying available people..");
	    // We should have 1 People in the database
			System.out.println( "Successfull Test");
		   
			

	    em.close();
	  }
	  
     @Test
     public void updatePerson(){
    	System.out.println("Executing updatePerson Method"); 
    	EntityManager em = factory.createEntityManager();
    	 em.getTransaction().begin();
		 People oneperson = new People();
		 oneperson.setFirstName("Jose_1"); //PARAMETER
		 //FINDING MY PERSON
    	  Object p = em.createNamedQuery("People.findbyName")
         .setParameter("firstName", oneperson.getFirstName()).getSingleResult();
        //casting the match returned to my People object
    	  //UPDATING PERSONAL INFORMATION
    	oneperson = (People)p;
    	assertNotNull(oneperson);
    	oneperson.setFirstName("JUANACTUALIZADO");
    	oneperson.setSecondLastName("PEREZACTUALIZADO");
    	oneperson.setMiddleName("ANDRESACTUALIZADO");
    	oneperson.getAddress().setCity("CIUDADACTUALIZADA");
    	
    	//UPDATING PHONES OF PEOPLE
    	List<Phone> myList = new ArrayList<Phone>();
    	myList = oneperson.getPhones();
    	myList.get(1).setPhoneNumber("000-000-00000");
    	myList.get(2).setPhoneNumber("000-000-00000");
    	myList.get(3).setPhoneNumber("000-000-00000");
    	
		 em.merge(oneperson);
		 em.getTransaction().commit();
		 em.close();
		
     }
     
     @Test
	  public void deletePerson() {
    	 System.out.println("Executing deletePerson Method");
		    EntityManager em = factory.createEntityManager();
		    // Begin a new local transaction so that we can persist a new entity
		    em.getTransaction().begin();
		    Query q = em.createQuery("SELECT p FROM People p WHERE p.firstName = :firstName AND p.lastName = :lastName");
		    q.setParameter("firstName", "Jose_1");
		    q.setParameter("lastName", "Perez_1");
		    People user = (People) q.getSingleResult();
		    assertNotNull(user);
		    Address useraddress = new Address();
		    useraddress = user.getAddress();
		  //NULLING OBJECT TO BE DELETED
		    user.setAddress(null);
		    em.remove(useraddress);
		    em.remove(user);
		    em.getTransaction().commit();

		    em.close();
		  }
}


