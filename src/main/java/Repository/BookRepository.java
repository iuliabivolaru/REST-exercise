package Repository;

import BookModel.Book;
import BookModel.ReviewBook;

import java.util.List;

/**
 * Created by iuliab on 23.10.2015.
 */
public interface BookRepository {

    List<Book> findAllBooks();

    List<ReviewBook> findAllReviews();

    Book findBook(String bookId);

    List<Book> getBooks(int start, int end);

    Book create(Book book);

    Book update(Book book, String bookId);

    boolean delete(String bookId);

    int countBooks();
}
