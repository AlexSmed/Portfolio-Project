package app.persistence;

import app.config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ProductsDAO {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

    public Products save(Products products)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(products);
        em.getTransaction().commit();
        em.close();
        return products;
    }

    public Products findByCategory(String category)
    {
        EntityManager em = emf.createEntityManager();
        Products foundProducts = em.find(Products.class, category);
        em.close();
        return foundProducts;
    }

    public Products findByName(String name)
    {
        EntityManager em = emf.createEntityManager();
        Products foundProducts = em.find(Products.class, name);
        em.close();
        return foundProducts;
    }

    public void delete(String name)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Products products = findByName(name);
        if (products != null)
        {
            em.remove(products);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void close()
    {
        emf.close();
    }
}
