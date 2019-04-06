package com.mis.util;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatebaseBean {
    public static Connection getConnection() {
	Connection conn = null;
       String driver = "oracle.jdbc.driver.OracleDriver";
       String url = "jdbc:oracle:thin:@localhost:1521:xe";
       String user = "hr";
       String pwd = "oracle";

       try {
           Class.forName(driver);
           conn = DriverManager.getConnection(url, user, pwd);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(DatebaseBean.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(DatebaseBean.class.getName()).log(Level.SEVERE, null, ex);
       }
       return conn;
   }

    public static void close(ResultSet rs, PreparedStatement pstm, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatebaseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
