import BookModel.Book;
import BookModel.Category;
import Repository.BookRepository;
import Repository.BookRepositoryStub;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by iuliab on 29.10.2015.
 */
public class BookRepositoryTest {
    private BookRepository bookRepository;
    private List<Book> books;
    Book book1, book2, book3;

    @Before
    public void setup() {

        bookRepository = new BookRepositoryStub();

        books = new ArrayList<Book>();
        book1 = new Book(1, "Software Architecture for Developers", "Simon Brown", Category.SCIENCE, "20/05/2013", 200, "978-1-4028-9462-6", "Technical leadership by coaching, coding", "refactoringBook.jpg", 230, "English", 4);
        book2 = new Book(2, "Refactoring", "Martin Fowler", Category.SCIENCE, "25/03/2010", 250, "978-1-4057-9462-6", "Improving the design of existing code", "softwareArchitectureForDevs.jpg", 280, "English", 4.5f);
        book3 = new Book(3, "Flow", "Martin Fowler", Category.SCIENCE, "25/03/2010", 250, "978-1-4057-9468-6", "Improving the design of existing code", "softwareArchitectureForDevs.jpg", 280, "English", 4.5f);
        books.add(book1);
        books.add(book2);
        books.add(book3);
    }

    @Test
    public void givenABookId_findBookById_returnCorrectBook() {

        Book actualBook = bookRepository.findBook("2");

        assertThat(actualBook.getId()).isEqualTo(2);
    }

    @Test
    public void givenANewBook_createBook_createsTheBook() {

        int bookCountBefore = bookRepository.countBooks();
        bookRepository.create(book3);
        int bookCountAfter = bookRepository.countBooks();
        Book findNewAddedBook = bookRepository.findBook(String.valueOf(book1.getId()));

        assertThat(bookCountAfter).isEqualTo(bookCountBefore + 1);
        assertThat(findNewAddedBook.getTitle()).isEqualTo(book1.getTitle());

    }

    @Test
    public void givenANewBook_updateBook_updateTheBook() {

        Book bookToUpdateWith = book3;
        Book updatedBook = bookRepository.update(bookToUpdateWith, "1");
        assertThat(updatedBook.getTitle()).isEqualTo(bookToUpdateWith.getTitle());

    }

    @Test
    public void givenABook_deleteBook_bookDeleted() {

        int bookCountBefore = bookRepository.countBooks();
        Book bookToDelete = book1;
        bookRepository.delete(String.valueOf(bookToDelete.getId()));
        int bookCountAfter = bookRepository.countBooks();
        Book tryFindDeletedBook = bookRepository.findBook(String.valueOf(bookToDelete.getId()));

        assertThat(bookCountAfter).isEqualTo(bookCountBefore - 1);
        assertThat(tryFindDeletedBook).isEqualTo(null);

    }





}
