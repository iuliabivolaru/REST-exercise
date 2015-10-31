package Repository;

import BookModel.Book;
import BookModel.Category;
import BookModel.ReviewBook;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iuliab on 23.10.2015.
 */
@Repository("bookRepository")
public class BookRepositoryStub implements BookRepository {

    List<Book> books;

    public BookRepositoryStub() {

        books = new ArrayList<Book>();
        Book book1 = new Book(1, "Software Architecture for Developers", "Simon Brown", Category.SCIENCE, "20/05/2013", 200, "978-1-4028-9462-6", "Technical leadership by coaching, coding", "path", 230, "English", 4);
        Book book2 = new Book(2, "Refactoring", "Martin Fowler", Category.SCIENCE, "25/03/2010", 250, "978-1-4057-9462-6", "Improving the design of existing code", "path2", 280, "English", 4.5f);
        books.add(book1);
        books.add(book2);
    }

    public List<Book> findAllBooks(){

        return books;
    }

    public List<Book> getBooks(int start, int end) {

        return books.subList(start, end);
    }

    public List<ReviewBook> findAllReviews(){

        List<ReviewBook> reviews = new ArrayList<>();

        ReviewBook review1 = new ReviewBook(5, "iuliab", "Software Architecture for Developers", "Technical leadership by coaching, coding", "20/05/2015", 1);
        ReviewBook review2 = new ReviewBook(6, "geog", "Refactoring", "Improving the design of existing code", "25/07/2015", 2);

        reviews.add(review1);
        reviews.add(review2);

        return reviews;
    }

    public Book findBook(String bookId) {

       return books.stream().filter(b -> b.getId() == Integer.parseInt(bookId)).findFirst().orElse(null);
    }

    @Override
    public Book create(Book book) {

        boolean bookAlreadyExists = books.stream().anyMatch(b -> b.getISBN()!= null && b.getISBN().equals(book.getISBN()));

        if(!bookAlreadyExists)
            books.add(book);

        return book;

    }

    @Override
    public Book update(Book book, String bookId) {
        //search the DB to see if we gave already a book with that id
        //select * from books where id = ?
        //if rs size == 0
        //insert into Book table
        //else
        //update the book
        Book b = findBook(bookId);
        if(b == null)
            return null;

        books.remove(b);
        books.add(book);

        return book;
    }

    @Override
    public boolean delete(String bookId) {
        //delete from book where bookId = ?
        return books.removeIf(b -> b.getId() == Integer.parseInt(bookId));

    }

    public int countBooks(){

        return books.size();
    }


}
