package app.config;


import app.persistence.Bulletin;
import app.persistence.Employee;
import app.persistence.Products;
import app.persistence.Routines;
import org.hibernate.cfg.Configuration;

final class EntityRegistry {

    private EntityRegistry() {}

    static void registerEntities(Configuration configuration) {
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Bulletin.class);
        configuration.addAnnotatedClass(Routines.class);
        configuration.addAnnotatedClass(Products.class);

    }
}