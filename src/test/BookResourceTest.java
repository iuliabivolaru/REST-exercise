import bookModel.Book;
import BookResource.BookResource;
import Service.BookService;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Created by iuliab on 28.10.2015.
 */
public class BookResourceTest {

    private BookResource bookResource;
    private BookService bookService;

    @Before
    public void setup(){

        bookService = mock(BookService.class);
        bookResource = new BookResource();
        bookResource.setBookService(bookService);
    }

    @Test
    public void givenBookId_GetById_returnTheCorrectBook(){

        Book book = new Book();

        when(bookService.findBook("1")).thenReturn(book);

        javax.ws.rs.core.Response book1 = bookResource.getBook("1");

        verify(bookService).findBook("1");

    }

    @Test
    public void givenNonExistingBookId_GetById_returnNotFound(){
        Book book = new Book();

        when(bookService.findBook("7")).thenReturn(null);

        javax.ws.rs.core.Response response = bookResource.getBook("7");

        assertThat(response.getEntity()).isEqualTo(book);

    }
}
