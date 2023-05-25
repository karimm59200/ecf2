package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CentreSportif {
    @Id
    @GeneratedValue (strategy = javax.persistence.GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String adresse;

    @OneToMany(mappedBy = "centreSportif", fetch = FetchType.LAZY)
    private List<Activite> activites = new ArrayList<>();

    public CentreSportif() {
    }

    public CentreSportif(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    public CentreSportif(String nom, String adresse, List<Activite> activites) {
        this.nom = nom;
        this.adresse = adresse;
        this.activites = activites;
    }

    public CentreSportif(int id, String nom, String adresse, List<Activite> activites) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.activites = activites;
    }

    public CentreSportif(String nom, String description, String lieu, String horaire) {
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Activite> getActivites() {
        return activites;
    }

    public void setActivites(List<Activite> activites) {
        this.activites = activites;
    }

    @Override
    public String toString() {
        return "CentreSportif{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", activites=" + activites +
                '}';
    }
}
