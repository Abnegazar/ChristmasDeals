package com.ecole.ecommerce.services;

import com.ecole.ecommerce.domaine.Commentaires;
import com.ecole.ecommerce.repository.CommentairesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentairesService {

    private final CommentairesRepository commentairesRepository;

    public CommentairesService(CommentairesRepository commentairesRepository) {
        this.commentairesRepository = commentairesRepository;
    }

    public Commentaires save(Commentaires commentaires){
        return commentairesRepository.save(commentaires);
    }

    public List<Commentaires> getAllByProduit(String nomProduit){
        return commentairesRepository.findAllByProduitConcerne(nomProduit);
    }

    public List<Commentaires> getAllByAuteur(String auteur){
        return commentairesRepository.findAllByAuteur(auteur);
    }

    public List<Commentaires> getAllByAuteurAndProduitConcerne(String auteur, String nomProduit){
        return commentairesRepository.findAllByAuteurAndProduitConcerne(auteur, nomProduit);
    }

    public Long countProduit(String auteur){
        return commentairesRepository.countAllByProduitConcerne(auteur);
    }

    public Long countAuteurProduit(String auteur, String produitConcerne){
        return commentairesRepository.countAllByAuteurAndProduitConcerne(auteur, produitConcerne);
    }

    public boolean existProduit(String produitConcerne){
        return commentairesRepository.existsByProduitConcerne(produitConcerne);
    }

    public boolean existAuteur(String auteur){
        return commentairesRepository.existsByAuteur(auteur);
    }

    public boolean existAuteurProduit(String auteur, String produitConcerne){
        return commentairesRepository.existsByAuteurAndProduitConcerne(auteur, produitConcerne);
    }

    public void deleteAuteurProduit(String auteur, String produitConcerne){
        commentairesRepository.deleteAllByAuteurAndProduitConcerne(auteur, produitConcerne);
    }

}
