package Spring;


import Repository.BookRepository;
import Repository.BookRepositoryStub;
import Service.BookService;
import BookResource.BookResource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by iuliab on 30.10.2015.
 */
@Configuration
@ComponentScan({"BookResource", "Repository", "Service"})
public class AppConfig {

//    @Bean(name = "bookService")
//    public BookService getBookService(){
//        //constructor injection
//        return new BookService(getBookRepository());
//        //setter injection
//        //BookService bookService = new BookService();
//        //bookService.setBookRepository(getBookRepository());
//        //return bookService;
//    }
//
//    @Bean(name = "bookRepository")
//    public BookRepository getBookRepository(){
//        return new BookRepositoryStub();
//    }


}
