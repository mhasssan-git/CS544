package cs544.dao;

import cs544.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentDao extends JpaRepository<Comment,Long> {
}