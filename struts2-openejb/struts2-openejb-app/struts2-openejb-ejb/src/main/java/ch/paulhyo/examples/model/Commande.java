package ch.paulhyo.examples.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
/**
 * @author jasforge
 */
@Entity
@Table(name = "COMMANDE")
public class Commande implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 737836226521709361L;
	
	@Id
	@Column(name = "IDCOMMANDE")
    private String idCommande;
	@Column(name = "PRIX")
    private String prix;
	@Column(name = "LOGIN")
    private String login;
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "LOGIN", insertable = false, updatable = false)
	private User user;
	@OneToMany(mappedBy = "commande", targetEntity = Book.class,cascade=CascadeType.ALL)
	private List<Book> books;
    public Commande() {
    }
    public Commande(String idCommande) {
        this.idCommande = idCommande;
    }
	public String getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(String idCommande) {
		this.idCommande = idCommande;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
}
