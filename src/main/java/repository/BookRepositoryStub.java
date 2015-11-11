package repository;

import bookModel.Book;
import bookModel.Category;
import bookModel.Review;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by iuliab on 23.10.2015.
 */
@Repository
public class BookRepositoryStub implements BookRepository {

    List<Book> books;

    public BookRepositoryStub() {

        books = new ArrayList<Book>();
        List<Category> categories = new ArrayList<Category>();
        categories.add(Category.SCIENCE);
        Book book1 = new Book("Software Architecture for Developers", "Simon Brown", categories, "20/05/2013", 200f, "978-1-4028-9462-6", "Technical leadership by coaching, coding", "path", 230, "English", 4);
        Book book2 = new Book("Refactoring", "Martin Fowler", categories, "25/03/2010", 250f, "978-1-4057-9462-6", "Improving the design of existing code", "path2", 280, "English", 4.5f);
        books.add(book1);
        books.add(book2);
    }

    public List<Book> findAllBooks(){

        return books;
    }

    public List<Book> getBooks(int start, int end) {

        return books.subList(start, end);
    }

    public List<Review> findAllReviews(){

        List<Review> reviews = new ArrayList<>();

        Review review1 = new Review(5, "iuliab", "Software Architecture for Developers", "Technical leadership by coaching, coding", "20/05/2015", 1);
        Review review2 = new Review(6, "geog", "Refactoring", "Improving the design of existing code", "25/07/2015", 2);

        reviews.add(review1);
        reviews.add(review2);

        return reviews;
    }

    public Book findBook(String bookId) {

       return books.stream().filter(b -> b.getId() == Integer.parseInt(bookId)).findFirst().orElse(null);
    }

    @Override
    public void create(Book book) {

        boolean bookAlreadyExists = books.stream().anyMatch(b -> b.getISBN()!= null && b.getISBN().equals(book.getISBN()));

        if(!bookAlreadyExists)
            books.add(book);

    }

    @Override
    public Book update(Book book, String bookId) {

        Book b = findBook(bookId);
        if(b == null)
            return null;

        books.remove(b);
        books.add(book);

        return book;
    }

    @Override
    public boolean delete(String bookId) {

        return books.removeIf(b -> b.getId() == Integer.parseInt(bookId));

    }

    public int countBooks(){

        return books.size();
    }


}