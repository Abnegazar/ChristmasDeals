package com.ecole.ecommerce.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "commentaires")
public class Commentaires {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contenu", nullable = false)
    private String Contenu;

    @Column(name = "date_commentaire")
    private Date dateCommentaire;

    @ManyToOne
    private Client auteur;

    @ManyToOne
    private Produit produitConcerne;

    public Commentaires() {
    }

    public Commentaires(String contenu, Client auteur, Produit produitConcerne) {
        Contenu = contenu;
        this.auteur = auteur;
        this.produitConcerne = produitConcerne;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String contenu) {
        Contenu = contenu;
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

    public Date getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(Date dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }
}
