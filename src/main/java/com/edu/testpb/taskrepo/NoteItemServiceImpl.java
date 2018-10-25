package com.edu.testpb.taskrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteItemServiceImpl implements NoteItemService {

    private NoteRepository repository;

    @Autowired
    public NoteItemServiceImpl(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<NoteItem> getItemList() {
        return repository.findAll();
    }

    @Override
    public void saveItemToList(NoteItem theItem) {
        repository.save(theItem);
    }

    @Override
    public NoteItem getItem(Long id) {
        Optional<NoteItem> noteItem = repository.findById(id);
        return noteItem.get();
    }

    @Override
    public void deleteItem(Long id) {
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        }

    }

    @Override
    public NoteItem findByDescription(String note){
        List<NoteItem> tasks = repository.findAll();
        return tasks.get(tasks.size()-1);
    }

    @Override
    public void deleteItemNote(NoteItem theItem) {
        List<NoteItem> tasks = repository.findAll();
        String note = theItem.getDescription();
        NoteItem tempItem = findByDescription(note);
        repository.delete(tempItem);
    }
}