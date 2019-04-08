package model;
import java.sql.*;
//import org.json.*;

public class Account {

    // private HashMap<String, String> users;

    public Account() {
        //create connection to mysql db on vm
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Success loading Mysql Driver!");
        }
        catch (Exception e) {
            System.out.print("Error loading Mysql Driver!");
            e.printStackTrace();
        }
    }
    public String validateLogin(String username, String password) throws SQLException {
        //get connection with DB
        String res = "";
        Connection connect = DriverManager.getConnection("jdbc:mysql://152.3.53.14:3306/drucker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","myblog","123456");
//        System.out.println("Success connect Mysql server!");
        Statement stmt = connect.createStatement();
        String sql_command = "select * from login where username=" + "'" + username + "'";
        ResultSet rs = stmt.executeQuery(sql_command);
        //JSONObject obj = new JSONObject();

        if (rs.next()) {
            String pwd = rs.getString("password");
            //System.out.println(pwd);
            //obj.put("username", username);
            if (pwd.equals(password)) {
                res="true";
            } else {
                res = "false";
            }
        }

        return res;
    }
}