package com.littleheap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.eclipse.jface.text.templates.Template;
import org.eclipse.swt.widgets.Tree;

import com.littleheap.DataBase.GetConnection;
import com.littleheap.DataBase.SelectTable;
import com.littleheap.OtherInterface.InsertBook;
import com.littleheap.OtherInterface.ManagerInterface;

import java.awt.*;

public class MainInterface extends JFrame implements ActionListener{

	public static JPanel contentPane;
	public static ManagerInterface managerJPanel = new ManagerInterface();
	public static InsertBook insertJPanel = new InsertBook();
	private JTextField tf_user;
	private JTextField tf_password;
	private JLabel label_user;
	private JLabel label_password;
	private JRadioButton rb_customer;
	private JRadioButton rb_manager;
	private JButton btn_login;
	private JButton btn_register;
	private JButton btn_changePassword;
	private static boolean flage_manager = false;
	private static boolean flage_insert = false;
	private static boolean flage_newClass = false;
	private static boolean flage_update = false;
	private static boolean flage_state = false;
	private boolean flage = false;
	private static Container container;
	
	public MainInterface() {
		init();
	}
	
	//��ʼ������
	public void init() {
		
		container = getContentPane();
//		getContentPane().add(managerJPanel);
//		managerJPanel.setVisible(false);
		
		//��ʼ��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 400, 1300, 1000);
		setResizable(false); 
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
//		container.add(managerJPanel);/////////////////////////
//		managerJPanel.setVisible(false);
		
		container.add(contentPane);
		contentPane.setLayout(null);
		
		//�˺������
		tf_user = new JTextField();
		tf_user.setFont(new Font("����", Font.BOLD, 35));
		tf_user.setBounds(443, 248, 526, 75);
		contentPane.add(tf_user);
		tf_user.setColumns(10);
		
		//���������
		tf_password = new JTextField();
		tf_password.setFont(new Font("����", Font.BOLD, 35));
		tf_password.setColumns(10);
		tf_password.setBounds(443, 357, 526, 75);
		contentPane.add(tf_password);
		
		//�û�����ǩ
		label_user = new JLabel("\u8D26\u53F7\uFF1A");
		label_user.setFont(new Font("����", Font.BOLD, 35));
		label_user.setBounds(318, 261, 116, 48);
		contentPane.add(label_user);
		
		//�����ǩ
		label_password = new JLabel("\u5BC6\u7801\uFF1A");
		label_password.setFont(new Font("����", Font.BOLD, 35));
		label_password.setBounds(318, 370, 116, 48);
		contentPane.add(label_password);
		
		//��ͨ�û���ѡ��ť
		rb_customer = new JRadioButton("\u666E\u901A\u7528\u6237");
		rb_customer.setSelected(true);
		rb_customer.setFont(new Font("����", Font.BOLD, 30));
		rb_customer.setBackground(Color.WHITE);
		rb_customer.setBounds(443, 515, 170, 37);
		contentPane.add(rb_customer);
		
		//������Ա��ѡ��ť
		rb_manager = new JRadioButton("\u7BA1\u7406\u4EBA\u5458");
		rb_manager.setFont(new Font("����", Font.BOLD, 30));
		rb_manager.setBackground(Color.WHITE);
		rb_manager.setBounds(799, 515, 170, 37);
		contentPane.add(rb_manager);
		//��ѡ�ť��ӵ�һ����ť��
		ButtonGroup bg=new ButtonGroup();// ��ʼ����ť��
		bg.add(rb_customer);// ��ͨ�û����밴ť��
		bg.add(rb_manager);// ������Ա���밴ť��
		
		//��¼��ť
		btn_login = new JButton("\u767B\u5F55");
		btn_login.setBackground(Color.LIGHT_GRAY);
		btn_login.setFont(new Font("����", Font.BOLD, 35));
		btn_login.setBounds(443, 634, 170, 48);
		contentPane.add(btn_login);
		
		btn_login.addActionListener(this);
		
		//ע�ᰴť
		btn_register = new JButton("\u6CE8\u518C");
		btn_register.setFont(new Font("����", Font.BOLD, 35));
		btn_register.setBackground(Color.LIGHT_GRAY);
		btn_register.setBounds(799, 634, 170, 48);
		contentPane.add(btn_register);
		
		btn_register.addActionListener(this);
		
		//�޸����밴ť
		btn_changePassword = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btn_changePassword.setFont(new Font("����", Font.BOLD, 30));
		btn_changePassword.setBackground(Color.LIGHT_GRAY);
		btn_changePassword.setBounds(1011, 370, 170, 48);
		contentPane.add(btn_changePassword);
		
		btn_changePassword.addActionListener(this);
	}
	
	//�л����ں���
	public static void MaintoManager() {
		if(!flage_manager) {
			contentPane.setVisible(false);//////////
			container.add(managerJPanel);///////////
			flage_manager = true;
		}else {
			contentPane.setVisible(false);
			managerJPanel.setVisible(true);
		}
	}
	
	public static void ManagertoMain() {
		managerJPanel.setVisible(false);
		contentPane.setVisible(true);
	}
	
	public static void ManagertoInsert() {
		if(!flage_insert) {
			managerJPanel.setVisible(false);
			container.add(insertJPanel);
			flage_insert = true;
		}else {
			managerJPanel.setVisible(false);
			insertJPanel.setVisible(true);
		}
	}
	
	public static void InserttoManager() {
		insertJPanel.setVisible(false);
		managerJPanel.setVisible(true);
	}
	
	//��¼ע���¼�����
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btn_login) {
			//�����¼��ť
			//�ж��û��������Ƿ�Ϊ��
			if (tf_user.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�û�������Ϊ��", "��¼ʧ��", JOptionPane.ERROR_MESSAGE);
			} else if (tf_password.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "��¼ʧ��", JOptionPane.ERROR_MESSAGE);
			}else {
				//�ж����û����ǹ���Ա
				if(rb_customer.isSelected()) {
					//�û�
					boolean isExist = SelectTable.isExist_Customer(tf_user.getText(), tf_password.getText());
					if(isExist) {
						JOptionPane.showMessageDialog(null, "��ӭʹ��", "�û���¼�ɹ�", JOptionPane.OK_CANCEL_OPTION);
					}else {
						JOptionPane.showMessageDialog(null, "��������ȷ���û�������", "�û���¼ʧ��", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					//����Ա
					boolean isExist = SelectTable.isExist_Manager(tf_user.getText(), tf_password.getText());
					if(isExist) {
						JOptionPane.showMessageDialog(null, "��ӭʹ��", "����Ա��¼�ɹ�", JOptionPane.OK_CANCEL_OPTION);
						MaintoManager();
					}else {
						JOptionPane.showMessageDialog(null, "��������ȷ���û�������", "����Ա��¼ʧ��", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}else if(e.getSource() == btn_register) {
			//���ע�ᰴť
			//�ж��û��������Ƿ�Ϊ��
			if (tf_user.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�û�������Ϊ��", "ע��ʧ��", JOptionPane.ERROR_MESSAGE);
			} else if (tf_password.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "ע��ʧ��", JOptionPane.ERROR_MESSAGE);
			}else {
				//�ж����û����ǹ���Ա
				if(rb_customer.isSelected()) {
					boolean isExist = SelectTable.isExist_Customer_user(tf_user.getText(), tf_password.getText());
					if(isExist) {
						JOptionPane.showMessageDialog(null, "���û��Ѿ�����", "�û�ע��ʧ��", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "��ӭ��", "�û�ע��ɹ�", JOptionPane.OK_CANCEL_OPTION);
						SelectTable.regist_Customer(tf_user.getText(),  tf_password.getText());
					}
				}else {
					boolean isExist = SelectTable.isExist_Manager_user(tf_user.getText(), tf_password.getText());
					if(isExist) {
						JOptionPane.showMessageDialog(null, "�ù���Ա�Ѿ�����", "����Աע��ʧ��", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "��ӭ��", "����Աע��ɹ�", JOptionPane.OK_CANCEL_OPTION);
						SelectTable.regist_Manager(tf_user.getText(),  tf_password.getText());
					}
				}
			}
		} else if(e.getSource() == btn_changePassword) {
			if (tf_user.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�û�������Ϊ��", "�޸�ʧ��", JOptionPane.ERROR_MESSAGE);
			} else if (tf_password.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "�޸�ʧ��", JOptionPane.ERROR_MESSAGE);
			}else {
				//�ж����û����ǹ���Ա
				if(rb_customer.isSelected()) {
					//�û�
					boolean isExist = SelectTable.isExist_Customer(tf_user.getText(), tf_password.getText());
					if(isExist) {
						String newPassword = JOptionPane.showInputDialog("������������");
						if (!newPassword.equals("")) {
							SelectTable.changePassword_Customer(tf_user.getText(), tf_password.getText(), newPassword);
							JOptionPane.showMessageDialog(null, "��ӭʹ��", "�޸�����ɹ�", JOptionPane.OK_CANCEL_OPTION);
						}else {
							JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "�޸�����ʧ��", JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "��������ȷ���û�������", "�޸�����ʧ��", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					//����Ա
					boolean isExist = SelectTable.isExist_Manager(tf_user.getText(), tf_password.getText());
					if(isExist) {
						String newPassword = JOptionPane.showInputDialog("������������");
						if (!newPassword.equals("")) {
							SelectTable.changePassword_Manager(tf_user.getText(), tf_password.getText(), newPassword);
							JOptionPane.showMessageDialog(null, "��ӭʹ��", "�޸�����ɹ�", JOptionPane.OK_CANCEL_OPTION);
						}else {
							JOptionPane.showMessageDialog(null, "���벻��Ϊ��", "�޸�����ʧ��", JOptionPane.ERROR_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "��������ȷ���û�������", "�޸�����ʧ��", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			
		}
	}
}


