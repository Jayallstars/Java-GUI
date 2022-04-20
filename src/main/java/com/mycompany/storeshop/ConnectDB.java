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
    
    public void ConnectDatabase(){
            Connection connect = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connect =  DriverManager.getConnection("jdbc:mariadb://localhost:3306/shop_database?&user=root&password=" +
                    "?user=root&password=");

            if(connect != null){
                System.out.println("Database Connected.");
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

    public void RetriveUserdata(String user, String pass){
        Connection connect = null;
        String username = "";
        String password = "";
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
                pass = pass.trim();

//                System.out.println(user);
//                System.out.println(pass);
//                System.out.println(username);
//                System.out.println(password);
                if ((username.equals(user)) && (password.equals(pass))){
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