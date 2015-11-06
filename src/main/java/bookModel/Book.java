package bookModel;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String title;

    private String authors;

    @Transient
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_book")
    private List<Category> categories;

    @Column(name = "publication_date")
    private String date;

    @Column(name = "price")
    private Float price;

    private String ISBN;

    private String description;

    private String cover;

    @Column(name = "number_of_pages")
    private Integer numberOfPages;

    @Column(name = "language_of_book")
    private String language;

    private Float stars;

    public Book() {

    }

    public Book(Integer id, String title, String authors, List<Category> categories, String date, Float price, String ISBN, String description, String cover, int numberOfPages, String language, float stars) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.categories = categories;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
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
