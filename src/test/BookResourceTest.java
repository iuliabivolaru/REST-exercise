import BookModel.Book;
import BookResource.BookResource;
import Repository.BookRepository;
import Repository.BookRepositoryStub;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by iuliab on 28.10.2015.
 */
public class BookResourceTest {
    private BookRepository bookRepository;
    private BookResource bookResource;

    @Before
    public void setup(){
        bookRepository = Mockito.mock(BookRepositoryStub.class);
        bookResource = new BookResource();
        bookResource.setBookRepository(bookRepository);
    }

    @Test
    public void givenBookId_GetById_returnTheCorrectBook(){
        Book book = new Book();

        Mockito.when(bookRepository.findBook("1")).thenReturn(book);

        bookResource.getBook("1");

        Mockito.verify(bookRepository).findBook("1");
    }
}
