package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mailServer.contact;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Add_contact extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JLabel lblNewLabel;
	private JLabel lblPleaseFillAll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_contact frame = new Add_contact();
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
	public Add_contact() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 35, 837, 168);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Contact_Mail:");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(0, 49, 143, 41);
		panel.add(label);
		
		JLabel label_1 = new JLabel("name:");
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(0, 1, 143, 37);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBounds(139, 0, 470, 37);
		panel.add(textField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(51, 204, 255));
		panel_1.setBounds(655, 82, 144, 41);
		panel.add(panel_1);
		
		JLabel label_2 = new JLabel("Add:");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().length()==0||textArea.getText().length()==0) {
					if(textField.getText().length()==0&&textArea.getText().length()!=0) {
						lblPleaseFillAll.setText("please enter the name.");
					}
					else if(textField.getText().length()!=0&&textArea.getText().length()==0) {
						lblPleaseFillAll.setText("please enter the contact_mail.");
					}
					else {
						lblPleaseFillAll.setText("please fill all data. ");
					}
					lblPleaseFillAll.setVisible(true);
				}
				else {
					contact contact=new contact();
					contact.setFolder(signIn.app.folder);
					contact.setName(textField.getText());	
					String email=textArea.getText();
					String[] email1=email.split("\n");
					
					for(int i=0;i<email1.length;i++) {
						try {
							contact.setEmails(email1[i]);
							lblNewLabel.setVisible(false);
							lblPleaseFillAll.setVisible(false);
						}
						catch(Exception e2) {
							lblNewLabel.setVisible(true);
							lblPleaseFillAll.setVisible(false);
						}
					}
					/*if(contact.getName().isEmpty() || contact.getFirstEmail().isEmpty() || contact.getFirstEmail().length()==0) {
						lblPleaseFillAll.setVisible(true);
					}
					else*/ if(!signIn.app.folder.checkContactName(contact.getName())) {
						lblPleaseFillAll.setVisible(true);
						lblPleaseFillAll.setText("Contact is exist");
					}
					else {
						lblPleaseFillAll.setText("please fill all data:");
						lblPleaseFillAll.setVisible(false);
						try {
							contact.addContact();
							setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							dispose();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(new Color(51,204,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(51,102,204));
			}
		});
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setHorizontalTextPosition(SwingConstants.CENTER);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_2.setBackground(new Color(51, 102, 204));
		label_2.setBounds(0, 0, 144, 41);
		panel_1.add(label_2);
		
		lblNewLabel = new JLabel("mail not in server or you should  enter the emails one per each line ");
		lblNewLabel.setVisible(false);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(68, 127, 572, 41);
		panel.add(lblNewLabel);
		
		lblPleaseFillAll = new JLabel("please fill all data:");
		lblPleaseFillAll.setVisible(false);
		lblPleaseFillAll.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPleaseFillAll.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseFillAll.setForeground(Color.RED);
		lblPleaseFillAll.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPleaseFillAll.setBackground(Color.WHITE);
		lblPleaseFillAll.setBounds(619, 23, 208, 41);
		panel.add(lblPleaseFillAll);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(139, 49, 470, 74);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 20));
		scrollPane.setViewportView(textArea);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 140, 0));
		panel_2.setBounds(0, 0, 837, 36);
		contentPane.add(panel_2);
		
		JLabel label_3 = new JLabel("X");
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		label_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_3.setBounds(808, 0, 19, 36);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("-");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_4.setBounds(776, 0, 19, 36);
		panel_2.add(label_4);
		
		JLabel lblAddcontactform = new JLabel("AddContactForm:");
		lblAddcontactform.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddcontactform.setBounds(260, 0, 157, 36);
		panel_2.add(lblAddcontactform);
		this.setLocationRelativeTo(null);;
	}
}
