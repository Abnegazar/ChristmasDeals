package com.ecole.ecommerce.domaine;

import javax.persistence.*;

@Entity
@Table(name = "rayon")
public class Rayon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRayon;

    @Column(name = "nom_rayon", nullable = false, unique = true)
    private String nomRayon;

   /* @OneToOne(mappedBy = "rayon")
    private Categorie categorie;*/

    public Rayon() {
    }

    public Rayon(String nomRayon) {
        this.nomRayon = nomRayon;
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

    /*public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }*/
}
