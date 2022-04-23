/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.storeshop;

import javax.swing.*;
import java.sql.*;

/**
 *
 * @author AquaEdge
 */
public class ConnectDB {
    JFrame alert;
    
//    public void ConnectDatabase(){
//            Connection connect = null;
//
//        try {
//            Class.forName("org.mariadb.jdbc.Driver");
//            connect =  DriverManager.getConnection("jdbc:mariadb://localhost:3306/shop_database?&user=root&password=" +
//                    "?user=root&password=");
//
//            if(connect != null){
//                System.out.println("Database Connected.");
//            } else {
//                System.out.println("Database Connect Failed.");
//            }
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        // Close
//        try {
//            if(connect != null){
//                connect.close();
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

    public void RetriveUserdata(String user, char [] pass){
        Connection connect = null;
        String username = "";
        String password = "";
        String passConvert = "";
        String check = "";
        LoginPage test = new LoginPage();

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mariadb://localhost:3306/shop_database?&user=root&password=" +
                    "?user=root&password=");

            if(connect != null){
                System.out.println("Database Connected.");
            } else {
                System.out.println("Database Connect Failed.");
            }

            PreparedStatement st = connect.prepareStatement("SELECT * from users");
            ResultSet retrive = st.executeQuery();

            while (retrive.next()) {
                username = retrive.getString("username").trim();
                password = retrive.getString("password").trim();
                user = user.trim();
                passConvert = String.valueOf(pass);
                if ((username.equals(user)) && (password.equals(passConvert))){
                    check = "true";
                }
            }
            if (check == "true"){
                new ProductOwn().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(alert, "Wrong password or username");
            }


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Close
        try {
            if(connect != null){
                connect.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void InsertDatabase(String user, String pass, String email){
        Connection connect = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mariadb://localhost:3306/shop_database?&user=root&password=" +
                    "?user=root&password=");

            if(connect != null){
                Statement st = connect.createStatement();
                st.executeUpdate("INSERT INTO users (username, password, email)"
                        +"VALUES ("+"'"+user+"'"+", "+"'"+pass+"'"+", "+"'"+email+"'"+")");
                connect.close();
                JOptionPane.showMessageDialog(alert, "Success! your account has been created.");
            } else {
                System.out.println("Database Connect Failed.");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Close
        try {
            if(connect != null){
                connect.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void InsertDatabaseProducts(String name, String price, String qty){
        Connection connect = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mariadb://localhost:3306/shop_database?&user=root&password=" +
                    "?user=root&password=");
            if(connect != null){
                Statement st = connect.createStatement();
                st.executeUpdate("INSERT INTO products (products_name, products_price, products_qty)"
                        +"VALUES ("+"'"+name+"'"+", "+"'"+price+"'"+", "+"'"+qty+"'"+")");
                connect.close();
                JOptionPane.showMessageDialog(alert, "Success! to add data.");
            } else {
                System.out.println("Database Connect Failed.");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Close
        try {
            if(connect != null){
                connect.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void UpdateDatabase(String id, String qty){
        Connection connect = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mariadb://localhost:3306/shop_database?&user=root&password=" +
                    "?user=root&password=");

            if(connect != null){
                Statement st = connect.createStatement();
                st.executeUpdate("Update products SET products_qty = "+"'"+qty+"'"+"WHERE products_id = "+"'"+id+"'");
                connect.close();
            } else {
                System.out.println("Database Connect Failed.");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Close
        try {
            if(connect != null){
                connect.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void UpdateMoney(int money){
        Connection connect = null;
        int id = 1;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mariadb://localhost:3306/shop_database?&user=root&password=" +
                    "?user=root&password=");

            if(connect != null){
                Statement st = connect.createStatement();
                st.executeUpdate("Update shop_money SET money = "+"'"+money+"'"+"WHERE id = "+"'"+id+"'");
                connect.close();
            } else {
                System.out.println("Database Connect Failed.");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Close
        try {
            if(connect != null){
                connect.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int retriveMoney(){
        Connection connect = null;
        int money = 0;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mariadb://localhost:3306/shop_database?&user=root&password=" +
                    "?user=root&password=");

            if(connect != null){
                Statement st = connect.createStatement();
                ResultSet retrive = st.executeQuery("SELECT * from shop_money");
                while (retrive.next()) {
                    money = retrive.getInt("money");
                }
                connect.close();
            } else {
                System.out.println("Database Connect Failed.");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Close
        try {
            if(connect != null){
                connect.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return money;
    }

    public String rowCount(){
        Connection connect = null;
        int id = 1;
        int count = 0;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mariadb://localhost:3306/shop_database?&user=root&password=" +
                    "?user=root&password=");

            if(connect != null){
                Statement s = connect.createStatement();
                ResultSet r = s.executeQuery("SELECT COUNT(*) AS recordCount FROM products");
                r.next();
                count = r.getInt("recordCount");
                r.close();
                System.out.println("MyTable has " + count + " row(s).");
                connect.close();
            } else {
                System.out.println("Database Connect Failed.");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Close
        try {
            if(connect != null){
                connect.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return String.valueOf(count);
    }

//        public static void main(String[] args)
//        {
//            Connection connect = null;
//
//        try {
//            Class.forName("org.mariadb.jdbc.Driver");
//            connect =  DriverManager.getConnection("jdbc:mariadb://localhost:3306/shop_database?&user=root&password=" +
//                    "?user=root&password=");
//
//            if(connect != null){
//                System.out.println("Database Connected.");
//            } else {
//                System.out.println("Database Connect Failed.");
//            }
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        // Close
//        try {
//            if(connect != null){
//                connect.close();
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        }
}