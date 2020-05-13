package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mailServer.app;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;


public class signIn extends JFrame {

	private JPanel contentPane;
	private String text;
	private String pass;
	public static app app=new app();
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel_5;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signIn frame = new signIn();
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
	public signIn() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 807);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 959, 809);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(933, 0, 16, 45);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("-");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_2.setBounds(908, 0, 16, 45);
		panel_2.add(lblNewLabel_2);
		
		//JLabel.setIcon(new ImageIcon(images))
		JLabel lblNewLabel = new JLabel("");
		Image images=new ImageIcon(this.getClass().getResource("/WhatsApp Image 2020-04-24 at 12.04.52 AM.jpeg")).getImage();
		
		JLabel lblNewLabel_3 = new JLabel("User Name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3.setBounds(467, 192, 135, 45);
		panel_2.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("SignIn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text=textField_1.getText();
				pass=passwordField_1.getText();
				if(text.isEmpty() || pass.isEmpty()) {
					lblNewLabel_5.setVisible(true);
				}
				else if(app.signin(text, pass)) {
					lblNewLabel_5.setVisible(false);
					app.folder.setPath(app.folder.getPath()+"/"+text);
					mail_form z=new mail_form();
					z.setVisible(true);
					z.setLocationRelativeTo(null);
					z.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					dispose();
				}
				else {
					lblNewLabel_5.setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(51, 153, 255));
		btnNewButton.setBounds(636, 392, 107, 48);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SignUp");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register c=new register();
				c.setVisible(true);
				c.setLocationRelativeTo(null);
				c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(51, 153, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(825, 392, 107, 48);
		panel_2.add(btnNewButton_1);
		
		lblNewLabel_5 = new JLabel("The UserName or Password is wrong");
		lblNewLabel_5.setVisible(false);
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(572, 331, 377, 34);
		panel_2.add(lblNewLabel_5);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		passwordField_1.setBounds(612, 274, 337, 30);
		panel_2.add(passwordField_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_1.setBounds(612, 197, 337, 34);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Password:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4.setBounds(466, 271, 125, 34);
		panel_2.add(lblNewLabel_4);
		lblNewLabel.setIcon(new ImageIcon(images));
		lblNewLabel.setBounds(0, 0, 960, 809);
		panel_2.add(lblNewLabel);
		
		this.setLocationRelativeTo(null);
	}
	public String move_text() {
		return text;
	}
}
