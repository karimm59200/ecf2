package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Adherents {
    @Id
    @GeneratedValue  (strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date dateDeNaissance;
    @ManyToMany (cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "adherent_activite",
            joinColumns = @JoinColumn(name = "adherent_id"),
            inverseJoinColumns = @JoinColumn(name = "activite_id"))
    private List<Activite> activites = new ArrayList<>();

    public Adherents() {
    }

    public Adherents(String nom, String prenom, Date dateDeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
    }

    public Adherents(String nom, String prenom, Date dateDeNaissance, List<Activite> activites) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.activites = activites;
    }

    public Adherents(int id, String nom, String prenom, Date dateDeNaissance, List<Activite> activites) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.activites = activites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public List<Activite> getActivites() {
        return activites;
    }

    public void setActivites(List<Activite> activites) {
        this.activites = activites;
    }






    @Override
    public String toString() {
        return "Adherents{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateDeNaissance=" + dateDeNaissance +
                ", activites=" + activites +
                '}';
    }


}
