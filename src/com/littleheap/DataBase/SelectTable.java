package com.littleheap.DataBase;

import java.sql.*;

import com.littleheap.Static.Information;

public class SelectTable {
	
	//���ݿ��ѯ����ģ��
	public SelectTable() {
		try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL������");
                
            String url=Information.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ⣡");

            String sql = "select * from temp";    //Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
                System.out.println("���"+"\t"+"����"+"\t"+"����");
                while (rs.next()){
                    System.out.print(rs.getInt(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.print(rs.getString(3) + "\t");
                    System.out.println();
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
	}
    
	//�Ƿ���ڸ��û�
    public static boolean isExist_Customer(String user,String password) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Customer");
                
            String url=Information.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Customer");

            String sql = "select * from Customer";    //Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
                System.out.println("�û���"+"\t"+"\t"+"\t"+"����");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.println();
                    if(rs.getString(1).equals(user) && rs.getString(2).equals(password)) {
                        rs.close();
                        stmt.close();
                        conn.close();
                    	return true;
                    }
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }
    
    //�Ƿ���ڸù���Ա
    public static boolean isExist_Manager(String user,String password) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Manager");
                
            String url=Information.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Manager");

            String sql = "select * from Manager";    //Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
                System.out.println("�û���"+"\t"+"\t"+"\t"+"����");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.println();
                    if(rs.getString(1).equals(user) && rs.getString(2).equals(password)) {
                        rs.close();
                        stmt.close();
                        conn.close();
                    	return true;
                    }
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }

    //ע�����û�
    public static void regist_Customer(String user,String password) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-regist_Customer");
                
            String url=Information.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-regist_Customer");

            String sql = "insert into Customer values('"+user+"','"+password+"');";    //Ҫִ�е�SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    
    //ע���¹���Ա
    public static void regist_Manager(String user,String password) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-regist_Manager");
                
            String url=Information.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-regist_Manager");

            String sql = "insert into Manager values('"+user+"','"+password+"');";    //Ҫִ�е�SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    
    //�ı��û�������
    public static void changePassword_Customer(String user,String password,String newPassword) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-changePassword");
                
            String url=Information.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-changePassword");

            String sql = "update Customer set customer_password = '"+newPassword+"' where customer_user = '"+user+"';";    //Ҫִ�е�SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    
    //�ı����Ա������
    public static void changePassword_Manager(String user,String password,String newPassword) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-changePassword");
                
            String url=Information.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-changePassword");

            String sql = "update Manager set manager_password = '"+newPassword+"' where manager_user = '"+user+"';";    //Ҫִ�е�SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }

    //�Ƿ���ڸ��û���
    public static boolean isExist_Customer_user(String user,String password) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Customer");
                
            String url=Information.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Customer");

            String sql = "select * from Customer";    //Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
                System.out.println("�û���"+"\t"+"\t"+"\t"+"����");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.println();
                    if(rs.getString(1).equals(user)) {
                        rs.close();
                        stmt.close();
                        conn.close();
                    	return true;
                    }
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }

    //�Ƿ���ڸù���Ա����
    public static boolean isExist_Manager_user(String user,String password) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Manager");
                
            String url=Information.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Manager");

            String sql = "select * from Manager";    //Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
                System.out.println("�û���"+"\t"+"\t"+"\t"+"����");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.println();
                    if(rs.getString(1).equals(user)) {
                        rs.close();
                        stmt.close();
                        conn.close();
                    	return true;
                    }
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }
    
    //��������
    public static void insertBook(String number,String classnumber,String name,String classname,String price,String state,String total) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-insertBook");
                
            String url=Information.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Information.username,Information.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-insertBook");

            String sql = "insert into "+classname+"Book"+" values('"+number+"','"+classnumber+"','"+name+"','"+classname+"','"+price+"','"+state+"','"+total+"');";    //Ҫִ�е�SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
}
