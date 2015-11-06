package service;

import bookModel.Book;
import repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BookRepositoryHibernate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by iuliab on 29.10.2015.
 */
@Service("bookService")
@Transactional
public class BookService {

    private BookRepository bookRepository;
    @Autowired
    private BookRepositoryHibernate bookRepositoryHibernate;

    public BookService(){

    }

    @Autowired
    public BookService(BookRepository bookRepository){
        System.out.println("Constructor injection!");
        this.bookRepository = bookRepository;
    }

    //@Autowired
    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void createBook(Book book){

        bookRepository.create(book);
    }

    public Book findBook(String bookId){

        return bookRepository.findBook(bookId);
    }

    public List<Book> findAllBooks(){

        return bookRepository.findAllBooks();
    }

    public List<Book> getBooks(int start, int end){

        return bookRepository.getBooks(start, end);
    }

    public void create(Book book){

        bookRepository.create(book);
    }

    public Book update(Book book, String bookId){

        return bookRepository.update(book, bookId);
    }

    public boolean delete(String bookId){

        return bookRepository.delete(bookId);
    }

    public int countBooks(){

        return bookRepository.countBooks();
    }

    public Book findBookFromDB(Integer id){

        return bookRepositoryHibernate.findBook(id);
    }

    public Book updateBookPriceInDB(Book newBook, Float percentRaise){

        return bookRepositoryHibernate.updateBookPrice(newBook, percentRaise);
    }

    public Book updateWholeBookInDB(Integer id, Book newBook){

        return bookRepositoryHibernate.updateBook(id,newBook);
    }

    public boolean deleteBookFromDB(Integer bookId){

        return bookRepositoryHibernate.removeBook(bookId);
    }

}
