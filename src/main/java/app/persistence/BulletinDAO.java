package app.persistence;

import app.config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class BulletinDAO {

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    public Bulletin save(Bulletin bulletin)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(bulletin);
        em.getTransaction().commit();
        em.close();
        return bulletin;
    }

    public Bulletin findByTitle(String title)
    {
        EntityManager em = emf.createEntityManager();
        Bulletin foundBulletin = em.find(Bulletin.class, title);
        em.close();
        return foundBulletin;
    }

    public Bulletin update(Bulletin bulletin)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Bulletin updatedBulletin = em.merge(bulletin);
        em.getTransaction().commit();
        em.close();
        return updatedBulletin;
    }

    public void delete(String title)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Bulletin bulletin = findByTitle(title);
        if (bulletin != null)
        {
            em.remove(bulletin);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void close()
    {
        emf.close();
    }
}


