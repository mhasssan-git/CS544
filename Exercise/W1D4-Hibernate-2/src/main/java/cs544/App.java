package cs544;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all cars
        TypedQuery<Students> query = em.createQuery("from cs544.Students ", Students.class);
        List<Students> studentsList = query.getResultList();
        for (Students student : studentsList) {
            System.out.println("Student Name= " + student.getName());
        }
        ;
        if (!studentsList.stream().filter(x -> x.getName().equals("New guy")).findFirst().isPresent()) {
            Students newGuy = new Students(567, "New guy", "newguye@fox.com", "testxyz");
            em.persist(newGuy);
        }
        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all cars
        TypedQuery<Students> studentQuery = em.createQuery("from cs544.Students ", Students.class);
        List<Students> studentsList1 = studentQuery.getResultList();
        for (Students student : studentsList1) {
            System.out.println("Student Name= " + student.getName());
        }
        em.getTransaction().commit();
        em.close();
    }
}
