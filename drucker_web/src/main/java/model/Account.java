package model;
import java.sql.*;
import java.util.HashMap;

public class Account {

   // private HashMap<String, String> users;

    public Account() {
        //create connection to mysql db
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");     //加载MYSQL JDBC驱动程序
          //Class.forName("org.gjt.mm.mysql.Driver");
         System.out.println("Success loading Mysql Driver!");
        }
        catch (Exception e) {
          System.out.print("Error loading Mysql Driver!");
          e.printStackTrace();
        }
    }

    public String validateLogin(String username, String password) throws SQLException {
    	 //get connection with DB
        Connection connect = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/test","testuser","123456");
        System.out.println("Success connect Mysql server!");
        Statement stmt = connect.createStatement();
        String sql_command = "select * from user" ;
        ResultSet rs = stmt.executeQuery(sql_command);
        if (rs.next()) {
       	  System.out.println("ok");
        String pwd = rs.getString("password");
        if (pwd.equals(password)) {
           // System.out.println("ok1!");
            return "yah!";
        } else if (!pwd.equals(password)) {
            //System.out.println("ok2!");
            return "wha?";
        } else {
           // System.out.println("ok3!");
            return "nay!";
        }
        }
		return null;
    }
}
