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

    public List<Notes> getAllByProductname(String produit){
        return notesRepository.findAllByProduitConcerné(produit);
    }

    public Notes upadate(Notes notes){
        return notesRepository.saveAndFlush(notes);
    }
}
