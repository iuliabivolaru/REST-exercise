import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import repository.BookRepositoryHibernate;
import bookModel.Book;
import bookModel.Category;
import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import spring.AppConfig;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by iuliab on 04.11.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional

public class BookRepositoryHibernateTest {
    @Autowired
    private BookRepositoryHibernate bookRepositoryHibernate;
    Book book1, book2, book3;



    @Before
    public void setup() {

        //bookRepositoryHibernate = new BookRepositoryHibernate();
        List<Category> categories = new ArrayList<Category>();
        categories.add(Category.SCIENCE);
        book1 = new Book("A whole new mind", "Simon Brown", categories, "20/05/2013", 230f, "978-1-4028-9462-6", "Technical leadership by coaching, coding", "aNewMind.jpg", 230, "English", 4);
        book2 = new Book("Pragmatic Programmer", "Hunt Thomas", categories, "25/03/2010", 250f, "978-1-4057-9462-6", "Improving the design of existing code", "pragmatic.jpg", 280, "English", 4.5f);
        book3 = new Book("Flow", "Martin Fowler", categories, "25/03/2010", 250f, "978-1-4057-9468-6", "Improving the design of existing code", "flow.jpg", 270, "English", 4.5f);
    }

    @Test
    public void givenABookId_findBookById_returnCorrectBook() {

        Book actualBook = bookRepositoryHibernate.findBook(1);
        System.out.println("Actual book id:" + actualBook.getId());

        assertThat(actualBook.getId()).isEqualTo(1);
    }

    @Test
    public void givenANewBook_createBook_createsTheBook() {

        Long bookCountBefore = bookRepositoryHibernate.countBooks();
        bookRepositoryHibernate.createBook(book3);
        Long bookCountAfter = bookRepositoryHibernate.countBooks();
        Book findNewAddedBook = bookRepositoryHibernate.findBook(book3.getId());

        assertThat(bookCountAfter).isEqualTo(bookCountBefore + 1);
        assertThat(findNewAddedBook.getTitle()).isEqualTo(book3.getTitle());
        //System.out.println(bookRepositoryHibernate.countBooks());

    }

    @Test
    public void givenABook_deleteBook_bookDeleted() {

        System.out.println(bookRepositoryHibernate.countBooks());
        Long bookCountBefore = bookRepositoryHibernate.countBooks();
        Book bookToDelete = bookRepositoryHibernate.createBook(book3);
        bookRepositoryHibernate.removeBook(bookToDelete.getId());
        Long bookCountAfter = bookRepositoryHibernate.countBooks();
        Book tryFindDeletedBook = bookRepositoryHibernate.findBook(bookToDelete.getId());

        //assertThat(bookCountAfter).isEqualTo(bookCountBefore - 1);
        assertThat(tryFindDeletedBook).isEqualTo(null);

    }

    @Test
    public void givenANewBook_updateBook_updateTheBook() {

        Book bookToUpdate = bookRepositoryHibernate.findBook(1);
        System.out.println("Price update:" + bookToUpdate.getPrice());
        Book updatedBook = bookRepositoryHibernate.updateBookPrice(bookToUpdate, 0.1f);
        System.out.println("Updated price:" + updatedBook.getPrice());
        assertThat(updatedBook.getPrice()).isEqualTo(bookToUpdate.getPrice());

    }

    //!!
    @Test
    public void givenABook_findCategories_retrieveCategories() {

        List<Category> expectedCategories = book3.getCategories();

        Book bookToRetrieveBooksFrom = bookRepositoryHibernate.createBook(book3);

        List<Category> foundCategories = bookToRetrieveBooksFrom.getCategories();

        assertThat(expectedCategories.size()).isEqualTo(foundCategories.size());

    }



}
