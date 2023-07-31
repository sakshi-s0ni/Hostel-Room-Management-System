package com.hostel.hostelallocation.DAO.DAOImplement;

import com.hostel.hostelallocation.Bean.Students;
import com.hostel.hostelallocation.DAO.StudentDAO;
import com.hostel.hostelallocation.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean addStudent(Students studObj) {
        try(Session session = (Session) HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.save(studObj);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
}
