package com.ecole.ecommerce.domaine;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name= "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;

    @Column(name = "date_commande", nullable = false)
    private Date dateCommande;

    @OneToOne
    private Client client;

    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> ligneCommandes;

    public Commande() {
    }

    public Commande(Date dateCommande, Client client) {
        this.dateCommande = dateCommande;
        this.client = client;
    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
