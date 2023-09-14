package cs544.dao;

import cs544.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookDao extends JpaRepository<Book,Long> {
}
