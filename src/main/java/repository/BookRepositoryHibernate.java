package repository;

import bookModel.Book;
import bookModel.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.File;
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

        em.persist(book);
        return book;
    }

    public Book findBook(Integer id) {

        System.out.println("Entered book found ");
        Book b = em.find(Book.class, id);
        return b;

    }

    public List<Book> findAllBooksFromDB(){

         TypedQuery<Book> queryAllBooks = em.createNamedQuery("AllBooks", Book.class);
         return queryAllBooks.getResultList();
    }

    public boolean removeBook(Integer id){

        Book book = em.find(Book.class, id);
        if(book != null) {
            em.remove(book);
            return true;
        }
        return false;
    }

    public Book updateBookPrice(Book newBook, Float percentRaise){

        Book book = em.find(Book.class, newBook.getId());
        if(book != null){
            book.setPrice(book.getPrice() * (1 + percentRaise));
        }

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

    public List<Category> findCategoriesForGivenBookId(Integer bookID) {

        System.out.println("Entered book category found ");
        Book book = em.find(Book.class, bookID);
        List<Category> retrievedList = book.getCategories();

        return retrievedList;
    }

    public File findBookCoverFromDB(Integer bookId) {
        System.out.println("In repo:" + bookId);
        TypedQuery<String> query = em.createNamedQuery("GetBookCover", String.class);
        query.setParameter("bookId", bookId);

        try {

            String coverPath = query.getSingleResult();
            return new File(getClass().getClassLoader().getResource(coverPath).getFile());
        } catch (NoResultException e) {
            return null;
        }
    }


//TODO prepared statement! for filter... in GET
//TODO de implem findAllBooks() din baza de date



}
