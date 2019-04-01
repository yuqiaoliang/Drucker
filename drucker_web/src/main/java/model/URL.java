package model;
import java.sql.*;
import java.util.ArrayList;

public class URL {
    public URL(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Success loading Mysql Driver!");
        }
        catch (Exception e) {
            System.out.print("Error loading Mysql Driver!");
            e.printStackTrace();
        }
    }
    public ArrayList<String> getUrl(String type) {
        ArrayList<String> url_set = new ArrayList<String>();

        try {
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://152.3.53.14:3306/drucker", "myblog", "123456");
            System.out.println("Success connect Mysql server!");
            Statement stmt = connect.createStatement();
            String sql_command = "select * from url_resources where type=" + "'" + type + "'";
            ResultSet rs = stmt.executeQuery(sql_command);
            if (rs.next()) {
                String url = rs.getString("url");
                url_set.add(url);
            }
        } catch (SQLException e) {
            System.out.println("mysql exception");
        }

        return url_set;
    }

}
