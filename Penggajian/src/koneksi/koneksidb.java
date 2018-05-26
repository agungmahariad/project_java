/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.DriverManager;
import java.sql.Connection;

public class koneksidb {
    
    public static Connection cn;
    public static Connection getkoneksi() {
        if (cn == null)
        {
            try{
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                cn = DriverManager.getConnection("jdbc:mysql://localhost/db_penggajian","root","");
                System.out.print("Berhasil");
            }catch(Exception e){
                e.printStackTrace();
            }
        }   
        return cn;
    }
}
