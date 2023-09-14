package myPost.controllers;

import myPost.dto.PostDto;
import myPost.entity.Post;
import myPost.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;


    @GetMapping(value="/post")
    public List<PostDto> getAll(){
        List<Post> posts= postService.getAllPosts();
        List<PostDto> postDtos=new ArrayList<>();
        PostDto postDto;
        for (Post p : posts)
        {
            postDto=new PostDto(p.getId(),p.getTitle(),p.getAuthor(),p.getContent(),p.getDatePosted(),p.getTime());
            postDtos.add(postDto);
        }
        return  postDtos;
    }
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value="/post/{id}")
    public void delete(@PathVariable Long id){
        postService.delete(id);
    }

    @GetMapping(value = "/post/{id}", produces = "application/json")
    public PostDto get(@PathVariable Long id){
        Post post=postService.getPost(id);
        PostDto postDto=new PostDto(post.getId(),post.getTitle(),post.getAuthor(),post.getContent(),post.getDatePosted(),post.getTime());
        return postDto;
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value="/post/{id}", consumes="application/json")
    public void update(@PathVariable Long id, @RequestBody Post post){
        if(id!=post.getId())
            throw new IllegalArgumentException();
        postService.update(post);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value="/post", consumes="application/json")
    public RedirectView add(@RequestBody Post post){
        postService.add(post);
        return  new RedirectView("/post");
    }
}
