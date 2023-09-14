package cs544;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.Date;
import java.util.List;

public class BookApp {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Book book1=new Book("Harry Potter and the Sorcerer's Stone","123213123432432","J.K. Rowling",
                29.99,new Date("01/01/1997"));
        em.persist(book1);
        Book book2=new Book("Harry Potter and the Chamber of Secrets","1233123432432","J.K. Rowling",
                29.99,new Date("01/01/1998"));
        em.persist(book2);
        Book book3=new Book("Harry Potter and the Prisoner of Azkaban","123213123432432","J.K. Rowling",
                29.99,new Date("01/01/1997"));
        em.persist(book3);
        em.getTransaction().commit();
        em.close();

em=emf.createEntityManager();
em.getTransaction().begin();
        TypedQuery<Book> query=em.createQuery("from Book",Book.class);
        List<Book> books=query.getResultList();
        for (Book book : books) {
            System.out.println("Title= " + book.getTitle() + ", author= "
                    + book.getAuthor() + ", ISBN= " + book.getISBN());
        }
    }
}
