package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import mailServer.app;
import mailServer.contact;
import mailServer.folder;

public class
register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblPleaseEnterPasswird;
	private JLabel lblNotTheSame;
	private JLabel lblPleaseEnterYour;
	private app test1=new app();
	private folder f=new folder();
	private contact test2=new contact();
	private signIn signin=new signIn();
	private boolean check2=false;
	private String name;
	private String user;
	private String pass;
	private String birth;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JDateChooser dateChooser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
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
	public register() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 807);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 959, 807);
		contentPane.add(panel);
		panel.setLayout(null);
		Image images=new ImageIcon(this.getClass().getResource("/WhatsApp Image 2020-04-24 at 12.04.52 AM.jpeg")).getImage();
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBackground(new Color(255, 0, 0));
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(927, 0, 22, 36);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("-");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBackground(new Color(255, 0, 0));
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_2.setBounds(895, 0, 22, 36);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(517, 114, 80, 25);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PassWord:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(512, 211, 107, 36);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("check password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(479, 278, 154, 25);
		panel.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField.setBounds(631, 120, 271, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 18));
		passwordField.setBounds(629, 223, 273, 20);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		passwordField_1.setBounds(631, 283, 271, 20);
		panel.add(passwordField_1);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(512, 163, 124, 25);
		panel.add(lblUsername);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(631, 169, 271, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_6 = new JLabel("BirthDate:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(496, 350, 110, 25);
		panel.add(lblNewLabel_6);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(631, 355, 271, 20);
		panel.add(dateChooser);
		
		JLabel lblNewLabel_7 = new JLabel("Gender:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_7.setBounds(517, 419, 89, 25);
		panel.add(lblNewLabel_7);
		
		rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					rdbtnNewRadioButton_1.setSelected(false);
					test2.setGender("male");
				}
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnNewRadioButton.setBounds(660, 421, 80, 23);
		panel.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton_1.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
					test2.setGender("female");
				}
			}
		});
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		rdbtnNewRadioButton_1.setBounds(804, 421, 98, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(name);
				name=textField.getText();
				user=textField_1.getText();
				pass=passwordField.getText();
				if(!f.checkEqualityOfTwoStrings(passwordField_1.getText(),pass)) 
					lblNotTheSame.setVisible(true);
				else
					lblNotTheSame.setVisible(false);
				if(f.checkExistUsername(user)&&user.length()!=0)
					lblNewLabel_9.setVisible(true);
				else
					lblNewLabel_9.setVisible(false);
				if(name.length()==0||user.length()==0||pass.length()==0||dateChooser.getDate()==null) {
					if(name.length()==0)
						lblNewLabel_8.setVisible(true);
					else
						lblNewLabel_8.setVisible(false);
					if(user.length()==0)
						lblNewLabel_10.setVisible(true);
					else
						lblNewLabel_10.setVisible(false);
					if(pass.length()==0)
						lblPleaseEnterPasswird.setVisible(true);
					else
						lblPleaseEnterPasswird.setVisible(false);
					if(dateChooser.getDate()==null)
						lblPleaseEnterYour.setVisible(true);	
					else
						lblPleaseEnterYour.setVisible(false);
					
				}
				else {
					lblNotTheSame.setVisible(false);
					lblNewLabel_9.setVisible(false);
					lblNewLabel_8.setVisible(false);
					lblNewLabel_10.setVisible(false);
					lblPleaseEnterPasswird.setVisible(false);
					lblPleaseEnterYour.setVisible(false);
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
					}
					signin.app.folder.setPath(signin.app.folder.getPath()+"/"+user);     
					mail_form z=new mail_form();
					z.setVisible(true);
					z.setLocationRelativeTo(null);
					z.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					dispose();
				}
			}
		});
		btnNewButton.setBackground(new Color(51, 153, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(646, 502, 118, 36);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
				rdbtnNewRadioButton_1.setSelected(false);
				rdbtnNewRadioButton.setSelected(false);
				dateChooser.setCalendar(null);
				
			}
		});
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(803, 502, 114, 36);
		panel.add(btnNewButton_1);
		
		lblNewLabel_8 = new JLabel("please enter name:");
		lblNewLabel_8.setVisible(false);
		lblNewLabel_8.setForeground(new Color(255, 0, 0));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_8.setBounds(685, 137, 199, 25);
		panel.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("user name is already used:");
		lblNewLabel_9.setVisible(false);
		lblNewLabel_9.setForeground(new Color(255, 0, 0));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_9.setBounds(646, 187, 271, 25);
		panel.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("please enter username:");
		lblNewLabel_10.setVisible(false);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_10.setForeground(new Color(255, 0, 0));
		lblNewLabel_10.setBounds(660, 186, 249, 30);
		panel.add(lblNewLabel_10);
		
		lblPleaseEnterPasswird = new JLabel("please enter passwird:");
		lblPleaseEnterPasswird.setVisible(false);
		lblPleaseEnterPasswird.setForeground(Color.RED);
		lblPleaseEnterPasswird.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPleaseEnterPasswird.setBounds(660, 242, 249, 30);
		panel.add(lblPleaseEnterPasswird);
		
		lblNotTheSame = new JLabel("Not the same password:");
		lblNotTheSame.setVisible(false);
		lblNotTheSame.setForeground(Color.RED);
		lblNotTheSame.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNotTheSame.setBounds(660, 314, 249, 30);
		panel.add(lblNotTheSame);
		
		lblPleaseEnterYour = new JLabel("Please enter your bith day:");
		lblPleaseEnterYour.setVisible(false);
		lblPleaseEnterYour.setForeground(Color.RED);
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPleaseEnterYour.setBounds(631, 384, 286, 30);
		panel.add(lblPleaseEnterYour);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(images));
		lblNewLabel.setBounds(0, 0, 959, 807);
		panel.add(lblNewLabel);
		this.setLocationRelativeTo(null);
	}
}
