package com.demo.library;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
//        saveLibrary();
        saveLibraryAndAuthor();
    }


    private static void saveLibrary() {
        System.out.println( "HIBERNATE" );
        SessionFactory sessionFactory;
        EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("demo.PersistenceUnit1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Session session = null;
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
//        Transaction transaction =  session.getTransaction();
//        session.beginTransaction();
        Library library1 = new Library(1,"Library1");
//        Library library1 = new Library(2,"Library2");
        entityManager.persist(library1);
//        session.save(library1);
        entityTransaction.commit();
//       transaction.commit();
//       session.close();
        entityManagerFactory.close();
    }

    private static void saveLibraryAndAuthor() {
        System.out.println( "HIBERNATE" );
        EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("demo.PersistenceUnit1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Author author1 = new Author(1,"A22");
        Author author2 = new Author(2,"A33");
        Author author3 = new Author(3,"A33");
        Library library1 = new Library(2,"Library22");
        Library library2 = new Library(3,"Library33");
        entityManager.persist(library1);
        entityManager.persist(library2);

        library1.addAuthor(author1);
        library2.addAuthor(author3);
        author1.setLibrary(library1);
        library1.addAuthor(author2);
        author2.setLibrary(library1);
        author3.setLibrary(library2);
        entityManager.persist(author1);
        entityManager.persist(author2);
        entityManager.persist(author3);
//        Library library1 = new Library(1,"Library1");
        entityTransaction.commit();
        entityManagerFactory.close();
    }
}
