import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Store {
    private Connection conn;
    public Store(Connection conn) {
        this.conn = conn;
    }

    public void insertGoods(int arg){
        try {
            Statement stdel = this.conn.createStatement();
            stdel.execute("DELETE FROM goods");
            stdel.close();
            PreparedStatement st = this.conn.prepareStatement("INSERT INTO goods(title, cost) VALUES(?, ?);");
            for (int i = 0; i < arg; i++) {
                st.setString(1, "товар" + Integer.toString(i));
                st.setFloat(2, i);
                //st.addBatch();
                st.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
