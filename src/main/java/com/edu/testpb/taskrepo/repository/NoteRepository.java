package com.edu.testpb.taskrepo.repository;

import com.edu.testpb.taskrepo.entity.NoteItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository< NoteItem, Long> {

    @Override
    List<NoteItem> findAll();
}
