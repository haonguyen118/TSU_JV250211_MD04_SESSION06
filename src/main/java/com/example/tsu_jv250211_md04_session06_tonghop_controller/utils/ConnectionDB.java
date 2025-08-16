package com.example.tsu_jv250211_md04_session06_tonghop_controller.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/md04_session06?createDatabaseIfNotExist=true";
    private static String USER = "root";
    private static String PASSWORD = "Sanghao8488@";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn, CallableStatement callSt){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(callSt!=null){
            try {
                callSt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
