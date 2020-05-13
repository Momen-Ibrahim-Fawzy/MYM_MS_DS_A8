package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

import mailServer.contact;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;

import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class contact_show extends JFrame {

	private JPanel contentPane;
	private Object[][] rec = {
	         {null },
		     {null },
	         {null },
	         {null },
	         {null },
	      };
	private Object[] header = {"Contact_Name"};
	public JTable table;
	private JScrollPane scrollPane;
	private JTextField textField_1;
	private JPanel panel_8;
	private JLabel lblNewLabel;
	private JLabel lblDone;
	private boolean check1=false,check2=false;
	public JTextField textField;
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JCheckBox checkBox_4;
	private int []check_box=new int[5];
	private contact contact = new contact();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					contact_show frame = new contact_show();
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
	public contact_show() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 140, 0));
		panel.setBounds(0, 0, 746, 28);
		contentPane.add(panel);
		
		JLabel label = new JLabel("X");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(709, 0, 27, 25);
		panel.add(label);
		
		JLabel lblContactshow = new JLabel("Contact_Show:");
		lblContactshow.setHorizontalTextPosition(SwingConstants.CENTER);
		lblContactshow.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactshow.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblContactshow.setBounds(168, 0, 406, 25);
		panel.add(lblContactshow);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 27, 166, 60);
		contentPane.add(panel_1);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(0, 0, 166, 60);
		panel_1.add(lblName);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.BOLD, 24));
		textField.setEditable(false);
		textField.setBounds(166, 27, 580, 60);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(22, 87, 724, 221);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 724, 221);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Contact_Name:", TitledBorder.CENTER, TitledBorder.TOP));
		panel_4.add(panel_2);
		
		
		table = new JTable(rec, header);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setRowHeight(30);
		((javax.swing.border.TitledBorder) panel_2.getBorder()).setTitleFont(new Font("Arial", Font.ITALIC, 24));
		panel_2.repaint();
		table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 18));
		table.getTableHeader().setReorderingAllowed(false);
		table.setFont(new Font("Tahoma", Font.BOLD, 16));
		table.setDefaultEditor(Object.class,null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(51, 102, 204));
		panel_3.setBounds(0, 395, 206, 40);
		contentPane.add(panel_3);
		
		JLabel lblAdd = new JLabel("Add:");
		lblAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_8.setVisible(true);
				check1=true;
				check2=false;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				 panel_3.setBackground(new Color(51,204,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(51, 102, 204));
			}
		});
		lblAdd.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setForeground(Color.WHITE);
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblAdd.setBackground(new Color(51, 204, 255));
		lblAdd.setBounds(0, 0, 204, 40);
		panel_3.add(lblAdd);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(51, 102, 204));
		panel_5.setBounds(276, 395, 206, 40);
		contentPane.add(panel_5);
		
		JLabel lblRename = new JLabel("Rename:");
		lblRename.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRename.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_8.setVisible(true);
				check2=true;
				check1=false;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_5 .setBackground(new Color(51,204,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_5 .setBackground(new Color(51, 102, 204));
			}
		});
		lblRename.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRename.setHorizontalAlignment(SwingConstants.CENTER);
		lblRename.setForeground(Color.WHITE);
		lblRename.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblRename.setBackground(new Color(51, 204, 255));
		lblRename.setBounds(0, 0, 204, 40);
		panel_5.add(lblRename);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(51, 102, 204));
		panel_6.setBounds(540, 395, 206, 40);
		contentPane.add(panel_6);
		
		JLabel lblDelete = new JLabel("Delete:");
		lblDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_8.setVisible(false);
				contact.setFolder(signIn.app.folder);
				contact.setName(textField.getText());
				
				for(int i=0 ; i<5 ; i++) {
					if(check_box[i]==1) {
						try {
							contact.deleteEmail(table.getValueAt(i,0).toString());
							table.setValueAt("", i, 0);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.getMessage();
						}	
						check_box[i]=0;
					}
				}
				set_checkbox();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_6.setBackground(new Color(51,204,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_6 .setBackground(new Color(51, 102, 204));
			}
		});
		lblDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDelete.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setForeground(Color.WHITE);
		lblDelete.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDelete.setBackground(new Color(51, 204, 255));
		lblDelete.setBounds(0, 0, 204, 40);
		panel_6.add(lblDelete);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_7.setBounds(0, 87, 21, 221);
		contentPane.add(panel_7);
		
		checkBox = new JCheckBox("");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox.isSelected()&&table.getValueAt(0,0)!=null)
					check_box[0]=1;
				else
					check_box[0]=0;
			}
		});
		checkBox.setBackground(Color.LIGHT_GRAY);
		checkBox.setBounds(0, 61, 21, 23);
		panel_7.add(checkBox);
		
		checkBox_1 = new JCheckBox("");
		checkBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_1.isSelected()&&table.getValueAt(1,0)!=null)
					check_box[1]=1;
				else
					check_box[1]=0;
			}
		});
		checkBox_1.setBackground(Color.LIGHT_GRAY);
		checkBox_1.setBounds(0, 91, 21, 23);
		panel_7.add(checkBox_1);
		
		checkBox_2 = new JCheckBox("");
		checkBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_2.isSelected()&&table.getValueAt(2,0)!=null)
					check_box[2]=1;
				else
					check_box[2]=0;
			}
		});
		checkBox_2.setBackground(Color.LIGHT_GRAY);
		checkBox_2.setBounds(0, 124, 21, 23);
		panel_7.add(checkBox_2);
		
		checkBox_3 = new JCheckBox("");
		checkBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_3.isSelected()&&table.getValueAt(3,0)!=null)
					check_box[3]=1;
				else
					check_box[3]=0;
			}
		});
		checkBox_3.setBackground(Color.LIGHT_GRAY);
		checkBox_3.setBounds(0, 150, 21, 23);
		panel_7.add(checkBox_3);
		
		checkBox_4 = new JCheckBox("");
		checkBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_4.isSelected()&&table.getValueAt(4,0)!=null)
					check_box[4]=1;
				else
					check_box[4]=0;
			}
		});
		checkBox_4.setBackground(Color.LIGHT_GRAY);
		checkBox_4.setBounds(0, 176, 21, 23);
		panel_7.add(checkBox_4);
		
		panel_8 = new JPanel();
		panel_8.setVisible(false);
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(0, 307, 746, 88);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(142, -1, 470, 37);
		panel_8.add(textField_1);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(51, 204, 255));
		panel_9.setBounds(614, 0, 132, 37);
		panel_8.add(panel_9);
		
		lblDone = new JLabel("Done:");
		lblDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(check1) {
					contact.setFolder(signIn.app.folder);
					contact.setName(textField.getText());
					try {
						contact.addEmail(textField_1.getText());
						lblNewLabel.setText("");
						textField_1.setText("");
						panel_8.setVisible(false);
						
						setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						dispose();
						
					}catch(Exception e8) {
						lblNewLabel.setText(e8.getMessage());
					}
				}
				else if (check2) {
					contact.setFolder(signIn.app.folder);
					contact.setName(textField.getText());
					if(!textField_1.getText().isEmpty()) {
					try {
						contact.renameContact(textField_1.getText());
						panel_8.setVisible(false);
						lblNewLabel.setText("");
						textField_1.setText("");
						setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						dispose();
						
					}catch(Exception e8) {
						e8.getMessage();
					}
					}
					else {
						lblNewLabel.setText("Enter the new name");
					}
				}
			}
		});
		lblDone.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDone.setHorizontalAlignment(SwingConstants.CENTER);
		lblDone.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDone.setBackground(new Color(51, 102, 204));
		lblDone.setBounds(0, 0, 132, 37);
		panel_9.add(lblDone);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(Color.BLACK);
		panel_10.setBounds(0, -1, 143, 37);
		panel_8.add(panel_10);
		
		JLabel lblNmae = new JLabel("Nmae:");
		lblNmae.setForeground(Color.WHITE);
		lblNmae.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNmae.setHorizontalAlignment(SwingConstants.CENTER);
		lblNmae.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNmae.setBackground(new Color(51, 102, 204));
		lblNmae.setBounds(0, 0, 143, 37);
		panel_10.add(lblNmae);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 35, 746, 53);
		panel_8.add(lblNewLabel);
		
	}
	private void set_checkbox() {
		checkBox.setSelected(false);
		checkBox_1.setSelected(false);
		checkBox_2.setSelected(false);
		checkBox_3.setSelected(false);
		checkBox_4.setSelected(false);
		
	}
}
