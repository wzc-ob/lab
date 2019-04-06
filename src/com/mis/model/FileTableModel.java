/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.model;

import com.mis.util.DaoFactory;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class FileTableModel extends AbstractTableModel{
    final String[] cloumnNames = {"路径","时间","大小","名字","类型"};
    List<Filefolder> rowsDate;
    public FileTableModel(){
        rowsDate = DaoFactory.igetFilefolder().select();
    }
    public FileTableModel(String str){
        rowsDate = new ArrayList<Filefolder>();
        rowsDate = DaoFactory.igetFilefolder().select_two(str);
    }
    public int getRowCount(){
        return rowsDate.size();
    }
    public int getColumnCount(){
    return cloumnNames.length;
    }
    public Object getValueAt(int rowIndex,int columnIndex){
    switch(columnIndex){
            case 0:
            return rowsDate.get(rowIndex).getF_route();
            case 1:
            return rowsDate.get(rowIndex).getF_date();
            case 2:
            return rowsDate.get(rowIndex).getF_size();
            case 3:
            return rowsDate.get(rowIndex).getF_name();
            case 4:
            return rowsDate.get(rowIndex).getF_type();
    }
    return null;
    }
    public  String getColumnName(int column){
    return cloumnNames[column];
    }
}
