package Client;

/**
 * Created by iuliab on 27.10.2015.
 */
import bookModel.Book;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

public class BookSearchClient {
    private Client client;

    public BookSearchClient(){
        client = ClientBuilder.newClient();
    }

    public List<Book> search(String param, List<String> searchValues){
        URI uri = UriBuilder.fromUri("http://localhost:8080/rest")
                .path("search/books")
                .queryParam(param, searchValues)
                .build();

        return null;
    }

}
