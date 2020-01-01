package com.ecole.ecommerce.services;

import com.ecole.ecommerce.domaine.Notes;
import com.ecole.ecommerce.repository.NotesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    private final NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public Notes save(Notes notes){
        return notesRepository.save(notes);
    }

    public List<Notes> getAllByProduit(String nomProduit){
        return notesRepository.findAllByProduitConcerne(nomProduit);
    }

    public Notes getByAuteurAndProduitConcerne(String auteur, String nomProduit){
        return notesRepository.findByAuteurAndProduitConcerne(auteur, nomProduit);
    }

    public Long countProduit(String auteur){
        return notesRepository.countAllByProduitConcerne(auteur);
    }

    public boolean existProduit(String produitConcerne){
        return notesRepository.existsByProduitConcerne(produitConcerne);
    }

    public boolean existAuteurProduit(String auteur, String produitConcerne){
        return notesRepository.existsByAuteurAndProduitConcerne(auteur, produitConcerne);
    }

    public Notes updates(Notes notes){
        return notesRepository.saveAndFlush(notes);
    }

    public void deleteAuteurProduit(String auteur, String produitConcerne){
        notesRepository.deleteByAuteurAndProduitConcerne(auteur, produitConcerne);
    }

}
