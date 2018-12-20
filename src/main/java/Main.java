import sun.java2d.pipe.SpanShapeRenderer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    private static PreparedStatement st;
    private static ResultSet rs;
    private static Connection conn;
    public static void main(String[] args) {

        DB db = new DB();
        conn = db.getConn();
        Store store = new Store(conn);
        store.insertGoods(1000);
        goods(conn);

    }

    private static void goods(Connection conn) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Поиск цены товара по наименованию");
            String str;
            while (true) {
                str = reader.readLine();
                String[] arr;
                if (str.startsWith("/цена")) {
                    String tovar = reader.readLine().split(" ")[1];
                    rs = find(tovar);
                    if (rs.next()) {
                        System.out.println("цена для товара " + tovar + " - " + rs.getString("COST"));
                    } else {
                        System.out.println("Товар " + tovar + " не найден!");
                    }
                }else if (str.startsWith("/сменитьцену")){
                    arr = str.split(" ");
                    rs = find(arr[1]);
                    if (rs.next()) {
                        rs.close();
                        st = conn.prepareStatement("UPDATE goods SET COST = ?  WHERE TITLE = ?");
                        st.setFloat(1, Float.parseFloat(arr[2]));
                        st.setString(2, arr[1]);
                        if(st.executeUpdate() > -1)
                            System.out.println("Цена успешно обновлена!");
                    } else {
                        System.out.println("Товар " + arr[1] + " не найден!");
                    }
                }else if (str.startsWith("/товарыпоцене")){
                    arr = str.split(" ");
                    st = conn.prepareStatement("SELECT TITLE, COST FROM goods WHERE COST >= ? AND COST <= ?");
                    st.setFloat(1, Float.parseFloat(arr[1]));
                    st.setFloat(2, Float.parseFloat(arr[2]));
                    rs = st.executeQuery();
                    System.out.println("Перечень товаров:");
                    while (rs.next()){
                        System.out.println(rs.getString("TITLE") + " - " + Float.toString(rs.getFloat("COST")));
                    }
                    rs.close();
                }else if (str.startsWith("/end")){
                    break;
                }
            }
            conn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static ResultSet find(String tovar) {
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT COST FROM goods WHERE TITLE = ?");
            st.setString(1, tovar);
            rs = st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


}
