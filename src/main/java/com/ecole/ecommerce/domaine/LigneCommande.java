package com.ecole.ecommerce.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ligne_commande")
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;

    @OneToOne
    private Produit produit;

    @OneToOne
    private Commande commande;

    @Column(name = "quantite")
    private Long quantite;

    public LigneCommande() {
    }

    public LigneCommande(Produit produit, Commande commande, Long quantite) {
        this.produit = produit;
        this.commande = commande;
        this.quantite = quantite;
    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Long getQuantite() {
        return quantite;

    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }
}
