package com.ecole.ecommerce;

import com.ecole.ecommerce.domaine.Categorie;
import com.ecole.ecommerce.domaine.Client;
import com.ecole.ecommerce.domaine.Produit;
import com.ecole.ecommerce.domaine.Rayon;
import com.ecole.ecommerce.repository.CategorieRepository;
import com.ecole.ecommerce.repository.ClientRepository;
import com.ecole.ecommerce.repository.ProduitRepository;
import com.ecole.ecommerce.repository.RayonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Lunch implements CommandLineRunner {

    private final CategorieRepository categorieRepository;
    private final RayonRepository rayonRepository;
    private final ClientRepository clientRepository;
    private final ProduitRepository produitRepository;
//    private final UsersRepository usersRepository;

    public Lunch(CategorieRepository categorieRepository, RayonRepository rayonRepository, ClientRepository clientRepository, ProduitRepository produitRepository) {
        this.categorieRepository = categorieRepository;
        this.rayonRepository = rayonRepository;
        this.clientRepository = clientRepository;
        this.produitRepository = produitRepository;
//        this.usersRepository = usersRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Client dansou = new Client("DANSOU","Ernest","enet@hotmail.com", "299792458", "17778216993", "Cotonou-Bénin", "66273712", "Cotonou-Bénin");
        Client padonou = new Client("PADONOU","Hugues","padonouisidore7@gmail.com", "31557600");
        Client bossou = new Client("BOSSOU","Ange", "abnegalem@gmail.com", "AZ#47:Ddg5*", "19883396433");
        Client boan = new Client("boan08@netman.com", "passsss");
        clientRepository.saveAll(Arrays.asList(dansou, padonou, bossou, boan));


        Categorie laits = new Categorie("laits");
        Categorie decorations = new Categorie("deco");
        Categorie jouets = new Categorie("jouets");
        Categorie arbres_noel = new Categorie("Arbres_de_noël");
        categorieRepository.saveAll(Arrays.asList(laits, decorations, arbres_noel, jouets));

        Rayon r1 = new Rayon("R-lait");
        Rayon r2 = new Rayon("R-déco");
        Rayon r3 = new Rayon("R-arbre", arbres_noel);
        Rayon r4 = new Rayon("R-Jouet");
        r1.setCategorie(laits);
        rayonRepository.saveAll(Arrays.asList(r1, r2, r3, r4));


        Produit p1 = (new Produit("Boule de noel", "De magnifiques boules de noël", "une marque quelconque", 850, false, decorations, 500));
        Produit p2 = (new Produit("Quilles", "Des quilles rouges et blancs pour la décoration", "une marque quelconque", 2850, decorations, 52));
        Produit p3 = (new Produit("Sapin", 7000, "SapiNeo", arbres_noel, 120));
        produitRepository.saveAll(Arrays.asList(p1, p2, p3));
/*
        Users admin = new Users("admin", "admin", "admin");
        Users superadmin = new Users("superadmin", "admin", "admin");
        Users stand1 = new Users("user1", "password", "standard");
        Users stand2 = new Users("user2", "user", "standard");
        Users stand3 = new Users("user3", "user", "standard");
        usersRepository.saveAll(Arrays.asList(admin, superadmin, stand1, stand2, stand3));*/
    }
}
