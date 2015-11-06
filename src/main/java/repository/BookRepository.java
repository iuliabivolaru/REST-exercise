package repository;

import bookModel.Book;
import bookModel.Review;

import java.util.List;

/**
 * Created by iuliab on 23.10.2015.
 */
public interface BookRepository {

    List<Book> findAllBooks();

    List<Review> findAllReviews();

    Book findBook(String bookId);

    List<Book> getBooks(int start, int end);

    void create(Book book);

    Book update(Book book, String bookId);

    boolean delete(String bookId);

    int countBooks();

   /* List<Review> findAllBookReviews(String bookId);

    Review findReviewById(String bookId, String reviewId);

    boolean deleteBookReview(String bookId, String reviewId);

    Review updateReview(String bookId, String reviewId, Review review);

    Review createReview(String bookId, Review review);*/
}
