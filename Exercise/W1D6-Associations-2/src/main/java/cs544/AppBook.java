package cs544;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AppBook {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {

        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Publisher publisher = new Publisher("Oxford");

        Book book1 = new Book("Harry Potter and the Sorcerer's Stone"," J.K. Rowling ",publisher);

        Book book2 = new Book("Harry Potter and the Chamber of Secrets"," J.K. Rowling ",null);



        em.persist(book1);
        em.persist(book2);

        em.getTransaction().commit();


        em.close();


        em = emf.createEntityManager();

        em.getTransaction().begin();


        TypedQuery<Book> query = em.createQuery("from Book", Book.class);

        List<Book> books = query.getResultList();

        for (Book book : books) {

            System.out.println("Book Name =" + book.getTitle()+", Author Name="+book.getAuthor()
            +", Publisher Name="+(book.getPublisher()!=null?book.getPublisher().getName():"N/A")
            );


        }

        em.getTransaction().commit();

        em.close();


    }


}
