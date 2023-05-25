package org.example.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private int id;
    private String contenu;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    private int note;


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="produit_id")
    private Produit produit;

    public Commentaire() {
    }

    public Commentaire(String contenu, Date date, int note) {
        this.contenu = contenu;
        this.date = date;
        this.note = note;
    }

    public Commentaire(String contenu, Date date, int note, Produit produit) {
        this.contenu = contenu;
        this.date = date;
        this.note = note;
        this.produit = produit;
    }

    public Commentaire(int id, String contenu, Date date, int note, Produit produit) {
        this.id = id;
        this.contenu = contenu;
        this.date = date;
        this.note = note;
        this.produit = produit;
    }

    public Commentaire(String commentaire) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Commentaire{" +
                "id=" + id +
                ", contenu='" + contenu + '\'' +
                ", date=" + date +
                ", note=" + note +
                ", produit=" + produit +
                '}';
    }
}
