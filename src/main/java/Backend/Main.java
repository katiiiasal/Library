package Backend;


public class Main {

    public static void main(String[] args) {
        
        Book book = new Book("Harry Potter", 450, 25, "The child who survived", "JK Rowling");
        System.out.println(book);
        
        BookDAO bookDAO = new BookDAO();
        int result = bookDAO.insertBook(book);
        if(result == 1){
            System.out.println("Book has been inserted successfully");
        }else{
            System.out.println("Unable to create book");
        }
        
    }
}
