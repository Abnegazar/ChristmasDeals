package com.ecole.ecommerce.domaine;

import javax.persistence.*;
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
    private Produit produitConcerné;

    public Notes() {
    }

    public Notes(int valeur, Date dateNote, Client auteur, Produit produitConcerné) {
        this.valeur = valeur;
        this.dateNote = dateNote;
        this.auteur = auteur;
        this.produitConcerné = produitConcerné;
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

    public Produit getProduitConcerné() {
        return produitConcerné;
    }

    public void setProduitConcerné(Produit produitConcerné) {
        this.produitConcerné = produitConcerné;
    }

    public Date getDateNote() {
        return dateNote;
    }

    public void setDateNote(Date dateNote) {
        this.dateNote = dateNote;
    }
}
