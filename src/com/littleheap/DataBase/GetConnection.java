package com.littleheap.DataBase;

import java.sql.*;

import com.littleheap.Static.Information;
import com.mysql.jdbc.Connection;

public class GetConnection {
	
    public static void main(String[] args){
        try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL������");
        }catch(ClassNotFoundException e1){
            System.out.println("�Ҳ���MySQL����!");
            e1.printStackTrace();
        }
        
        String url=Information.JDBC_URL;    //JDBC��URL    
        //����DriverManager�����getConnection()���������һ��Connection����
        Connection conn;
        try {
            conn = (Connection) DriverManager.getConnection(url,Information.username,Information.password);
            //����һ��Statement����
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.print("�ɹ����ӵ����ݿ⣡");
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
