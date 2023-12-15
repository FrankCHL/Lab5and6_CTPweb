package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExample {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Books.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            Books books = new Books();
            books.setType("25");
            books.setName("JohnDoe");
            books.setVender("qwe");

            session.persist(books);

            Books book = new Books();
            book.setId(4);
            book = session.find(Books.class, book.getId());
            book.setName("Люди на болоте");
            session.persist(book);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}

