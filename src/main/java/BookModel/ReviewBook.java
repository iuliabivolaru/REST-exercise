package BookModel;

/**
 * Created by iuliab on 23.10.2015.
 */
public class ReviewBook {
    private int id;
    private String user;
    private String title;
    private String content;
    //!!!
    private String date;
    //!!!
    private int bookId;

    public ReviewBook(int id, String user, String title, String content, String date, int bookId) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
        this.date = date;
        this.bookId = bookId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setBookId(int bookId){
        this.bookId = bookId;
    }

}
