/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author ferifahrul
 */
public class Koneksi {
    
    private static Connection con;
    
    public static Connection connection() {
        
        if(con==null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("tiket");
            data.setUser("ferifahrul");
            data.setPort(3306);
            data.setPassword("password");
            
            try{
                con = data.getConnection();
                
            }catch(SQLException e){
               e.printStackTrace();
                
            }
        }
       
            return con;
    }
    
}
