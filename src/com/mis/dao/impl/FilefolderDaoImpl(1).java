package com.mis.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mis.model.Filefolder;
import java.util.List;
import com.mis.util.DatebaseBean;
import com.mis.dao.FilefolderDao;
import java.sql.Date;
import java.util.ArrayList;

public class FilefolderDaoImpl implements FilefolderDao{
        int i=1;
        String str ="";
        List<String> strs = new ArrayList<String>();
	Connection conn =null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
        //查询所有
        public List<Filefolder> select(){
            List<Filefolder> filefolders = new ArrayList<Filefolder>();
            try {
            conn = DatebaseBean.getConnection();
            String sql = "select *from filefolder";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Filefolder file = new Filefolder();
                file.setF_route(rs.getString("f_route"));
                file.setF_date(rs.getDate("f_date"));
                file.setF_name(rs.getString("f_name"));
                file.setF_size(rs.getLong("f_size"));
                file.setF_type(rs.getString("f_type"));
                filefolders.add(file);
            }
             } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatebaseBean.close(rs, pstm, conn);
        }
            return filefolders;
        }
        //按条件查询
        public List<Filefolder> select_two(String str){
            List<Filefolder> filefolders = new ArrayList<Filefolder>();
            try {
            conn = DatebaseBean.getConnection();
            String sql = "select *from filefolder";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                
                if (rs.getString("f_name").indexOf(str)!=-1){
                Filefolder file = new Filefolder();
                file.setF_route(rs.getString("f_route"));
                file.setF_date(rs.getDate("f_date"));
                file.setF_name(rs.getString("f_name"));
                file.setF_size(rs.getLong("f_size"));
                file.setF_type(rs.getString("f_type"));
                filefolders.add(file);
                }
            }
             } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatebaseBean.close(rs, pstm, conn);
        }
            return filefolders;
        }
        //插入
	public void insert(String f_route, Date f_date, long f_size, String f_name, String f_type) {
		conn = DatebaseBean.getConnection();
		String sql = "select count(*) from FILEFOLDER where 1 = 1";
        String sqlStr = "insert into FILEFOLDER values(?,?,?,?,?)";	
        try {
            pstm = conn.prepareStatement(sqlStr);
           
            pstm.setString(1, f_route);
            pstm.setDate(2, f_date);
            pstm.setLong(3, f_size);
            pstm.setString(4, f_name);
            pstm.setString(5, f_type);	        
            pstm.executeUpdate();
            conn.commit();
            
        } catch (SQLException e) {
            e.printStackTrace();
           
        } finally {
            DatebaseBean.close(rs, pstm, conn);
        }
        
	}
        //删除
	public boolean delete(String f_route){
           try {
            String sql = "delete from FILEFOLDER where f_route=?";
            conn = DatebaseBean.getConnection();
            pstm = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            pstm.setString(1, f_route);
            pstm.executeUpdate();
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                if (conn!=null){
                conn.rollback();
                conn.setAutoCommit(true);}
            } catch (Exception e1) {
            }
        } finally {
            DatebaseBean.close(null, pstm, conn);
        }
        return false;
        }
        //插入路径
        public void insert_two(String father,String son){
            conn = DatebaseBean.getConnection();
            String sqlStr = "insert into tree values(?,?)";
            try {
            pstm = conn.prepareStatement(sqlStr);
            pstm.setString(1, father);
            pstm.setString(2, son);              
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatebaseBean.close(rs, pstm, conn);
        }
            }
        //树打印
        public List<String> select_tree(String father) {
        str ="";
        Connection conn =null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
        try{
            conn = DatebaseBean.getConnection();        
            pstm = conn.prepareStatement("select distinct son from tree where father = ?");
            pstm.setString(1, father);
            rs = pstm.executeQuery();
            while (rs.next()) {               
                for (int j=0;j<i;j++){
                    str = str +"----";   }         
            //    System.out.println(rs.getString("son"));  
            strs.add(str+rs.getString("son"));
                i++;              
               select_tree(rs.getString("son"));                                        
            }            
            i--;           
            
             } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatebaseBean.close(rs, pstm, conn);            
       }
        return  strs;
    }
	

}
