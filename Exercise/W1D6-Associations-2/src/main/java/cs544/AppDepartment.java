package cs544;
import java.util.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
public class AppDepartment {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {

        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Department dept1 = new Department("HR");

        Employee emp1 = new Employee("Dolev Fridman",dept1);

        Employee emp2 = new Employee("Devid Beckham", dept1);


        em.persist(emp1);
        em.persist(emp2);

        System.out.println(emp1);

        em.getTransaction().commit();


        em.close();


        em = emf.createEntityManager();

        em.getTransaction().begin();


        TypedQuery<Department> query = em.createQuery("from Department", Department.class);

        List<Department> deptList = query.getResultList();

        for (Department dept : deptList) {

            System.out.println("Department Name =" + dept.getName());
            for (Employee emp : dept.getEmployees()) {
                System.out.println("\t\t Employee Nmae =" + emp.getName());
            }
        }

        em.getTransaction().commit();

        em.close();


    }


}
