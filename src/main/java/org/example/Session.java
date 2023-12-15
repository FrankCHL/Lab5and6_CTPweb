package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Session {
    public Long save(Books car){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Books.class)
                .buildSessionFactory();

        // Create session
        org.hibernate.Session session = factory.getCurrentSession();

        Books books = new Books();
        books.setType(car.getType());
        books.setName(car.getName());
        books.setVender(car.getVender());

        session.persist(books);
        factory.close();
        return null;
    }
}
