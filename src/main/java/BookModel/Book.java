package BookModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Book {
    private int id;
    private String title;
    private String authors;
    private Category category;
    //!!!
    private String date;
    private double price;
    private String ISBN;
    private String description;
    private String cover;
    private int numberOfPages;
    private String language;
    private float stars;

    public Book() {

    }

    public Book(int id, String title, String authors, Category category, String date, double price, String ISBN, String description, String cover, int numberOfPages, String language, float stars) {
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
