package cs544;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AppPassenger {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {

        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Passenger passenger1 = new Passenger("Dolev Fridman");

        Flight flight1 = new Flight("A001","Dhaka","Chicago",new Date("10/12/2023"));

        Flight flight2 = new Flight("A002","Dhaka","Dallas",new Date("9/12/2023"));

        passenger1.addFlight(flight1);
        passenger1.addFlight(flight2);

        //em.persist(emp1);
        em.persist(passenger1);

        em.getTransaction().commit();


        em.close();


        em = emf.createEntityManager();

        em.getTransaction().begin();


        TypedQuery<Passenger> query = em.createQuery("from Passenger ", Passenger.class);

        List<Passenger> passengers = query.getResultList();

        for (Passenger passenger : passengers) {

            System.out.println("Passenger Name =" + passenger.getName() );
            for (Flight flight : passenger.getFlights()) {
                System.out.println("\t\tFlightNumber =" + flight.getFlightnumber() + ", From="
                        + flight.getFrom()+", To="+flight.getTo()+", Date="+new SimpleDateFormat("dd/MMM/YYYY")
                        .format(flight.getDate()));
            }
        }

        em.getTransaction().commit();

        em.close();


    }


}
