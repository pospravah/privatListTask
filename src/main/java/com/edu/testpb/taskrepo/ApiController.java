package com.edu.testpb.taskrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    NoteItemService noteService;

    @GetMapping("/tasklist")
    public List<NoteItem> getTasksList(){
        return noteService.getItemList();
    }

    @GetMapping("/task/{taskId}")
    public  NoteItem getTask(@PathVariable Long taskId){
        NoteItem item = noteService.getItem(taskId);
        if(item == null){
            throw new TaskItemNotFoundException("Task if not found" + taskId );
        }
        return item;
    }

    @PostMapping("/task")
    public NoteItem addTaskItem(@RequestBody NoteItem theItem){
        theItem.setId((long) 0);
        noteService.saveItemToList(theItem);
        return theItem;
    }

    @PutMapping("/task")
    public NoteItem updateTaskItem(@RequestBody NoteItem theItem){
        noteService.saveItemToList(theItem);
        return theItem;
    }

    @DeleteMapping("/task")
    public String deleteTask(@RequestBody NoteItem theItem){
        System.out.println("DELETE Mapping processing " + theItem.getDescription());
        NoteItem item = noteService.findByDescription(theItem.getDescription());
        if(item == null){
            throw new TaskItemNotFoundException("Task if not found" + theItem.getDescription() );
        }
        noteService.deleteItemNote(theItem);
        return "Deleted task id - " + item.getDescription();
    }

}