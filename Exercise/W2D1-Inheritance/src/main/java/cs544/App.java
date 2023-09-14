package cs544;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args)
    {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();

    }
}
