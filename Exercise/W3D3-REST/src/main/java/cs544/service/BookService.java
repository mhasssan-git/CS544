package cs544.service;
import cs544.entity.Book;
import cs544.dao.IBookDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    @Autowired
    private IBookDao bookDao;

    public List<Book> getAll() {
        return bookDao.findAll();
    }

    public void addBook(Book book) {
        bookDao.save(book);
    }

    public Book get(Long id) {
        Optional<Book> book = bookDao.findById(id);
        return book.isPresent() ? book.get() : null;
    }

    public void update(Book book) {
        bookDao.save(book);
    }

    public void delete(Long id) {
        bookDao.deleteById(id);
    }
}
