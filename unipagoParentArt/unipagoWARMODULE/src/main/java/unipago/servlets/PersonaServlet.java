package unipago.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.unipago.ejb.*;
import org.unipago.*;



@WebServlet("/PersonaServlet")
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
	private PeopleBean mybl;

    /**
     * Default constructor. 
     */
    public PersonaServlet() {
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String middleName = request.getParameter("middlename");
		String lastName = request.getParameter("lastname");
		String secondLastName = request.getParameter("secondlastname");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("Phones");
		String phoneType = request.getParameter("phonetype");
		String dateofbirth = request.getParameter("Dob").toString();
		
		People person = new People();
		person.setFirstName(firstName);
		person.setMiddleName(middleName);
		person.setLastName(lastName);
		person.setSecondLastName(secondLastName);
		Address myadd = new Address();
		myadd.setAddress(address);
		person.setAddress(myadd);
		Phone phones = new Phone();
		phones.setPhoneNumber(phoneNumber);
		List<Phone> phonelist = new ArrayList<Phone>();
		phones.setPhoneType(phoneType);
		for(int x = 0; x < phonelist.size(); x++){
			person.setPhones(phonelist);
		}
		
		mybl.addPerson(person);
		String result = "";  
		person.setDateofbirth(dateofbirth);
	 String action = request.getParameter("action");
	    if("Add".equalsIgnoreCase(action)){
	    	mybl.addPerson(person);
	    	
	    	 result = "<html><head>"
            + "<h3> Persona Agregada Correctamente </h3></head>"
            + "<body>Gracias por enviarnos tus datos Sr."+ person.getFirstName() +" "+ person.getLastName() 
            + "</body><html>";
	    	
        }else if("Edit".equalsIgnoreCase(action)){
        	mybl.editPerson(person);
        	
        	 result = "<html><head>"
                    + "<h3> Campos Actualizados </h3></head>"
                    + "<body>Gracias</body><html>";
        	
        }else if("Delete".equalsIgnoreCase(action)){
        	mybl.deletePerson(person.getIdPerson());
        	 result = "<html><head>"
                    + "<h3> Persona Eliminada Correctamente </h3></head>"
                    + "<body>EL registro del Sr."+ person.getFirstName() +" "+ person.getLastName() 
                    + " ha sido eliminado del sistema</body><html>";
        	
        }else if("Search".equalsIgnoreCase(action)){
        		person = mybl.getPerson(person.getIdPerson());
        	result = "<html><head>"
                    + "<h3> Registro existe en el sistema </h3></head>"
                    + "<body>Contacto: Sr."+ person.getFirstName() +" "+ person.getLastName() 
                    + "</body><html>";
        }
		
		
		//result back to view
        response.getWriter().write(result);
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 processRequest(request, response);
	}

}
