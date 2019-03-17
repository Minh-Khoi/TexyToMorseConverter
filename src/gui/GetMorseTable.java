/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KHOI
 */
public class GetMorseTable {

        // JDBC driver name and database URL
        static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
        static final String DB_URL = "jdbc:sqlserver://localhost\\EXPRESS:1433;databaseName=TextToMorse ";
        //  Database credentials
        static final String USER = "sa";
        static final String PASS = "123456";
    public GetMorseTable() {
        String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
                "9", "0", " ", "ă", "â", "ô", "ơ", "ư", "đ" }; 
        String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
                "-....", "--...", "---..", "----.", "-----", "|",".-.--", ".-.-", "------", "---.--", "..-.--", "-..-.."};
        Connection conn = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
            // Enter data into table
            String SQL_INSERT = "INSERT INTO textmorse VALUES (?,?)";
            for(int i=0;i<alphabet.length;i++){
                PreparedStatement prs = conn.prepareStatement(SQL_INSERT);
                prs.setString(1, alphabet[i]);
                prs.setString(2, morse[i]);
                prs.execute();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetMorseTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GetMorseTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
    }
    
}
