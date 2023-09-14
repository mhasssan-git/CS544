package cs544;

//import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private long id;
	private Integer id;
	private String title;
	private String ISBN;
	private String author;
	private double price;
	@Temporal(TemporalType.DATE)
	private LocalDate publish_date;
	
	
	public Book() {}
	
	public Book(String title,String ISBN,String author,double price,int year, int month, int day) {
		this.id=id;
		this.title=title;
		this.ISBN=ISBN;
		this.author=author;
		this.price=price;
		this.publish_date=LocalDate.of(year, month, day);
		
	}
	
	
	public Integer getId() {
		return id;
	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(LocalDate publish_date) {
		this.publish_date = publish_date;
	}


}
