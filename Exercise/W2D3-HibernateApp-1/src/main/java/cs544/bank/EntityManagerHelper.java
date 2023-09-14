package cs544.bank;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerHelper {
    private static final EntityManagerFactory emf;
    private static final ThreadLocal<EntityManager> threadlocal;
    static {
        emf= Persistence.createEntityManagerFactory("cs544");
        threadlocal=new ThreadLocal<>();
    }
    public  static EntityManager getCurrent()
    {
        EntityManager em=threadlocal.get();
        if(em==null || !em.isOpen())
        {
            em=emf.createEntityManager();
            threadlocal.set(em);
        }
        return  em;
    }
    public static void closeEntityManagerFactory()
    {
        emf.close();
    }
}
