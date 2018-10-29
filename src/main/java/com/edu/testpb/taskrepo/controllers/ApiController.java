package com.edu.testpb.taskrepo.controllers;

import com.edu.testpb.taskrepo.entity.NoteItem;
import com.edu.testpb.taskrepo.services.NoteItemService;
import com.edu.testpb.taskrepo.services.UserService;
import com.edu.testpb.taskrepo.exceptions.TaskItemNotFoundException;
import com.edu.testpb.taskrepo.exceptions.UsersNotFoundException;
import com.edu.testpb.taskrepo.validation.DatesMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

@RestController
//@Validated
@RequestMapping("/api")
public class ApiController {

    @Autowired
    NoteItemService noteService;

    @Autowired
    UserService userService;

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

    @GetMapping(value = "/assigned", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUsersList(){
        Resource resource = new ClassPathResource("data.json");
        String json = "";
        try(InputStream stream = resource.getInputStream()) {
            json = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
        } catch (IOException ioe) {
            throw new UsersNotFoundException(ioe.getMessage(), ioe);
        }
        return json;
    }

    @Transactional
    @DatesMatch
    @PostMapping("/task")
    public NoteItem addTaskItem(@RequestBody NoteItem theItem){
        theItem.setId((long) 0);
        System.out.println("== POST: addTaskItem: " + theItem.toString());
        noteService.saveItemToList(theItem);
        return theItem;
    }

    @PutMapping("/task")
    @Transactional
    public NoteItem updateTaskItem(@RequestBody NoteItem theItem){
        NoteItem item = theItem;
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