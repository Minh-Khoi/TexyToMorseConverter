/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.DTO;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBConnector;
/**
 *
 * @author KHOI
 */
public class DAO {
    String text, morse;
    DTO obj;
    ArrayList<DTO> list;
    Connection conn;
    PreparedStatement prs;
    final String SQL_SELLECT = "SELECT morse FROM textmorse WHERE text = ?",
                    SQL_READALL = "Select text from textmorse"; 

    public DAO() {
        conn = new DBConnector().getConn();
    }
    
    public String convert(String te){
        try {
            prs= conn.prepareStatement(SQL_SELLECT);
            prs.setString(1, te);
            ResultSet res = prs.executeQuery();
            while (res.next()){
                morse= res.getString("morse");
            }
            return (morse!="|" && morse!=null)? morse : "";
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public List<String> readAllText (){
        try {
            List<String> list = new ArrayList<>();
            prs = conn.prepareStatement(SQL_READALL);
            ResultSet res = prs.executeQuery();
            while (res.next()){
                list.add(res.getString("text"));
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Connection to Database failed");
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
