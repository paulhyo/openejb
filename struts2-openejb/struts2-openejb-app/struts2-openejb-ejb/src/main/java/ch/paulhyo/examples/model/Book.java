package ch.paulhyo.examples.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
/**
 * @author jasforge
 */
@Entity
@Table(name = "BOOK")
public class Book implements Serializable{
	
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 737836226521709361L;
	
	@Id
	@Column(name = "ISBN")
    private String isbn;
	@Column(name = "NAME")
    private String name;
	@Column(name = "NUMBEROFPAGES")
    private int numberOfPages;
	@ManyToOne(targetEntity = Commande.class)
	@JoinColumn(name = "IDCOMMANDE", insertable = false, updatable = false)
	private Commande commande;
    public Book() {
    }
    public Book(String isbn,String name) {
        this.isbn = isbn;
        this.name = name;
    }
    public Book(String isbn, String name, int numberOfPages) {
        this(isbn,name);
        this.numberOfPages = numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

	@Override
    public String toString() {
        return "com.abien.samples.di.persistence.Book[isbn=" + isbn + "]";
    }
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
}
