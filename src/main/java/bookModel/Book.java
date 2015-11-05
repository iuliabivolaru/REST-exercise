package bookModel;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
//import javax.persistence.Entity;
//import javax.persistence.Id;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "ExpensiveBooks", query = "SELECT b FROM Book b WHERE b.price > :price"),
        @NamedQuery(name = "ManyPagesBooks", query = "SELECT b FROM Book b WHERE b.numberOfPages > ?1")
})
@Table(name="BOOKS5")
public class Book {
    @Id
    @Column(name = "id_book")
    private Integer id;

    private String title;

    private String authors;

    private Category category;
    //!!!
    @Column(name = "publication_date")

    private String date;
    @Column(name = "price")
    private Double price;

    private String ISBN;

    private String description;

    private String cover;
    @Column(name = "number_of_pages")
    private Integer numberOfPages;
    //@Transient
    @Column(name = "language_of_book")
    private String language;
    //@Transient
    private Float stars;

    public Book() {

    }

    public Book(Integer id, String title, String authors, Category category, String date, double price, String ISBN, String description, String cover, int numberOfPages, String language, float stars) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.category = category;
        this.date = date;
        this.price = price;
        this.ISBN = ISBN;
        this.description = description;
        this.cover = cover;
        this.numberOfPages = numberOfPages;
        this.language = language;
        this.stars = stars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    @XmlElement(name="desc")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

}
