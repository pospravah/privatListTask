package com.edu.testpb.taskrepo;

import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository< NoteItem, Long> {

}
