package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Activite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String description;
    private String lieu;

    private String horaire;
    @ManyToMany(mappedBy = "activites", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Adherents> adherents = new ArrayList<>();

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "centreSportif_id")
    private CentreSportif centreSportif;

    public Activite() {
    }

    public Activite(String nom, String description, String lieu, String horaire) {
        this.nom = nom;
        this.description = description;
        this.lieu = lieu;
        this.horaire = horaire;
    }

    public Activite(String nom, String description, String lieu, String horaire, CentreSportif centreSportif) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public List<Adherents> getAdherents() {
        return adherents;
    }

    public void setAdherents(List<Adherents> adherents) {
        this.adherents = adherents;
    }

    public CentreSportif getCentreSportif() {
        return centreSportif;
    }

    public void setCentreSportif(CentreSportif centreSportif) {
        this.centreSportif = centreSportif;
    }

    @Override
    public String toString() {
        return "Activite{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", lieu='" + lieu + '\'' +
               // ", adherents=" + adherents +
              //  ", centreSportif=" + centreSportif +
                '}';
    }
}
