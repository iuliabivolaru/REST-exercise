import bookResource.BookResource;
import service.BookService;
import bookModel.Book;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by iuliab on 04.11.2015.
 */
public class BookResourceHibernateTest {

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

        when(bookService.findBookFromDB(Integer.parseInt("1"))).thenReturn(book);

        javax.ws.rs.core.Response book1 = bookResource.getBook("1");

        verify(bookService).findBookFromDB(Integer.parseInt("1"));

        assertThat(book1.getEntity()).isEqualTo(book);
    }




}
