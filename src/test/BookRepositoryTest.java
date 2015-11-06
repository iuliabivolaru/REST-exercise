import bookModel.Book;
import bookModel.Category;
import repository.BookRepository;
import repository.BookRepositoryStub;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by iuliab on 29.10.2015.
 */

//TODO: package names lowerCase!!
//TODO: no commentaries!!
public class BookRepositoryTest {
    private BookRepository bookRepository;
    private List<Book> books;
    Book book1, book2, book3;

    @Before
    public void setup() {

        bookRepository = new BookRepositoryStub();

        books = new ArrayList<Book>();
        List<Category> categories = new ArrayList<Category>();
        categories.add(Category.SCIENCE);
        book1 = new Book("Software Architecture for Developers", "Simon Brown", categories, "20/05/2013", 200f, "978-1-4028-9462-6", "Technical leadership by coaching, coding", "refactoringBook.jpg", 230, "English", 4);
        book2 = new Book("Refactoring", "Martin Fowler", categories, "25/03/2010", 250f, "978-1-4057-9462-6", "Improving the design of existing code", "softwareArchitectureForDevs.jpg", 280, "English", 4.5f);
        book3 = new Book("Flow", "Martin Fowler", categories, "25/03/2010", 250f, "978-1-4057-9468-6", "Improving the design of existing code", "softwareArchitectureForDevs.jpg", 280, "English", 4.5f);
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
