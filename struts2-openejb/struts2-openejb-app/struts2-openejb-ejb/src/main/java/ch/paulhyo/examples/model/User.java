package ch.paulhyo.examples.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements Serializable{
	
    /**
	 * serialVersionUID
	 */
	
	@Id
	@Column(name = "LOGIN")
    private String login;
	@Column(name = "PASSWORD")
    private String password;
	@Column(name = "NOM")
    private String nom;
	@ManyToOne(targetEntity = Profil.class)
	@JoinColumn(name = "NOM", insertable = false, updatable = false)
	private Profil profil;
	@OneToMany(mappedBy = "user", targetEntity = Commande.class)
	private List<Commande> commandes;

    public User() {
    }
    public User(String login,String password) {
        this.login = login;
        this.password = password;
    }
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}	
}