package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.Commentaires;
import com.ecole.ecommerce.services.CommentairesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentairesResource {

    private final CommentairesService commentairesService;

    public CommentairesResource(CommentairesService commentairesService) {
        this.commentairesService = commentairesService;
    }

    @PostMapping("/commentaire")
    public ResponseEntity<Object> ajouterCommentaire(Commentaires commentaires){
        return new ResponseEntity<>(commentairesService.save(commentaires), HttpStatus.CREATED);
    }
}
