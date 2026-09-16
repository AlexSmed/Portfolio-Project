package app.dao;

import app.config.HibernateConfig;
import app.entities.Routines;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class RoutinesDAO {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    public Routines save(Routines routines)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(routines);
        em.getTransaction().commit();
        em.close();
        return routines;
    }
}
