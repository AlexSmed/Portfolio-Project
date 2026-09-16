package app.config;


import app.entities.Bulletin;
import app.entities.Employee;
import app.entities.Products;
import app.entities.Routines;
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