package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.Commentaires;
import com.ecole.ecommerce.services.CommentairesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentairesResource {

    private final CommentairesService commentairesService;

    public CommentairesResource(CommentairesService commentairesService) {
        this.commentairesService = commentairesService;
    }

    @PostMapping("/commentaire")
    public ResponseEntity<Object> ajouterCommentaire(@RequestBody Commentaires commentaires){
        return new ResponseEntity<>(commentairesService.save(commentaires), HttpStatus.CREATED);
    }

    @GetMapping("/exist-comm-prod/{produit}")
    public boolean existCommentaireParProduit(@PathVariable("produit") String produit){
        return commentairesService.existProduit(produit);
    }

    @GetMapping("/exist-comm-auteur/{auteur}")
    public boolean existCommentaireParAuteur(@PathVariable("auteur") String auteur){
        return commentairesService.existAuteur(auteur);
    }

    @GetMapping("/exist-comm-auteurprod/{auteur}/{produit}")
    public boolean existCommentaireAuteurParProduit(@PathVariable("auteur") String auteur, @PathVariable("produit") String produit){
        return commentairesService.existAuteurProduit(auteur, produit);
    }

    @GetMapping("/commentaires-auteur/{auteur}")
    public ResponseEntity<Object> commentaireAuteur(@PathVariable("auteur") String auteur){
        if(existCommentaireParAuteur(auteur)){
            return new ResponseEntity<>(commentairesService.getAllByAuteur(auteur), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>("Ce auteur n'a commenter aucun produit.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/commentaires-produit/{produiConcerne}")
    public ResponseEntity<Object> commentaireDuProduit(@PathVariable("produiConcerne") String produiConcerne){
        if(existCommentaireParProduit(produiConcerne)){
            return new ResponseEntity<>(commentairesService.getAllByProduit(produiConcerne), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>("Ce produit n'a jamais été commenter.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/commentaires-auteur/{auteur}/{produit}")
    public ResponseEntity<Object> commentaireAuteurProduit(@PathVariable("auteur") String auteur, @PathVariable("produit") String produit){
        if(existCommentaireAuteurParProduit(auteur, produit)){
            return new ResponseEntity<>(commentairesService.getAllByAuteurAndProduitConcerne(auteur, produit), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>("Ce auteur n'a pas commenter ce produit.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nb-comm-prod/{produit}")
    public Long nbCommentaireParProduit(@PathVariable("produit") String produit){
        return commentairesService.countProduit(produit);
    }

    @GetMapping("/nb-comm-auteurprod/{auteur}/{produit}")
    public Long nbCommentaireAuteurParProduit(@PathVariable("auteur") String auteur, @PathVariable("produit") String produit){
        return commentairesService.countAuteurProduit(auteur, produit);
    }

    @DeleteMapping("/commentaire/{auteur}/{produit}")
    public void supprimerComAuteurSurProduit(@PathVariable("auteur") String auteur, @PathVariable("produit") String produit){
        commentairesService.deleteAuteurProduit(auteur, produit);
    }

}
