package observer;

public class Article {
    private String author;
    private String title;
    private String content;
    private String newspaper;


    Article(String author, String title, String content, String newspaper){
        this.author = author;
        this.title = title;
        this.content = content;
        this.newspaper = newspaper;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getNewspaper() {
        return newspaper;
    }
}
