package cs544.service;


import cs544.dao.ICommentDao;
import cs544.entity.Comment;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CommentService{
@Autowired
    private ICommentDao commentDao;
public List<Comment> getAll(){

    return commentDao.findAll();
}
public void addComment(Comment comment){

    commentDao.save(comment);
}
public Comment get(Long id){
    Optional<Comment> comment = commentDao.findById(id);
    return comment.isPresent()? comment.get():null;
}

public void update(long id, Comment comment) {

    Optional<Comment> com = commentDao.findById(id);

    if (com.isPresent()) {
        Comment c = com.get();
        c.setText(comment.getText());
        c.setFont(comment.getFont());
        c.setWordCount(comment.getWordCount());
        c.setPostId(comment.getPostId());
        c.setTimeCommented(comment.getDateCommented());
        c.setTimeCommented(comment.getTimeCommented());
        commentDao.save(c);

    }
}

public void delete(Long id){

    commentDao.deleteById(id);
}
}