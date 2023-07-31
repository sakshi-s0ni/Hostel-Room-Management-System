package com.hostel.hostelallocation.Controller;

import com.hostel.hostelallocation.Bean.Employee;
import com.hostel.hostelallocation.Bean.Hostel;
import com.hostel.hostelallocation.Bean.Students;
import com.hostel.hostelallocation.DAO.HostelDAO;
import com.hostel.hostelallocation.DAO.DAOImplement.HostelDAOImpl;
import com.hostel.hostelallocation.Service.HostelService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/hostel")
public class HostelController {
    HostelDAO hDAO = new HostelDAOImpl();
    @GET
    @Path("/get/{hostel_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRooms(@PathParam("hostel_id") Integer hostelId) {
        //hostelId = 1;
        List<Hostel> roomList = new HostelService().getRooms(hostelId);
        return Response.ok().entity(roomList).build();
    }
    @GET
    @Path("/availrooms")
    @Produces(MediaType.APPLICATION_JSON)
    public Response filterAvail() {
        List<Hostel> roomList = new HostelService().filterAvail();
        return Response.ok().entity(roomList).build();
    }
    @GET
    @Path("/filterfloors/{floor}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response filterFloor(@PathParam("floor") Integer floor) {
        List<Hostel> roomList = new HostelService().filterFloor(floor);
        return Response.ok().entity(roomList).build();
    }
    @GET
    @Path("/filterhname/{hostelName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response filterName(@PathParam("hostelName") String hostelName) {
        List<Hostel> roomList = new HostelService().filterName(hostelName);
        return Response.ok().entity(roomList).build();
    }
    Students studObj = new Students();
    @PUT
    @Path("/allocate/{hostel_id}/{stud_hostel_fk}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAllocation(@PathParam("hostel_id") Integer hostel_id, @PathParam("stud_hostel_fk") Integer stud_hostel_fk){

        studObj.setStudentId(stud_hostel_fk);
        List<Hostel> roomList = new HostelService().updateAllocation(hostel_id,studObj);
        return Response.ok().entity(roomList).build();
//        public Response login(Employee emp) {
//            Employee loggedInEmp = Employee.login(emp);
//
//            if (loggedInEmp == null)
//                return Response.status(401).build();
//            else
//                return Response.ok().entity(loggedInEmp).build();
//        }
    }

    @GET
    @Path("/getHostel")
    public Response getHostelName(){
        HostelDAO hostelDAO = new HostelDAOImpl();
        List<String> hostel = hostelDAO.getHostel();
        return Response.ok().entity(hostel).build();
    }
    @GET
    @Path("/getFloor")
    public Response getFloor(){
        HostelDAO hostelDAO = new HostelDAOImpl();
        List<Integer> hostel = hostelDAO.getFloor();
        return Response.ok().entity(hostel).build();
    }
}
