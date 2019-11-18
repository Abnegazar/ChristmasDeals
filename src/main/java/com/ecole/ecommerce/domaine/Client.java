package com.ecole.ecommerce.domaine;

import javax.persistence.*;

@Entity
@Table(name="client", uniqueConstraints = @UniqueConstraint(columnNames = {"mail", "password"}))
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idClient;

    @Column(name = "nom", length = 50, nullable = false)
    private String nom;

    @Column(name = "prenom", length = 100, nullable = false)
    private String prenom;

    @Column(name = "mail", length = 40, nullable = false)
    private String mail;

    @Column(name = "password", nullable = false)
    private String motDePasse;

    @Column(name = "num_carte_credit")
    private String numCarteCredit;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "tel")
    private String telephone;

    @Column(name = "adresse_livraison")
    private String adresseLivraison;

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
