package com.ecole.ecommerce.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;

@Entity
@Table(name="client", uniqueConstraints = @UniqueConstraint(columnNames = {"mail", "mot_de_passe"}))
//la paire " mot-de-passe _ email " doit être unique
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom", length = 100)
    private String prenom;

    @Column(name = "mail", length = 40, nullable = false)
    private String mail;

    @Column(name = "mot_de_passe", nullable = false)
    private String motDePasse;

    @Column(name = "num_carte_credit")
    private String numCarteCredit;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "tel")
    private String telephone;

    @Column(name = "adresse_livraison")
    private String adresseLivraison;

    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;

    public Client() {
    }

    public Client(String nom, String prenom, String mail, String motDePasse, String numCarteCredit, String adresse, String telephone, String adresseLivraison) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.motDePasse = motDePasse;
        this.numCarteCredit = numCarteCredit;
        this.adresse = adresse;
        this.telephone = telephone;
        this.adresseLivraison = adresseLivraison;
    }

    public Client(String nom, String prenom, String mail, String motDePasse, String numCarteCredit) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.motDePasse = motDePasse;
        this.numCarteCredit = numCarteCredit;
    }

    public Client(String nom, String prenom, String mail, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.motDePasse = motDePasse;
    }

    public Client(String mail, String motDePasse) {
        this.mail = mail;
        this.motDePasse = motDePasse;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNumCarteCredit() {
        return numCarteCredit;
    }

    public void setNumCarteCredit(String numCarteCredit) {
        this.numCarteCredit = numCarteCredit;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }


}
