package org.app;

import java.sql.*;

class MysqlCon{
    public static void main(String args[]) throws SQLException{
        String url = "jdbc:mysql://127.0.0.1:3306/HotelChart";
        String username = "root";
        String password = "152503xy";
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

