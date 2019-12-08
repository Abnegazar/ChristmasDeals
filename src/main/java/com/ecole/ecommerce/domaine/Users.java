package com.ecole.ecommerce.domaine;

import javax.persistence.*;

@Entity
@Table(name = "utilisateurs", uniqueConstraints = @UniqueConstraint(columnNames = {"pseudo", "password"}))
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 25, name = "pseudo")
    private String pseudo;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false, name = "role")
    private String role;

    public Users() {
    }

    public Users(String pseudo, String password, String role) {
        this.pseudo = pseudo;
        this.password = password;
        this.role = "standard";
        this.role = role;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
