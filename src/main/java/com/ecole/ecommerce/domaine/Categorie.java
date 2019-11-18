package com.ecole.ecommerce.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

/**
 * permet de renseigner la catégorie à laquelle appartient un produit.
 *
 */
@Entity
@Table(name = "categorie")
public class Categorie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCategorie;

    @Column(name = "nom_categorie", nullable = false, unique = true)
    private String nomCategorie;

    /**
     * Plusieurs produits peuvent appartenir à la même catégorie
     */
    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits;

    @OneToOne
    private Rayon rayon;

    public Categorie() {
    }

    public Categorie(String nomCategorie, Rayon rayon) {
        this.nomCategorie = nomCategorie;
        this.rayon = rayon;
    }

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        this.rayon = rayon;
    }
}
