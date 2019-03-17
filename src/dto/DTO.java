/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.*;
/**
 *
 * @author KHOI
 */
public class DTO implements Serializable{
    private String text, morse;

    public DTO() {
    }

    public String getText() {
        return text;
    }

    public String getMorse() {
        return morse;
    }

    @Override
    public String toString() {
        return "DTO{" + "text=" + text + ", morse=" + morse + '}';
    }
    
    
    
}
