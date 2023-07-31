package com.hostel.hostelallocation.DAO;
import com.hostel.hostelallocation.Bean.Hostel;
import com.hostel.hostelallocation.Bean.Students;

import java.util.List;

public interface HostelDAO {
    List<Hostel> getRooms(Integer h_id);
    List<Hostel> filterAvail();
    List<Hostel> filterFloor(Integer floor);
    List<Hostel> filterName(String hostelName);

    List<Hostel> updateAllocation(Integer hostelId, Students studObj);

    List<String> getHostel();
    List<Integer> getFloor();
}
