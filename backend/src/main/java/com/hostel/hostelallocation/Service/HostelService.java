package com.hostel.hostelallocation.Service;
import com.hostel.hostelallocation.Bean.Hostel;
import com.hostel.hostelallocation.Bean.Students;
import com.hostel.hostelallocation.DAO.DAOImplement.HostelDAOImpl;
//import com.hostel.hostelallocation.DAO.HostelDAO;

import java.util.List;

public class HostelService {
    HostelDAOImpl hostelDAO = new HostelDAOImpl();
    public List<Hostel> getRooms(Integer h_id){
        List<Hostel> roomsList = hostelDAO.getRooms(h_id);
        return roomsList;
    }
    public List<Hostel> filterAvail(){
        List<Hostel> roomsList = hostelDAO.filterAvail();
        return roomsList;
    }
    public List<Hostel> filterFloor(Integer floor){
        List<Hostel> roomsList = hostelDAO.filterFloor(floor);
        return roomsList;
    }
    public List<Hostel> filterName(String hostelName){
        List<Hostel> roomsList = hostelDAO.filterName(hostelName);
        return roomsList;
    }
    public List<Hostel> updateAllocation(Integer hostelId, Students studObj){
        List<Hostel> roomsList = hostelDAO.updateAllocation(hostelId,studObj);
        return roomsList;
    }
}
