package com.hostel.hostelallocation.Controller;
import com.hostel.hostelallocation.Bean.Employee;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/employee")
public class EmployeeController {
    Employee emp = new Employee();
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Employee emp) {
        Employee loggedInEmp = Employee.login(emp);

        if (loggedInEmp == null)
            return Response.status(401).build();
        else
            return Response.ok().entity(loggedInEmp).build();
    }
}

