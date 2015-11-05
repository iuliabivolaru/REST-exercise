package Client;

import bookModel.Book;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by iuliab on 26.10.2015.
 */
public class BookClient {
    private Client client;

    public BookClient() {
        client = ClientBuilder.newClient();
    }

    public Book get(String id){
        WebTarget target = client.target("http://localhost:8080/rest/");

        //build the response received
        //the path appends on the target created
        //give me a book back and bind it to the book class
        //if i want to receive a json response, i pass in as a parameter to request(MediaType.APPLICATION_JSON)
        //if i want another type of class to be returned, i pass in get(String.class) for example
        //the default is XML
        //if i want to return a list, it doesn`t work like get(List.class)
        //maps and sets have the same issue, we have to use GenericType
        Response response = target.path("books/" + id).request(MediaType.APPLICATION_JSON).get(Response.class);
        if(response.getStatus() != 200){
            throw new RuntimeException(response.getStatus() + ": there was an error on the server");
        }
        System.out.println(response);
        return response.readEntity(Book.class);
    }

    //we dont specify the id
    public List<Book> getList(){
        WebTarget target = client.target("http://localhost:8080/rest/");

        //build the response received
        //the path appends on the target created
        //give me a book back and bind it to the book class
        //if i want to receive a json response, i pass in as a parameter to request(MediaType.APPLICATION_JSON)
        //if i want another type of class to be returned, i pass in get(String.class) for example
        //the default is XML
        //if i want to return a list, it doesn`t work like get(List.class)
        //maps and sets have the same issue, we have to use GenericType
        List response = target.path("books/b").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Book>>() {
        });
        return response;
    }

    public Book create(Book book) {
        WebTarget target = client.target("http://localhost:8080/rest/");
        Response response = target
                .path("books/b")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(book, MediaType.APPLICATION_JSON));
        if(response.getStatus() != 200){
            throw new RuntimeException(response.getStatus() + ": there was an error on the server");
        }
        System.out.println(response);
        return response.readEntity(Book.class);
    }

    public Book update(Book book) {
        WebTarget target = client.target("http://localhost:8080/rest/");
        Response response = target
                .path("books/" + book.getId())
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(book, MediaType.APPLICATION_JSON));
        if(response.getStatus() != 200){
            throw new RuntimeException(response.getStatus() + ": there was an error on the server");
        }
        System.out.println(response);
        return response.readEntity(Book.class);
    }

    public void delete(int bookId) {
        WebTarget target = client.target("http://localhost:8080/rest/");

        Response response = target.path("books/" + bookId).request(MediaType.APPLICATION_JSON).delete();
        if(response.getStatus() != 200){
            throw new RuntimeException(response.getStatus() + ": there was an error on the server");
        }
    }

    //in post we supply an entity to be posted on the server
}
