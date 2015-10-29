import BookModel.Book;
import BookResource.BookResource;
import Repository.BookRepository;
import Repository.BookRepositoryStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.ws.Response;

import static org.mockito.Mockito.*;

/**
 * Created by iuliab on 28.10.2015.
 */
public class BookResourceTest {
    private BookRepository bookRepository;
    private BookResource bookResource;

    @Before
    public void setup(){
        bookRepository = mock(BookRepositoryStub.class);
        bookResource = new BookResource();
        bookResource.setBookRepository(bookRepository);
    }

    @Test
    public void givenBookId_GetById_returnTheCorrectBook(){
        Book book = new Book();

        when(bookRepository.findBook("1")).thenReturn(book);

        javax.ws.rs.core.Response book1 = bookResource.getBook("1");

        verify(bookRepository).findBook("1");

    }

    @Test
    public void givenNonExistingBookId_GetById_returnNotFound(){
        Book book = new Book();

        when(bookRepository.findBook("3")).thenCallRealMethod();

        bookResource.getBook("3");

        verify(bookRepository).findBook("3");
    }
}
