/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pw_laundry;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author MY Compaq
 */
public class koneksi {
    public Connection kon;
    public Connection buka_koneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            kon = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_laundry", "root" , "");
            System.out.println("berhasil terhubung ke mysql");
        } catch (Exception e) {
            System.out.println("berhasil terhubung ke mysql");
        }
        return kon;
    }
    
}
