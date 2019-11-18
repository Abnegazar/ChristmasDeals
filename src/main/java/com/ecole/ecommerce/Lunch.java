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

    public Lunch(CategorieRepository categorieRepository, RayonRepository rayonRepository, ClientRepository clientRepository, ProduitRepository produitRepository) {
        this.categorieRepository = categorieRepository;
        this.rayonRepository = rayonRepository;
        this.clientRepository = clientRepository;
        this.produitRepository = produitRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Rayon r1 = new Rayon("R-lait");
        Rayon r2 = new Rayon("R-déco");
        Rayon r3 = new Rayon("R-arbre");
        Rayon r4 = new Rayon("R-Jouet");
        rayonRepository.saveAll(Arrays.asList(r1, r2, r3, r4));

        Categorie laits = new Categorie("Produits laitiers", r1);
        Categorie decorations = new Categorie("Décorations", r2);
        Categorie jouets = new Categorie("Jouets", r4);
        Categorie arbres_noel = new Categorie("Arbres de noël", r3);

        categorieRepository.saveAll(Arrays.asList(laits, decorations, arbres_noel));


        clientRepository.save(new Client("PADONOU","Hugues","padonouisidore7@gmail.com", "31557600"));

        produitRepository.save(new Produit("Boule de noel","De magnifiques boules de noël", 850, false, decorations, 500));
        produitRepository.save(new Produit("Sapin", 7000, arbres_noel, 120));
        produitRepository.save(new Produit("Camion de pompier", 12000, jouets, 8));
    }
}
