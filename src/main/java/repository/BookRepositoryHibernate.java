package repository;

import bookModel.Book;
import bookModel.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * Created by iuliab on 04.11.2015.
 */
@Repository
public class BookRepositoryHibernate {

    //private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistUnit1");
    //@Autowired
    //private EntityManagerFactory emf;
    @PersistenceContext
    //private EntityManager em = emf.createEntityManager();
    private EntityManager em;
    //private EntityTransaction tx = em.getTransaction();

    public BookRepositoryHibernate() {

    }

    public Book createBook(Book book){
        //tx.begin();
        em.persist(book);
        //tx.commit();
        return book;
    }

    public Book findBook(Integer id) {

        System.out.println("Entered book found ");
        Book b = em.find(Book.class, id);
        return b;

    }

    public boolean removeBook(Integer id){

        //tx.begin();
        Book book = em.find(Book.class, id);
        if(book != null) {
            em.remove(book);
            return true;
        }
        return false;
        //tx.commit();
    }

    public Book updateBookPrice(Book newBook, Float percentRaise){

        //tx.begin();
        Book book = em.find(Book.class, newBook.getId());
        if(book != null){
            book.setPrice(book.getPrice() * (1 + percentRaise));
        }
        //tx.commit();

        return book;
    }

    public Book updateBook(Integer id, Book newBook){

        Book book = em.find(Book.class, id);
        if(book != null){
            book.setAuthors(newBook.getAuthors());
            book.setCover(newBook.getCover());
            book.setDate(newBook.getDate());
            book.setDescription(newBook.getDescription());
            book.setISBN(newBook.getISBN());
            book.setLanguage(newBook.getLanguage());
            book.setNumberOfPages(newBook.getNumberOfPages());
            book.setPrice(newBook.getPrice());
            book.setTitle(newBook.getTitle());
            book.setStars(newBook.getStars());
        }

        return book;
    }

    public Long countBooks(){

        Query query = em.createQuery("SELECT COUNT(b) FROM Book b", Long.class);
        Long numberOfBooks = (Long)query.getSingleResult();
        return numberOfBooks;
    }

    public List<Book> queryBooksPrice(Float price){

        TypedQuery<Book> querybooksBelowAPrice = em.createQuery("SELECT b FROM Book b WHERE b.price < :price", Book.class);
        return querybooksBelowAPrice.getResultList();
    }

    public List<Book> queryExpensiveBooks(Float price){

        TypedQuery<Book> queryBooksAboveAPrice = em.createNamedQuery("ExpensiveBooks", Book.class);
        queryBooksAboveAPrice.setParameter("price", price);

        return queryBooksAboveAPrice.getResultList();
    }

    public List<Book> queryBooksWithManyPages(Integer pageNumber){

        TypedQuery<Book> queryBooksManyPages = em.createNamedQuery("ManyPagesBooks", Book.class);
        queryBooksManyPages.setParameter(1, pageNumber);

        return queryBooksManyPages.getResultList();
    }
    //!!!
    public List<Category> findCategoriesForGivenBookId(Integer id) {

        System.out.println("Entered book category found ");
        //TypedQuery<Category> categoriesFound = ("SELECT c FROM Category c WHERE ")
        return null;
    }







}
