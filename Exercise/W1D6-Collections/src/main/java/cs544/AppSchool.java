package cs544;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AppSchool {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {

        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        School school = new School("Washington Elementary School");

        Student student1 = new Student(1L,"Afsheen","Hassan");

        Student student2 = new Student(2L,"Joshua","Campbell");

        school.addStudent(student1);
        school.addStudent(student2);

        //em.persist(emp1);
        em.persist(school);

        em.getTransaction().commit();


        em.close();


        em = emf.createEntityManager();

        em.getTransaction().begin();


        TypedQuery<School> query = em.createQuery("from School ", School.class);

        List<School> schools = query.getResultList();

        for (School sc : schools) {

            System.out.println("School Name =" + sc.getName() );
            for (Student student : sc.getStudents()) {
                System.out.println("\t\tStudent Id =" + student.getStudentid() + ", First Name="
                        + student.getFirstname()+", Last Name="+student.getLastname());
            }
        }

        em.getTransaction().commit();

        em.close();


    }


}
