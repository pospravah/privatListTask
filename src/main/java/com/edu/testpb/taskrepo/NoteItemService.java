package com.edu.testpb.taskrepo;

import java.util.List;

public interface NoteItemService {

    public List<NoteItem> getItemList();

    public void saveItemToList(NoteItem theItem);

    public NoteItem getItem(Long id);

    public void deleteItem(Long id);

    public NoteItem findByDescription(String note);

    public void deleteItemNote(NoteItem theItem);

}
