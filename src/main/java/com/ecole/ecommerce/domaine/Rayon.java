package com.ecole.ecommerce.domaine;

import javax.persistence.*;

@Entity
@Table(name = "rayon")
public class Rayon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRayon;

    @Column(name = "nom_rayon", nullable = false, unique = true)
    private String nomRayon;

    /**
     * Sur un rayon on pose les produits d'une catégorie donnée
     * On peut créer des rayons sans catégories et les remplir après
     * un rayon à un moment donné ne peut contenir que les produits d'une même catégorie
     */
   @OneToOne
    private Categorie categorie;

    public Rayon() {
    }

    public Rayon(String nomRayon) {
        this.nomRayon = nomRayon;
    }

    public Rayon(String nomRayon, Categorie categorie) {
        this.nomRayon = nomRayon;
        this.categorie = categorie;
    }

    public Long getIdRayon() {
        return idRayon;
    }

    public void setIdRayon(Long idRayon) {
        this.idRayon = idRayon;
    }

    public String getNomRayon() {
        return nomRayon;
    }

    public void setNomRayon(String nomRayon) {
        this.nomRayon = nomRayon;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    /**
     * Fonction pour vider un rayon
     */
    /*public void unCategorized(){
        this.setCategorie(null);
    }*/
}
