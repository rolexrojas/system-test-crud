<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <h1>Person Information</h1>
        <form action="./PersonaServlet" method="POST">
            <table>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstname"/></td>
                </tr>
                <tr>
                    <td>Middle Name</td>
                    <td><input type="text" name="middlename"/></td>
                </tr>
                  <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastname"/></td>
                </tr>
                  <tr>
                    <td>Second Last Name</td>
                    <td><input type="text" name="secondlastname"/></td>
                </tr>
                  <tr>
                    <td>Address</td>
                    <td><input type="text" name="address"/></td>
                </tr>
                  <tr>
                    <td>Phones</td>
                    <td><input type="text" name="Phones"/></td>
                </tr>
                 <tr>
                    <td>Date of birth</td>
                    <td><input type="Date" name="Dob"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                       <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>                
                </tr>            
            </table>
        </form>        
        <br> 
    </body>
</html>