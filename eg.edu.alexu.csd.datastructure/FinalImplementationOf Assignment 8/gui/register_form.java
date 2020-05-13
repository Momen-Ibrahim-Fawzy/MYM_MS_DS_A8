package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.Cursor;
import com.toedter.calendar.JDateChooser;

import mailServer.app;
import mailServer.contact;
import mailServer.folder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class register_form extends JFrame {

	private JPanel contentPane;
	private String name;
	private String user;
	private String pass;
	private String birth;
	private JTextField textField_1;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private app test1=new app();
	private folder f=new folder();
	private contact test2=new contact();
	private boolean check2=false;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnNewRadioButton;
	private JLabel lblNewLabel;
	private JDateChooser dateChooser;
	private JLabel lblNewLabel_1;
	private JLabel lblPleaseEnterUsername;
	private JLabel lblPleaseEnterPasswird;
	private JLabel lblNotTheSame;
	private JLabel lblGmailIsCreate;
	private JLabel lblNewLabel_2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register_form frame = new register_form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public register_form() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 451, 56);
		contentPane.add(panel);
		
		Label label = new Label("Register");
		label.setFont(new Font("Dialog", Font.BOLD, 24));
		label.setBounds(10, 0, 148, 56);
		panel.add(label);
		
		Label label_1 = new Label("X");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		label_1.setFont(new Font("Dialog", Font.BOLD, 24));
		label_1.setBounds(421, 0, 19, 56);
		panel.add(label_1);
		
		Label label_2 = new Label("-");
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		label_2.setFont(new Font("Dialog", Font.BOLD, 24));
		label_2.setBounds(396, 0, 19, 56);
		panel.add(label_2);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 56, 451, 527);
		contentPane.add(panel_1);
		
		JLabel label_3 = new JLabel("User Name:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(23, 82, 120, 40);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Password:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(23, 147, 120, 40);
		panel_1.add(label_4);
		
		JButton btnCancel = new JButton("Create");
		btnCancel.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				System.out.print(name);
				name=textField_1.getText();
				user=textField.getText();
				pass=passwordField.getText();
				if(!f.checkEqualityOfTwoStrings(passwordField_1.getText(),pass)) 
					lblNotTheSame.setVisible(true);
				else
					lblNotTheSame.setVisible(false);
				if(f.checkExistUsername(user)&&user.length()!=0)
					lblNewLabel_2.setVisible(true);
				else
					lblNewLabel_2.setVisible(false);
				if(name.length()==0||user.length()==0||pass.length()==0||dateChooser.getDate()==null) {
					if(name.length()==0)
						lblNewLabel.setVisible(true);
					else
						lblNewLabel.setVisible(false);
					if(user.length()==0)
						lblPleaseEnterUsername.setVisible(true);
					else
						lblPleaseEnterUsername.setVisible(false);
					if(pass.length()==0)
						lblPleaseEnterPasswird.setVisible(true);
					else
						lblPleaseEnterPasswird.setVisible(false);
					if(dateChooser.getDate()==null)
						lblNewLabel_1.setVisible(true);	
					else
						lblNewLabel_1.setVisible(false);
					
				}
				else {
					lblNewLabel_2.setVisible(false);
					lblNewLabel.setVisible(false);
					lblPleaseEnterUsername.setVisible(false);
					lblPleaseEnterPasswird.setVisible(false);
					lblNewLabel_1.setVisible(false);
					lblNotTheSame.setVisible(false);
					SimpleDateFormat dformat=new SimpleDateFormat("dd/MM/yyyy");			
					birth= dformat.format(dateChooser.getDate());
					test2.setName(name);
					test2.setEmails(user);
					test2.setPassword(pass);
					test2.setBirthDate(birth);
					if(test2.checkContactForSignUp()) {
						check2=test1.signup(test2);
					}
					if(check2==true) {
						test1.folder.creatUsersFolder(test2);
						lblGmailIsCreate.setVisible(true);
					}
				}
				
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancel.setBackground(new Color(30, 144, 255));
		btnCancel.setBounds(73, 445, 101, 40);
		panel_1.add(btnCancel);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
			}
		});
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRefresh.setBackground(Color.RED);
		btnRefresh.setBounds(278, 445, 118, 40);
		panel_1.add(btnRefresh);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(23, 23, 120, 40);
		panel_1.add(lblName);
		
		JLabel lblBirthdata = new JLabel("BirthDate:");
		lblBirthdata.setForeground(Color.WHITE);
		lblBirthdata.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBirthdata.setBounds(23, 287, 120, 40);
		panel_1.add(lblBirthdata);
		
		JLabel lblAddress = new JLabel("Check Password");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddress.setBounds(10, 210, 164, 40);
		panel_1.add(lblAddress);
		
		JLabel lblClickHereTo = new JLabel("Click here to login:");
		lblClickHereTo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				signIn c=new signIn();
				c.setVisible(true);
				c.setLocationRelativeTo(null);
				c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		lblClickHereTo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblClickHereTo.setForeground(Color.WHITE);
		lblClickHereTo.setBackground(Color.GREEN);
		lblClickHereTo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblClickHereTo.setBounds(135, 496, 187, 20);
		panel_1.add(lblClickHereTo);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(153, 37, 243, 20);
		panel_1.add(textField_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(153, 96, 243, 20);
		panel_1.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.LIGHT_GRAY);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField.setBounds(153, 159, 243, 20);
		panel_1.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordField_1.setBackground(Color.LIGHT_GRAY);
		passwordField_1.setBounds(153, 220, 243, 20);
		panel_1.add(passwordField_1);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(23, 355, 120, 40);
		panel_1.add(lblGender);
		
		rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					rdbtnFemale.setSelected(false);
					test2.setGender("male");
					System.out.print(test2.getGender());
				}
			}
		});
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBackground(new Color(0, 0, 128));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		rdbtnNewRadioButton.setBounds(153, 365, 78, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnFemale.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
					test2.setGender("female");
					System.out.print(test2.getGender());
				}
			}
		});
		rdbtnFemale.setForeground(new Color(255, 255, 255));
		rdbtnFemale.setBackground(new Color(0, 0, 128));
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 17));
		rdbtnFemale.setBounds(288, 365, 87, 23);
		panel_1.add(rdbtnFemale);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(153, 301, 243, 20);
		panel_1.add(dateChooser);
		
		lblNewLabel = new JLabel("please enter name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setVisible(false);
		lblNewLabel.setBounds(184, 57, 181, 28);
		panel_1.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("user name is already used:");
		lblNewLabel_2.setVisible(false);
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(53, 121, 220, 28);
		panel_1.add(lblNewLabel_2);
		
		lblPleaseEnterUsername = new JLabel("please enter username:");
		lblPleaseEnterUsername.setVisible(false);
		lblPleaseEnterUsername.setForeground(Color.RED);
		lblPleaseEnterUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPleaseEnterUsername.setBounds(175, 120, 221, 28);
		panel_1.add(lblPleaseEnterUsername);
		
		lblPleaseEnterPasswird = new JLabel("please enter passwird:");
		lblPleaseEnterPasswird.setVisible(false);
		lblPleaseEnterPasswird.setForeground(Color.RED);
		lblPleaseEnterPasswird.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPleaseEnterPasswird.setBounds(163, 181, 212, 28);
		panel_1.add(lblPleaseEnterPasswird);
		
		lblNotTheSame = new JLabel("Not the same password:");
		lblNotTheSame.setVisible(false);
		lblNotTheSame.setForeground(Color.RED);
		lblNotTheSame.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNotTheSame.setBounds(163, 248, 233, 28);
		panel_1.add(lblNotTheSame);
		
		lblGmailIsCreate = new JLabel("Gmail is create please signin:");
		lblGmailIsCreate.setVisible(false);
		lblGmailIsCreate.setForeground(new Color(255, 255, 0));
		lblGmailIsCreate.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGmailIsCreate.setBounds(108, 406, 266, 28);
		panel_1.add(lblGmailIsCreate);
		
		lblNewLabel_1 = new JLabel("Please enter your bith day:");
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(153, 332, 243, 26);
		panel_1.add(lblNewLabel_1);
		this.setLocationRelativeTo(null);
	}
}
