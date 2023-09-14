package cs544;
import java.util.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
public class AppEmployee {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {

        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Employee emp1 = new Employee("Dolev", "Fridman");

        Laptop laptop1 = new Laptop("HP", "Inspiron", emp1);

        Laptop laptop2 = new Laptop("Dell", "2-in-1", emp1);

        //emp1.addLaptop(laptop1);

        //emp1.addLaptop(laptop2);

        //em.persist(emp1);
        em.persist(laptop1);
        em.persist(laptop2);


        System.out.println(emp1);

//        laptop1=em.merge(laptop1);


        em.getTransaction().commit();


        em.close();


        em = emf.createEntityManager();

        em.getTransaction().begin();


        TypedQuery<Employee> query = em.createQuery("from Employee ", Employee.class);

        List<Employee> employeeList = query.getResultList();

        for (Employee emp : employeeList) {

            System.out.println("Employee FirstName =" + emp.getFirstName() + ", Employee LastName=" + emp.getLastName());
            for (Laptop laptop : emp.getLaptopSet()) {
                System.out.println("\t\tLaptop Brand =" + laptop.getBrand() + ", Laptop Type=" + laptop.getType());
            }
        }

        em.getTransaction().commit();

        em.close();


    }


}
