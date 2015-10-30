package BookResource;

import BookModel.Book;
import Repository.BookRepository;
import Repository.BookRepositoryStub;
import Service.BookService;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by iuliab on 23.10.2015.
 */

@Path("/books") // http:/localhost:8080/books
public class BookResource {

    private BookService bookService = new BookService();

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    /*@DELETE
    @Path("{bookId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("bookId") String bookId){
        System.out.println(bookId);
        bookRepository.delete(bookId);

        return Response.ok().build();
    }
    @PUT
    @Path("{bookId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response update(@PathParam("bookId") String bookId, Book book){
        System.out.println(book.getId());
        book = bookRepository.update(book);

        return Response.ok().entity(book).build();
    }

    @POST
    @Path("/book") // http:/localhost:8080/books/book
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Book createBook(Book book){
        System.out.println(book.getTitle());
        System.out.println(book.getAuthors());

        bookRepository.create(book);

        return book;
    }
    @POST
    @Path("/book") // http:/localhost:8080/books/book
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Book createBookParams(MultivaluedHashMap<String, String> formParams) {
        System.out.println(formParams.getFirst("title"));
        System.out.println(formParams.getFirst("authors"));

        if(formParams.getFirst("title") == null){
            //return Response.serverError().entity("UUID cannot be blank").build();
        }

        Book book = new Book();
        book.setTitle(formParams.getFirst("title"));
        book.setAuthors(formParams.getFirst("authors"));
        bookRepository.create(book);
        return book;
    }*/

    @GET

    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getAllBooks(){
        System.out.println("sss");
        List<Book> books = bookService.findAllBooks();
        //return bookRepository.findAllBooks();
        if(books == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return  Response.ok().entity(new GenericEntity<List<Book>>(books){}).build();

    }

    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Path("{bookId}")// http:/localhost:8080/books/1
    //grab the id from the params and use it
    public Response getBook(@PathParam("bookId") String bookId){
        System.out.println("Getting book ID:" + bookId);
        //return bookRepository.findBook(bookId);
        if(bookId == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Book book = bookService.findBook(bookId);

        if(book == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok().entity(book).build();
    }

    @GET
    @Produces("images/jpeg")
    @Path("{bookId}/cover")// http:/localhost:8080/books/1
    //grab the id from the params and use it
    //file not found exception
    public Response getCoverImageOfBook(@PathParam("bookId") String bookId) throws FileNotFoundException {

        String cover = "refactoringBook.jpg";
        File file = new File(getClass().getClassLoader().getResource(cover).getFile());
        if (file == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(file).build();
    }

    /*@GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    //grab the id from the params and use it
    public Response getBook(@QueryParam(value = "start") int start,
                            @QueryParam(value = "end") int end,
                            @QueryParam(value = "author") final String author,
                            @QueryParam(value = "title") final String title,
                            @QueryParam(value = "price") List<Double> prices){
        System.out.println("Getting book ID:" + start + " " + end);

       if (author == null && title == null) {
           List<Book> books = bookService.getBooks(start, end);
           return Response.ok().entity(new GenericEntity<List<Book>>(books) {
           }).build();
       }
        System.out.println("Getting book ID:" + author + " " + title);
        Stream<Book> bookStream = bookService.findAllBooks().stream();
        if (author != null) {
            bookStream = bookStream.filter(w -> w.getAuthors().toLowerCase().contains(author.toLowerCase()));
        }
        if (title != null) {
            bookStream = bookStream.filter(w -> w.getTitle().toLowerCase().contains(title.toLowerCase()));
        }
        return Response.ok().entity(new GenericEntity<List<Book>>(bookStream.collect(Collectors.toList())) {}).build();
    }
*/

}

