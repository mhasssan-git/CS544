package cs544;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AppBook {
	private static EntityManagerFactory emf;

	public static void main(String[] args) throws Exception {
		emf = Persistence.createEntityManagerFactory("cs544");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// String title,String ISBN,String author,double price,Date publish_date

		Book book1 = new Book("Hibernate", "123", "Dolev Fridman", 300.0, 2012, 03, 23);
		em.persist(book1);
		Book book2 = new Book("Spring", "123", "Micheal", 180.9, 2012, 03, 23);
		em.persist(book2);
		Book book3 = new Book("Spring Boot", "123", "Micheal", 223.10, 2012, 03, 23);
		em.persist(book3);
		em.getTransaction().commit();
		em.close();

		// Retrieve all Books

		em = emf.createEntityManager();
		em.getTransaction().begin();

		TypedQuery<Book> query = em.createQuery("from Book", Book.class);
		List<Book> bookList = query.getResultList();
		for (Book book : bookList) {
			System.out.println("Title= " + book.getTitle() + ", ISBN= " + book.getISBN() + ", Author= "
					+ book.getAuthor() + ",price= " + book.getPrice() + ",Publish_date = " + book.getPublish_date());
		}
		em.getTransaction().commit();
		em.close();
		
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		TypedQuery<Book> query1=em.createQuery("from Book", Book.class);
		List<Book> list2=query1.getResultList();

		for (Book b1 : list2) {
		modifyTitleAndPrice(b1,"Farms Of Politics",100);
		break;
		}
		for(Book b2: list2){
		if(!b2.getTitle().equals("Farms Of Politics")){
		em.remove(b2);
		break;
		}
		}
		em.getTransaction().commit();
		em.close();

		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		TypedQuery<Book> query3=em.createQuery("from Book", Book.class);
		List<Book> list3=query3.getResultList();
		
		for (Book b3 : list3) {
		System.out.println("title= " + b3.getTitle() + ", Author= "
		+ b3.getAuthor() + ", price= " + b3.getPrice());
		}
		em.getTransaction().commit();
		em.close();
		
		
	}
	private static void modifyTitleAndPrice(Book book, String title, double price){
		 book.setTitle(title);
		 book.setPrice(price);
		
		}

}
