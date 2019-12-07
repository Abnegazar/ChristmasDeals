package com.ecole.ecommerce;

import com.ecole.ecommerce.domaine.*;
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

    public Lunch(CategorieRepository categorieRepository, RayonRepository rayonRepository, ClientRepository clientRepository, ProduitRepository produitRepository) {
        this.categorieRepository = categorieRepository;
        this.rayonRepository = rayonRepository;
        this.clientRepository = clientRepository;
        this.produitRepository = produitRepository;
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
        //r1.unCategorized();


        Produit p1 = (new Produit("Boule de noel", "De magnifiques boules de noël", "une marque quelconque", 850, false, decorations, 500));
        Produit p2 = (new Produit("Quilles", "Des quilles rouges et blancs pour la décoration", "une marque quelconque", 2850, decorations, 52));
        Produit p3 = (new Produit("Sapin", 7000, "SapiNeo", arbres_noel, 120));
        produitRepository.saveAll(Arrays.asList(p1, p2, p3));
    }
}
