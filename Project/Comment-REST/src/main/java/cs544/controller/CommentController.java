package cs544.controller;

import cs544.entity.Comment;
import cs544.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class CommentController{
    @Autowired
    private CommentService commentService;
    @GetMapping(value = "/comments",produces="application/json")
    public List<Comment> getAll(){
        return  commentService.getAll();
    }

    @GetMapping(value="/comments/{id}",produces="application/json")
    public Comment get(@PathVariable Long id){
        return commentService.get(id);
    }

    @PostMapping(value="/comments", consumes = "application/json")
    public RedirectView post(@RequestBody Comment comment){
        commentService.addComment(comment);
        return new RedirectView("/comments");

    }
    @PutMapping(value="/comments/{id}",consumes = "application/json")
    public void update(@PathVariable Long id ,@RequestBody Comment comment){
        if(id!=comment.getId())throw new IllegalArgumentException();
        commentService.update(id,comment);
    }
    @DeleteMapping(value="/comments/{id}")
    public void delete(@PathVariable Long id){
        commentService.delete(id);
    }



}