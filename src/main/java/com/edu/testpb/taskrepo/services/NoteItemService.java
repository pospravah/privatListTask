package com.edu.testpb.taskrepo.services;

import com.edu.testpb.taskrepo.entity.NoteItem;
import com.edu.testpb.taskrepo.validation.DatesMatch;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface NoteItemService {

    public List<NoteItem> getItemList();

    @DatesMatch
    public void saveItemToList( NoteItem theItem);

    public NoteItem getItem(Long id);

    public void deleteItem(Long id);

    public NoteItem findByDescription(String note);

    public void deleteItemNote(NoteItem theItem);

}
