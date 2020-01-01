package com.ecole.ecommerce.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "notes")
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valeur")
    private int valeur;

    @Column(name = "date_note")
    private Date dateNote;

    @OneToOne
    private Client auteur;

    @ManyToOne
    private Produit produitConcerne;

    public Notes() {
    }

    public Notes(int valeur, Date dateNote, Client auteur, Produit produitConcerne) {
        this.valeur = valeur;
        this.dateNote = dateNote;
        this.auteur = auteur;
        this.produitConcerne = produitConcerne;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Client getAuteur() {
        return auteur;
    }

    public void setAuteur(Client auteur) {
        this.auteur = auteur;
    }

    public Produit getProduitConcerne() {
        return produitConcerne;
    }

    public void setProduitConcerne(Produit produitConcerne) {
        this.produitConcerne = produitConcerne;
    }

    public Date getDateNote() {
        return dateNote;
    }

    public void setDateNote(Date dateNote) {
        this.dateNote = dateNote;
    }
}
