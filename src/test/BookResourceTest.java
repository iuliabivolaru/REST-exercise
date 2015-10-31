import BookModel.Book;
import BookResource.BookResource;
import Service.BookService;
import org.junit.Before;
import org.junit.Test;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.*;

/**
 * Created by iuliab on 28.10.2015.
 */
public class BookResourceTest {
    private BookResource bookResource;
    private BookService mockBookService;
    private static final String BOOK_ID = "1";

    @Before
    public void setup(){

        mockBookService = mock(BookService.class);
        bookResource = new BookResource();
        bookResource.setBookService(mockBookService);
    }

    @Test
    public void givenAValidBookId_GetBookById_returnsTheCorrectBook(){

        Book book = new Book();

        when(mockBookService.findBook(BOOK_ID)).thenReturn(book);

        Response response = bookResource.getBook(BOOK_ID);

        verify(mockBookService, times(1)).findBook(BOOK_ID);

        assertThat(response.getEntity()).isEqualTo(book);

    }

    @Test
    public void givenAValidBookId_GetBookById_returns200OK(){

        Book book = new Book();

        when(mockBookService.findBook(BOOK_ID)).thenReturn(book);

        Response response = bookResource.getBook(BOOK_ID);

        verify(mockBookService, times(1)).findBook(BOOK_ID);

        assertThat(response.getStatusInfo()).isEqualTo(Response.Status.OK);

    }

    @Test
    public void givenAWrongBookId_GetBookById_returns404NotFound(){

        when(mockBookService.findBook(BOOK_ID)).thenReturn(null);

        Response response = bookResource.getBook(BOOK_ID);

        verify(mockBookService, times(1)).findBook(BOOK_ID);

        assertThat(response.getStatusInfo()).isEqualTo(Response.Status.NOT_FOUND);
        assertThat(response.getEntity()).isEqualTo(null);

    }

    @Test
    public void getBooksSize_returns200OK(){

        Integer countBooks = 20;

        when(mockBookService.countBooks()).thenReturn(countBooks);

        Response response = bookResource.getBooksSize();

        verify(mockBookService, times(1)).countBooks();

        assertThat(response.getStatusInfo()).isEqualTo(Response.Status.OK);

    }

    @Test
    public void getBooksSize_returnsCorrectBooksSize(){

        Integer countBooks = 20;

        when(mockBookService.countBooks()).thenReturn(countBooks);

        Response response = bookResource.getBooksSize();

        verify(mockBookService, times(1)).countBooks();

        assertThat(response.getEntity()).isEqualTo(countBooks);

    }

    @Test
    public void givenAListOfBooks_findAllBooks_returnCorrectListOfBooks(){

        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book());

        when(mockBookService.findAllBooks()).thenReturn(listOfBooks);

        Response response = bookResource.getAllBooks();

        verify(mockBookService, times(1)).findAllBooks();

        assertThat(response.getEntity()).isEqualTo(listOfBooks);

    }

    @Test
    public void givenAValidBook_createBook_returnCreatedBook(){

        Book book = new Book();
        when(mockBookService.createBook(book)).thenReturn(book);


    }

}
