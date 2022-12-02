package org.app;

import java.sql.*;
import java.util.*;

class MysqlCon{
    static String url = "jdbc:mysql://127.0.0.1:3306/HotelChart";
    static String username = "root";
    static String password = "152503xy";

    public static List<String> getCollumnNames() {
        String query = "SELECT * FROM customer";
        List<String> result = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();
            ResultSet resultset = statement.executeQuery(query);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public static void SQL() throws SQLException{
        String query1 = "SELECT * FROM accountinfo;";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query1);
            while(result.next()){
                String accountdata = "";
                for(int i=1; i<=3;i++){
                    accountdata += result.getString(i) + ":";
                }
                System.out.println(accountdata);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}

