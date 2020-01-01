package com.ecole.ecommerce.web;

import com.ecole.ecommerce.domaine.Notes;
import com.ecole.ecommerce.services.NotesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotesResource {

    private final NotesService notesService;

    public NotesResource(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping("/notes")
    public ResponseEntity<Object> noter(@RequestBody Notes notes){
        return new ResponseEntity<>(notesService.save(notes), HttpStatus.CREATED);
    }

    @GetMapping("/exist-notes-prod/{produit}")
    public boolean existNotesParProduit(@PathVariable("produit") String produit){
        return notesService.existProduit(produit);
    }

    @GetMapping("/exist-notes-auteurprod/{auteur}/{produit}")
    public boolean existNotesAuteurParProduit(@PathVariable("auteur") String auteur, @PathVariable("produit") String produit){
        return notesService.existAuteurProduit(auteur, produit);
    }

    @GetMapping("/notes-produit/{produiConcerne}")
    public ResponseEntity<Object> noteProduit(@PathVariable("produiConcerne") String produiConcerne){
        if(existNotesParProduit(produiConcerne)){
            return new ResponseEntity<>(notesService.getAllByProduit(produiConcerne), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>("Ce produit n'a jamais été noter.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/notes-auteur/{auteur}/{produit}")
    public ResponseEntity<Object> notesAuteurProduit(@PathVariable("auteur") String auteur, @PathVariable("produit") String produit){
        if(existNotesAuteurParProduit(auteur, produit)){
            return new ResponseEntity<>(notesService.getByAuteurAndProduitConcerne(auteur, produit), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>("Ce auteur n'a pas noter ce produit.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nb-notes-prod/{produit}")
    public Long nbNotesParProduit(@PathVariable("produit") String produit){
        return notesService.countProduit(produit);
    }

    @PutMapping("/notes/{auteur}/{produit}")
    public ResponseEntity<Object> update(@RequestBody Notes notes, @PathVariable("auteur") String auteur, @PathVariable("produit") String produit){
        if (existNotesAuteurParProduit(auteur, produit)){
            return new ResponseEntity<>(notesService.updates(notes), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Ce produit n'a pas été noter par ce auteur.", HttpStatus.OK);
        }
    }

    @DeleteMapping("/notes/{auteur}/{produit}")
    public void supprimerNotesAuteurSurProduit(@PathVariable("auteur") String auteur, @PathVariable("produit") String produit){
        notesService.deleteAuteurProduit(auteur, produit);
    }
}
