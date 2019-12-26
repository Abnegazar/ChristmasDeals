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

    public Commentaires update(Commentaires commentaires){
        return commentairesRepository.saveAndFlush(commentaires);
    }

}
