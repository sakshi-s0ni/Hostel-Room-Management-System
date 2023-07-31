package com.hostel.hostelallocation.DAO.DAOImplement;
import com.hostel.hostelallocation.Bean.Employee;
import com.hostel.hostelallocation.DAO.EmployeeDAO;
import com.hostel.hostelallocation.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
public class EmployeeDAOImpl implements EmployeeDAO{
    @Override
    public Employee login(Employee Employee) {
        try (Session session = HibernateSessionUtil.getSession();){
            String EmployeeEmail = Employee.getEmp_email();
            String EmployeePassword = Employee.getEmp_pass();

            //List<Employee> result = new ArrayList<>();
            Query q = (Query) session.createQuery("FROM Employee WHERE emp_email = :EmployeeEmail and emp_pass = :EmployeePassword")
                    .setParameter("EmployeeEmail", EmployeeEmail)   //placeholder,setvalue vali value set
                    .setParameter("EmployeePassword", EmployeePassword);
            List<Employee> result = q.getResultList();
            // If no valid Employee found, return null so that login failure is understood
            if (result.size() == 0)
                return null;
            else
                return (Employee) result.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return null;
    }
}
