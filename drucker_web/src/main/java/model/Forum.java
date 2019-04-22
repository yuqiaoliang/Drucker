package model;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Forum {

    public Forum() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Success loading Mysql Driver!");
        } catch (Exception e) {
            System.out.print("Error loading Mysql Driver!");
            e.printStackTrace();
        }
    }

    public int postMessage(Post post) throws SQLException {
        // Insert a new post
        //int id = post.getId();
        String name = post.getUsername();
        String content = post.getContent();
        String title = post.getTitle();
        String stime = post.getStime();
        String shortContent = post.getShortContent();
        int cnum = post.getCnum();
        String number = Integer.toString(cnum);
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://152.3.53.14:3306/drucker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "myblog", "123456");
            Statement stmt = connect.createStatement();
            String sql_command = "insert into msg_post(pID, username, time, cnum, title, content, shortcontent) values ((null), '" + name + "', '" + stime + "', " + number + ", '" + title + "', '" + content + "', '" + shortContent+ "');";

            stmt.executeUpdate(sql_command);
            connect.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        // Return pID to front end
        int postID = 0;
        postID = newPostNumber();
        return postID;
    }

    public int newPostNumber() {
        int postID = 0;
        String sql_post = "select max(pID) from msg_post;";
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://152.3.53.14:3306/drucker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "myblog", "123456");
            Statement stmt = connect.createStatement();
            stmt.executeQuery(sql_post);
            ResultSet rs = stmt.executeQuery(sql_post);
            if (rs.next()) {
                postID = rs.getInt("pID");
            }
            connect.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return postID;
    }

    public int getNumber(int id) {
        int number = 0;
        String sql_post = "select cnum from msg_post where pID = " + Integer.toString(id) + ";";
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://152.3.53.14:3306/drucker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "myblog", "123456");
            Statement stmt = connect.createStatement();
            stmt.executeQuery(sql_post);
            ResultSet rs = stmt.executeQuery(sql_post);
            if (rs.next()) {
                number = rs.getInt("cnum");
            }
            connect.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return number;
    }

    public void updatePostNumber(int id, int number) {
        int numberAdd = number + 1;
        String sql_post = "update msg_post set cnum =" + numberAdd + " where pID = " + id + ";";
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://152.3.53.14:3306/drucker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "myblog", "123456");
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(sql_post);
            connect.close();
        } catch (SQLException e) {
            System.out.println(e);
        }


    }

    public void Addcomment(Message message) throws SQLException {
        String content = message.getContent();
        String shortContent = message.getShortContent();
        String name = message.getUsername();
        String stime = message.getStime();
        int id = message.getId();
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://152.3.53.14:3306/drucker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "myblog", "123456");
            Statement stmt = connect.createStatement();
            String sql_command = "insert into msg_comment(postID,username,time,content,shortcontent) values (" + id + ",'" + name + "','" + stime + "','" + content + "','" + shortContent + "');";
            stmt.executeUpdate(sql_command);
            connect.close();
            //update post number
            int number = getNumber(id);
            updatePostNumber(id, number);
        } catch (SQLException e) {
            System.out.println("Command Message Error");
        }
    }

    public ArrayList<Post> getMessage() throws SQLException {
        ArrayList<Post> posts = new ArrayList<> ();
        int n = newPostNumber();
        for (int i = 1; i <= n; i++) {
            try {
                //int int_id = Integer.parseInt(id);
                ArrayList<Message> Messages = new ArrayList<>();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Connection connect = DriverManager.getConnection("jdbc:mysql://152.3.53.14:3306/drucker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "myblog", "123456");
                Statement stmt = connect.createStatement();

                String exist = "SELECT EXISTS(SELECT * FROM msg_post WHERE pID = " + i + ");";
                ResultSet r = stmt.executeQuery(exist);
                if(r.next()) {
                    boolean b = r.getBoolean(1);
                    //System.out.println(b);
                    if (b == false) continue;
                }

                String sql_command = "select username,content,shortContent,time from msg_comment where postID = " + i + ";   ";
                ResultSet rs = stmt.executeQuery(sql_command);
                while (rs.next()) {
                    Date time = format.parse(rs.getString(4));
                    Message msg = new Message(rs.getString(2), rs.getString(1), time, i);
                    Messages.add(msg);
                }
                String sql_command1 = "select title,content,username,time from msg_post where pID = " + i + ";   ";
                ResultSet rs1 = stmt.executeQuery(sql_command1);
                String title = "";
                String content = "";
                String authorname = "";
                String time;
                Date post_s_time = null;
                while (rs1.next()) {
                    title = rs1.getString(1);
                    content = rs1.getString(2);
                    authorname = rs1.getString(3);
                    time = rs1.getString(4);
                    post_s_time = format.parse(time);
                }
                Post pst = new Post(title, content, authorname, post_s_time, i, Messages);
                posts.add(pst);

            } catch (SQLException e) {
                System.out.print(e);
                System.out.print("Error fetching message from database!");
                return null;
            } catch (ParseException e) {
                System.out.print("Error Parsing time from database!");
                return null;
            }
        }
        return posts;
    }
}
