
package com.mis.dao;
import com.mis.model.Filefolder;
import java.sql.Date;
import java.util.List;
public interface FilefolderDao {
	public void insert(String f_route, Date f_date, long f_size, String f_name, String f_type);
        //表的显示
        public List<Filefolder> select();  
        //删除
        public boolean delete(String f_froute);
        //按输入查询查询
        public List<Filefolder> select_two(String str);
        //树结构插入
        public void insert_two(String father,String son);
        //打印树
        public List<String> select_tree(String father);
}
