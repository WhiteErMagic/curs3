import java.sql.*;

public class DB {
    private Connection conn;

    public DB() {
        this.conn = createConnection();
        createTableGoods();
    }

    private Connection createConnection() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (SQLException e) {
            throw new IllegalArgumentException("Invalid database URL: test.db");
        }
    }

    private void createTableGoods(){
        try {
            connectDriver();
            PreparedStatement st = this.conn.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS goods (" +
                                    "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                                    "PRODID TEXT NOT NULL," +
                                    "TITLE TEXT NOT NULL," +
                                    "COST REAL);");
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void connectDriver(){
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
}
