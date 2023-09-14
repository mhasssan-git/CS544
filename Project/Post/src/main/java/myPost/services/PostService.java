package myPost.services;

import myPost.dao.IPostDao;
import myPost.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostService {
    @Autowired
    private IPostDao postDao;

    public Post getPost(Long id){
        Optional<Post> post=postDao.findById(id);
        return post.isPresent() ? post.get():null;
    }
    public List<Post> getAllPosts(){
        return postDao.findAll();
    }
    public void add(Post post){
        postDao.save(post);
    }
    public void delete(Long id){
        postDao.deleteById(id);
    }
    public void update(Post post){
        postDao.save(post);
    }
}
