package com.edu.testpb.taskrepo.services;

import com.edu.testpb.taskrepo.entity.NoteItem;
import com.edu.testpb.taskrepo.validation.DatesMatch;
import com.edu.testpb.taskrepo.validation.UserPerDatesMatch;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface NoteItemService {

    public List<NoteItem> getItemList();

    @UserPerDatesMatch
    @DatesMatch
    public void saveItemToList( NoteItem theItem);

    public NoteItem getItem(Long id);

    public void deleteItem(Long id);

    public NoteItem findByDescription(String note);

    public void deleteItemNote(NoteItem theItem);

}
