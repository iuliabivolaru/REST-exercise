import BookModel.Book;
import Client.BookClient;
import org.junit.Test;
//it has to be manually added
import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by iuliab on 26.10.2015.
 */
public class BookClientTest {
    @Test
    public void testDelete(){
        BookClient client = new BookClient();
        client.delete(1);
    }
    @Test
    public void testPut(){
        Book book = new Book();
        book.setId(1234);
        book.setTitle("Pragmatic programmer");
        book.setAuthors("Martin Fowler");

        BookClient client = new BookClient();
        book = client.update(book);

        assertNotNull(book);
    }

    @Test
    public void testGet(){
        BookClient client = new BookClient();

        Book book = client.get("1");

        System.out.println(book);

        assertNotNull(book);
    }

    @Test
    public void testGetList(){
        BookClient client = new BookClient();

        List books = client.getList();

        System.out.println(books);

        assertNotNull(books);
    }

    @Test(expected=RuntimeException.class)
    public void testGetWithBadRequest() {
        BookClient client = new BookClient();

        client.get("2");
    }

    @Test(expected=RuntimeException.class)
    public void testGetWithNotFound() {
        BookClient client = new BookClient();

        client.get("7777");
    }

    public void testCreate(){
        BookClient client = new BookClient();

        Book book = new Book();
        book.setTitle("Pragmatic programmer");
        book.setAuthors("Martin Fowler");

        book = client.create(book);

        assertNotNull(book);
    }
}
