package bookResource;

import bookModel.Book;
import service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.io.*;
import java.net.URI;
import java.util.List;

/**
 * Created by iuliab on 23.10.2015.
 */

@Component
@Path("/books") // http:/localhost:8080/books
public class BookResource {


    private BookService bookService;

    public BookResource(){

    }

    @Autowired
    public BookResource(BookService bookService){
        this.bookService = bookService;
    }

    //@Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @DELETE
    @Path("{bookId}")
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("bookId") String bookId){
        System.out.println(bookId);
        boolean isDeleted = bookService.deleteBookFromDB(Integer.getInteger(bookId));
        if(isDeleted)
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();


    }
    @PUT
    @Path("{bookId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response update(@PathParam("bookId") String bookId, Book book){
        System.out.println(book.getId());
        //book = bookService.update(book, bookId);
        book = bookService.updateWholeBookInDB(Integer.getInteger(bookId), book);

        if(book == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok().entity(book).build();
    }

    @POST
    @Path("/book") // http:/localhost:8080/books/book
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response createBook(Book book, @Context UriInfo uriInfo){

        if(receivedTitleAndIdParametersAreValid(book.getTitle(), String.valueOf(book.getId()))) {
            //bookService.create(book);
            bookService.createBook(book);
        }

        else{

            ErrorBean errorBean = new ErrorBean();
            errorBean.setErrorCode("validation.missing.title");
            return Response.status(Response.Status.BAD_REQUEST).entity(errorBean).build();
        }
        String uri = uriInfo.getAbsolutePath() + "/" + book.getId();

        return Response.ok().location(URI.create(uri)).entity(book).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getAllBooks(){
        System.out.println("sss");
        List<Book> books = bookService.findAllBooks();
        if(books == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return  Response.ok().entity(new GenericEntity<List<Book>>(books){}).build();

    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{bookId}")// http:/localhost:8080/books/1
    //grab the id from the params and use it
    public Response getBook(@PathParam("bookId") String bookId){
        System.out.println("Getting book ID:" + bookId);
        //return bookRepository.findBook(bookId);
        if(bookId == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        //Book book = bookService.findBook(bookId);
        Book book = bookService.findBookFromDB(Integer.parseInt(bookId));
        System.out.println("Book found or not");
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


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("size")
    public Response getBooksSize(){

        int booksSize = bookService.countBooks();

        return Response.ok().entity(booksSize).build();
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
    public boolean receivedTitleAndIdParametersAreValid(String title, String id){

        if(title.isEmpty() || id == null)
            return false;
        return true;
    }

}

