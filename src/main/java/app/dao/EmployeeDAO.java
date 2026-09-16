package app.dao;

import app.config.HibernateConfig;
import app.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class EmployeeDAO {

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    public Employee save(Employee employee)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        em.close();
        return employee;
    }

    public Employee findById(int id)
    {
        EntityManager em = emf.createEntityManager();
        Employee foundEmployee = em.find(Employee.class, id);
        em.close();
        return foundEmployee;
    }

    public Employee update(Employee employee)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Employee updatedEmployee = em.merge(employee);
        em.getTransaction().commit();
        em.close();
        return updatedEmployee;
    }

    public void delete(int id)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Employee employee = findById(id);
        if (employee != null)
        {
            em.remove(employee);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void close()
    {
        emf.close();
    }
}

