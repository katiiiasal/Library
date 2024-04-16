package Backend;

public class Book {
    
    // Attributes
    
    private int idBook;
    private String title;
    private int pages;
    private int chapters;
    private String summary;
    private String author;
    
    // Constructor
    
    public Book(){
    }
    
    public Book(String title, int pages, int chapters, String summary, String author){
        this.title = title;
        this.pages = pages;
        this.chapters = chapters;
        this.summary = summary;
        this.author = author;
        
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Books{" + "idBook=" + idBook + ", title=" + title + ", pages=" + pages + ", chapters=" + chapters + ", summary=" + summary + ", author=" + author + '}';
    }
    
    
    
    
    
    

}
