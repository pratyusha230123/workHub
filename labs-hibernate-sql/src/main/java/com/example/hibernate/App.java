package com.example.hibernate;


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
        saveTripDetails();
    }

    private static void saveTripDetails() {
        System.out.println( "HIBERNATE" );
        EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("demo.PersistenceUnit2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Trip trip1 = new Trip(1, "MELBOURNE-SYDNEY");
        Trip trip2 = new Trip(2, "HYD-VIJ");
        Trip trip3 = new Trip(3, "ADELAIDE-PERTH");
        Trip trip4 = new Trip(4,"BRISBANE-MELBOURNE");
        
        Passenger pssngr1 = new Passenger(1,"Pratyusha");
        Passenger pssngr2 = new Passenger(2,"manjeer");
        Passenger pssngr3 = new Passenger(3,"Naina");
        
        Ticket ticket1 = new Ticket(10,"A");
        Ticket ticket2 = new Ticket(20,"B");
        
        pssngr1.setTrip(trip1);
        pssngr1.setTrip(trip4);

        pssngr2.setTrip(trip3);

        pssngr3.setTrip(trip1);
        
        
        //add passengers to trip
        
        trip1.addPassenger(pssngr1);
        trip1.addPassenger(pssngr3);

        trip2.addPassenger(pssngr3);
        trip2.addPassenger(pssngr2);

        trip4.addPassenger(pssngr3);
        trip4.addPassenger(pssngr2);

        trip3.addPassenger(pssngr1);


        pssngr1.addTicket(ticket2);

        pssngr2.addTicket(ticket2);

        pssngr3.addTicket(ticket1);
        pssngr3.addTicket(ticket2);


        
        //set passengers to tickets
        ticket1.setPassenger(pssngr1);
        ticket2.setPassenger(pssngr3);


        entityManager.persist(ticket1);
        entityManager.persist(ticket2);

        entityManager.persist(trip2);
        entityManager.persist(trip1);
        entityManager.persist(trip3);
        entityManager.persist(trip4);

        entityManager.persist(pssngr1);
        entityManager.persist(pssngr2);
        entityManager.persist(pssngr3);

        entityTransaction.commit();
        entityManagerFactory.close();

    }

	
}
