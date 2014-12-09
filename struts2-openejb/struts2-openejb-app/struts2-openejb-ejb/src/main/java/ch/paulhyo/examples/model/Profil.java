package ch.paulhyo.examples.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
/**
 * @author jasforge
 */
@Entity
@Table(name = "PROFIL")
public class Profil implements Serializable{
	
    /**
	 * serialVersionUID
	 */
	
	@Id
	@Column(name = "NOM")
    private String nom;
	@Column(name = "DESCRIPTION")
    private String description;
	@OneToMany(mappedBy = "profil", targetEntity = User.class)
	private List<User> users;
    public Profil() {
    }
    public Profil(String nom,String description) {
        this.nom = nom;
        this.description = description;
    }
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
