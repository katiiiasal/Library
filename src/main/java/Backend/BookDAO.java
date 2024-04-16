package Backend;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private final String url = "jdbc:mysql://localhost:3306/library";
    private final String user = "root";
    private final String password = "toor";

    private static final String INSERT_BOOK_SQL = "INSERT INTO books (title, pages, chapters, summary, author) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_BOOK_BY_ID = "SELECT * FROM books WHERE id_book = ?";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books";
    private static final String UPDATE_BOOK_SQL = "UPDATE books SET title = ?, pages = ?, chapters = ?, summary = ?, author = ? WHERE id_book = ?";
    private static final String DELETE_BOOK_SQL = "DELETE FROM books WHERE id_book = ?";

    public BookDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public int insertBook(Book book) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setInt(2, book.getPages());
            preparedStatement.setInt(3, book.getChapters());
            preparedStatement.setString(4, book.getSummary());
            preparedStatement.setString(5, book.getAuthor());
            preparedStatement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Book selectBook(int id) {
        Book book = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                int pages = rs.getInt("pages");
                int chapters = rs.getInt("chapters");
                String summary = rs.getString("summary");
                String author = rs.getString("author");
                book = new Book(title, pages, chapters, summary, author);
                book.setIdBook(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public List<Book> selectAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_book");
                String title = rs.getString("title");
                int pages = rs.getInt("pages");
                int chapters = rs.getInt("chapters");
                String summary = rs.getString("summary");
                String author = rs.getString("author");
                Book book = new Book(title, pages, chapters, summary, author);
                book.setIdBook(id);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public int deleteBook(int id) {
        
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BOOK_SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        
    }

    public int updateBook(Book book, int idBook) {
        
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK_SQL)) {
            statement.setString(1, book.getTitle());
            statement.setInt(2, book.getPages());
            statement.setInt(3, book.getChapters());
            statement.setString(4, book.getSummary());
            statement.setString(5, book.getAuthor());
            statement.setInt(6, idBook);
            statement.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        
    }
}
