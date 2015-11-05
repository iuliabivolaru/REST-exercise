package Repository;

import bookModel.Book;

import javax.persistence.*;
import java.util.List;

/**
 * Created by iuliab on 04.11.2015.
 */
public class BookRepositoryHibernate {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistUnit1");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    public BookRepositoryHibernate() {

    }

    public Book createBook(Book book){
        tx.begin();
        em.persist(book);
        tx.commit();
        return book;
    }

    public Book findBook(Integer id) {

        System.out.println("Entered book found ");
        return em.find(Book.class, id);
    }

    public void removeBook(Integer id){

        tx.begin();
        Book book = em.find(Book.class, id);
        if(book != null)
            em.remove(book);
        tx.commit();
    }

    public Book updateBookPrice(Book newBook, Double percentRaise){

        tx.begin();
        Book book = em.find(Book.class, newBook.getId());
        if(book != null){
            book.setPrice(book.getPrice() * (1 + percentRaise));
        }
        tx.commit();

        return book;
    }

    public Long countBooks(){

        Query query = em.createQuery("SELECT COUNT(b) FROM Book b", Long.class);
        Long numberOfBooks = (Long)query.getSingleResult();
        return numberOfBooks;
    }

    public List<Book> queryBooksPrice(Double price){

        TypedQuery<Book> querybooksBelowAPrice = em.createQuery("SELECT b FROM Book b WHERE b.price < :price", Book.class);
        return querybooksBelowAPrice.getResultList();
    }

    public List<Book> queryExpensiveBooks(Double price){

        TypedQuery<Book> queryBooksAboveAPrice = em.createNamedQuery("ExpensiveBooks", Book.class);
        queryBooksAboveAPrice.setParameter("price", price);

        return queryBooksAboveAPrice.getResultList();
    }

    public List<Book> queryBooksWithManyPages(Integer pageNumber){

        TypedQuery<Book> queryBooksManyPages = em.createNamedQuery("ManyPagesBooks", Book.class);
        queryBooksManyPages.setParameter(1, pageNumber);

        return queryBooksManyPages.getResultList();
    }

}
