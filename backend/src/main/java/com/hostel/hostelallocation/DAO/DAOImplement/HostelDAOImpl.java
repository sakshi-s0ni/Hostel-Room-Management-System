package com.hostel.hostelallocation.DAO.DAOImplement;

import com.hostel.hostelallocation.Bean.Hostel;
import com.hostel.hostelallocation.Bean.Students;
import com.hostel.hostelallocation.DAO.HostelDAO;
import com.hostel.hostelallocation.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class HostelDAOImpl implements HostelDAO {

    @Override
    public List<Hostel> getRooms(Integer s_id) {
        List<Hostel> roomList = new ArrayList<>();

        try (Session session = HibernateSessionUtil.getSession()){
            //Query q = (Query) session.createQuery("FROM Hostel h WHERE h.studHostelFk.studentId = :s_id", Hostel.class);
            Query q = (Query) session.createQuery("FROM Hostel h", Hostel.class);
            //q.setParameter("s_id", s_id);
            List<Hostel> list = q.getResultList();
            for(final Object room : list) roomList.add((Hostel) room);
            return roomList;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return roomList;
    }
    @Override
    public List<Hostel> filterAvail(){
        List<Hostel> hList = new ArrayList<>();
        try (Session session = HibernateSessionUtil.getSession()){
            Query q = (Query) session.createQuery("FROM Hostel h WHERE h.studHostelFk.studentId is null ", Hostel.class);
            List<Hostel> list = q.getResultList();
            for(final Object aroom : list) hList.add((Hostel) aroom);
            return hList;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return hList;
    }
    @Override
    public List<Hostel> filterFloor(Integer floor){
        List<Hostel> fList = new ArrayList<>();
        try (Session session = HibernateSessionUtil.getSession()){
            Query qu = (Query) session.createQuery("FROM Hostel h WHERE h.floor = :floor",Hostel.class);
            qu.setParameter("floor",floor);
            List<Hostel> list = qu.getResultList();
            for(final Object froom : list) fList.add((Hostel) froom);
            return fList;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return fList;
    }

    @Override
    public List<Hostel> filterName(String hostelName){
        List<Hostel> nameList = new ArrayList<>();
        try (Session session = HibernateSessionUtil.getSession()){
            Query qu = (Query) session.createQuery("FROM Hostel h WHERE h.hostelName = :hostelName",Hostel.class);
            qu.setParameter("hostelName",hostelName);
            List<Hostel> list = qu.getResultList();
            for(final Object nroom : list) nameList.add((Hostel) nroom);
            return nameList;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return nameList;
    }
    @Override
    public List<Hostel> updateAllocation(Integer hostelId, Students studObj){
        List<Hostel> allocList = new ArrayList<>();
        try (Session session = HibernateSessionUtil.getSession()){
            Query qupdate = (Query) session.createQuery("update Hostel h set h.studHostelFk.studentId =:sid where h.hostelId =:hostelId");
            qupdate.setParameter("sid",studObj.getStudentId());
            qupdate.setParameter("hostelId",hostelId);
            Transaction transaction = session.beginTransaction();
            qupdate.executeUpdate();
            Query qu = (Query) session.createQuery("FROM Hostel h",Hostel.class);
            //qu.setParameter("hostelId",hostelId);
            List<Hostel> list = qu.getResultList();
            for(final Object allocroom : list) allocList.add((Hostel) allocroom);
            transaction.commit();
            return allocList;
        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }
        return allocList;
    }

    @Override
    public List<String> getHostel() {
        try(Session session = HibernateSessionUtil.getSession()){
            Query q = session.createQuery("select distinct hostelName from Hostel", String.class);
            List<String> list = q.getResultList();
            return list;
        }catch (HibernateException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }
    @Override
    public List<Integer> getFloor() {
        try(Session session = HibernateSessionUtil.getSession()){
            Query q = session.createQuery("select distinct floor from Hostel", Integer.class);
            List<Integer> list = q.getResultList();
            return list;
        }catch (HibernateException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }
}
