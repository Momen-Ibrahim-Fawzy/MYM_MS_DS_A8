package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import linkedList.doubleLinkedList;
import mailServer.IFilter;
import mailServer.IMail;
import mailServer.ISort;
import mailServer.filter;
import mailServer.mail;
import mailServer.sort;

@SuppressWarnings("serial")
public class mail_form extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnInbox;
	private JButton btnSent;
	private JButton btnDraft;
	private JButton btnTrash;
	private JTextField textField;
	public static JTable table;
	private JPanel panel_8;
	private Object[][] rec = {
	         {null, null, null },
		     {null, null, null },
	         {null, null, null },
	         {null, null, null },
	         {null, null, null },
	         {null, null, null },
	         {null, null, null },
	         {null, null, null },
	         {null, null, null },
	         {null, null, null },
	      };
	private Object[] header = {"Subject", "Reciever", "Date"};
	private int []check_box=new int[10]; 
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JCheckBox checkBox_4;
	private JCheckBox checkBox_5;
	private JCheckBox checkBox_6;
	private JCheckBox checkBox_7;
	private JCheckBox checkBox_8;
	private JCheckBox checkBox_9;
	private signIn signin=new signIn();
	public static mailInfoShow c=new mailInfoShow();
	public static int [] num_page= {1,1,1,1,1};
	private ISort sort=new sort();
	private IFilter filter=new filter();
	private JTextField textField_1;
	private JLabel lblNewLabel_5;
	private JPanel panel_13;
	private contact_show contactshow=new contact_show();
	public static String id="";
	private JLabel lblSearch;
	private static compose_jframe compose=new compose_jframe();
	private JPanel panel_17;
	private static boolean cv=true;
	

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mail_form frame = new mail_form();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.getMessage();
				}
			}
			
		});
		
	}

	/**
	 * Create the frame.
	 */
	public mail_form() {
		sort.setType("sortByDateNewestToOldest");
		Image images1=new ImageIcon(this.getClass().getResource("/Annotation 2020-04-25 020705.jpg")).getImage();
		Image images2=new ImageIcon(this.getClass().getResource("/Untitled.png")).getImage();
		Image images3=new ImageIcon(this.getClass().getResource("/2.png")).getImage();
		Image images4=new ImageIcon(this.getClass().getResource("/3.png")).getImage();
		Image images5=new ImageIcon(this.getClass().getResource("/Annotation 2020-04-27 192220.jpg")).getImage();
		Image images6=new ImageIcon(this.getClass().getResource("/Annotation 2020-04-27 193217.jpg")).getImage();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1304, 798);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		panel.setBounds(0, 0, 1304, 29);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(1275, 0, 19, 29);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("-");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(1246, 0, 19, 29);
		panel.add(label);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMail.setBounds(598, 0, 42, 29);
		panel.add(lblMail);
		
		JLabel lblDataStructureProject = new JLabel("Data Structure Project.");
		lblDataStructureProject.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDataStructureProject.setBounds(20, 0, 223, 29);
		panel.add(lblDataStructureProject);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 29, 445, 86);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(images1));
		lblNewLabel_2.setBounds(0, 0, 447, 86);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 115, 205, 683);
		contentPane.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		panel_3.setPreferredSize(new Dimension(202, 130));
		panel_2.add(panel_3);
		btnNewButton = new JButton("Contact");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setIcon(new ImageIcon(images4));
				btnInbox.setIcon(new ImageIcon(images2));
				btnSent.setIcon(new ImageIcon(images2));
				btnDraft.setIcon(new ImageIcon(images2));
				btnTrash.setIcon(new ImageIcon(images2));
				table.setModel(new DefaultTableModel(10, 1));
				change_title_name("Name:",0);
				num_page[0]=1;
				panel_13.setVisible(true);
				lblSearch.setText("Search for Contact");
				fill_contact(table,num_page[0]);
			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setSelectedIcon(new ImageIcon(images4));
		btnNewButton.setRolloverIcon(new ImageIcon(images3));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(images2));
		btnNewButton.setPreferredSize(new Dimension(200, 70));
		panel_2.add(btnNewButton);
		
		btnInbox = new JButton("Inbox");
		btnInbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter.setType("");
				btnNewButton.setIcon(new ImageIcon(images2));
				btnInbox.setIcon(new ImageIcon(images4));
				btnSent.setIcon(new ImageIcon(images2));
				btnDraft.setIcon(new ImageIcon(images2));
				btnTrash.setIcon(new ImageIcon(images2));
				table.setModel(new DefaultTableModel(10, 3));
				change_title_name("Subject:",0);
				change_title_name("Sender:",1);
				change_title_name("Date:",2);
				panel_13.setVisible(false);
				lblSearch.setText("SearchBysender:");
				fill_inbox_table(table,num_page[1]);
			}
		});
		btnInbox.setFocusPainted(false);
		btnInbox.setFocusTraversalKeysEnabled(false);
		btnInbox.setBorderPainted(false);
		btnInbox.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnInbox.setSelectedIcon(new ImageIcon(images4));
		btnInbox.setRolloverIcon(new ImageIcon(images3));
		btnInbox.setForeground(Color.WHITE);
		btnInbox.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInbox.setIcon(new ImageIcon(images2));
		btnInbox.setPreferredSize(new Dimension(200, 70));
		panel_2.add(btnInbox);
		
		btnSent = new JButton("Sent");
		btnSent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter.setType("");
				btnNewButton.setIcon(new ImageIcon(images2));
				btnInbox.setIcon(new ImageIcon(images2));
				btnSent.setIcon(new ImageIcon(images4));
				btnDraft.setIcon(new ImageIcon(images2));
				btnTrash.setIcon(new ImageIcon(images2));
				table.setModel(new DefaultTableModel(10, 3));
				change_title_name("Subject:",0);
				change_title_name("Reciever:",1);
				change_title_name("Date:",2);
				panel_13.setVisible(false);
				lblSearch.setText("SearchByReciever:");
				fill_sent_table(table ,num_page[2]);
			}
		});
		btnSent.setFocusPainted(false);
		btnSent.setFocusTraversalKeysEnabled(false);
		btnSent.setBorderPainted(false);
		btnSent.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSent.setForeground(Color.WHITE);
		btnSent.setIcon(new ImageIcon(images2));
		btnSent.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSent.setRolloverIcon(new ImageIcon(images3));
		btnSent.setSelectedIcon(new ImageIcon(images4));
		btnSent.setPreferredSize(new Dimension(200, 70));
		panel_2.add(btnSent);
		
		btnDraft = new JButton("Draft");
		btnDraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter.setType("");
				btnNewButton.setIcon(new ImageIcon(images2));
				btnInbox.setIcon(new ImageIcon(images2));
				btnSent.setIcon(new ImageIcon(images2));
				btnDraft.setIcon(new ImageIcon(images4));
				btnTrash.setIcon(new ImageIcon(images2));
				table.setModel(new DefaultTableModel(10, 3));
				change_title_name("Subject:",0);
				change_title_name("Reciever:",1);
				change_title_name("Date:",2);
				panel_13.setVisible(false);
				lblSearch.setText("SearchByReciever:");
				fill_Draft_table( table ,num_page[3]);
				
			}
		});
		btnDraft.setFocusPainted(false);
		btnDraft.setFocusTraversalKeysEnabled(false);
		btnDraft.setBorderPainted(false);
		btnDraft.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDraft.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDraft.setRolloverIcon(new ImageIcon(images3));
		btnDraft.setSelectedIcon(new ImageIcon(images4));
		btnDraft.setIcon(new ImageIcon(images2));
		btnDraft.setForeground(Color.WHITE);
		btnDraft.setPreferredSize(new Dimension(200, 70));
		panel_2.add(btnDraft);
		
		btnTrash = new JButton("Trash");
		btnTrash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter.setType("");
				btnNewButton.setIcon(new ImageIcon(images2));
				btnInbox.setIcon(new ImageIcon(images2));
				btnSent.setIcon(new ImageIcon(images2));
				btnDraft.setIcon(new ImageIcon(images2));
				btnTrash.setIcon(new ImageIcon(images4));
				table.setModel(new DefaultTableModel(10, 4));
				change_title_name("Subject:",0);
				change_title_name("Sender:",1);
				change_title_name("Reciever:",2);
				change_title_name("Date:",3);
				panel_13.setVisible(false);
				lblSearch.setText("SearchBysender:");
				fill_Trash_table(table ,num_page[4]);
			}
		});
		btnTrash.setFocusPainted(false);
		btnTrash.setFocusTraversalKeysEnabled(false);
		btnTrash.setBorderPainted(false);
		btnTrash.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTrash.setSelectedIcon(new ImageIcon(images4));
		btnTrash.setRolloverIcon(new ImageIcon(images3));
		btnTrash.setHorizontalTextPosition(SwingConstants.CENTER);
		btnTrash.setIcon(new ImageIcon(images2));
		btnTrash.setForeground(Color.WHITE);
		btnTrash.setPreferredSize(new Dimension(200, 70));
		panel_2.add(btnTrash);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(455, 65, 668, 42);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 24));
		textField.setBounds(186, 0, 482, 42);
		panel_4.add(textField);
		textField.setColumns(10);
		
		panel_17 = new JPanel();
		panel_17.setBounds(0, 0, 187, 42);
		panel_4.add(panel_17);
		panel_17.setLayout(null);
		panel_17.setBackground(Color.BLACK);
		
		lblSearch = new JLabel("Search:");
		lblSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(panel_17);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetcolor(panel_17);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				File file= new File(signin.app.folder.getPath());
				if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Inbox")) {
					filter.setType("filterBySender");
					if(textField.getText().length()==0) {
						lblNewLabel_5.setVisible(true);
					}
					else {
						lblNewLabel_5.setVisible(false);
						filter.setSender(textField.getText());
						sort_table(table);
					}
				}
				else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Trash")) {
					filter.setType("filterBySender");
					if(textField.getText().length()==0) {
						lblNewLabel_5.setVisible(true);
					}
					else {
						lblNewLabel_5.setVisible(false);
						filter.setSender(textField.getText());
						sort_table(table);
					}
				}
				else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Sent")) {
					filter.setType("filterByReceiver");
					if(textField.getText().length()==0) {
						lblNewLabel_5.setVisible(true);
					}
					else {
						lblNewLabel_5.setVisible(false);
						filter.setReceiver(textField.getText());
						sort_table(table);
					}
				}
				else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Draft")) {
					filter.setType("filterByReceiver");
					if(textField.getText().length()==0) {
						lblNewLabel_5.setVisible(true);
					}
					else {
						lblNewLabel_5.setVisible(false);
						filter.setReceiver(textField.getText());
						sort_table(table);
					}
				}
				else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Contact")) {
					filter.setType("filterContactByName");
					if(textField.getText().length()==0) {
						lblNewLabel_5.setVisible(true);
					}
					else {
						lblNewLabel_5.setVisible(false);
						filter.setNameOfContact(textField.getText());
						sort_table(table);
					}
				}
			}
		});
		lblSearch.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSearch.setBackground(Color.BLACK);
		lblSearch.setBounds(0, 0, 187, 42);
		panel_17.add(lblSearch);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(226, 126, 83, 35);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBackground(Color.BLACK);
		menuBar_1.setBounds(0, 0, 82, 38);
		panel_5.add(menuBar_1);
		
		JMenu mnNewMenu_1 = new JMenu("Filter:");
		mnNewMenu_1.setForeground(Color.WHITE);
		mnNewMenu_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		menuBar_1.add(mnNewMenu_1);
		
		JMenuItem menuItem = new JMenuItem("ByDate");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter.setType("filterByDate");
				if(textField_1.getText().length()==0)
					lblNewLabel_5.setVisible(true);
				else {
					lblNewLabel_5.setVisible(false);
					try {
						Date date =  new SimpleDateFormat("dd/MM/yyyy").parse(textField_1.getText());
						filter.setDate(date);
						sort_table(table);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.getMessage();
					}
					
				}
				
			}
		});
		menuItem.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_1.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("BySubject");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter.setType("filterBySubject");
				if(textField_1.getText().length()==0)
					lblNewLabel_5.setVisible(true);
				else {
					lblNewLabel_5.setVisible(false);
					filter.setSubject(textField_1.getText());
					sort_table(table);
				}
			}
		});
		menuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_1.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("BySender");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter.setType("filterBySender");
				if(textField_1.getText().length()==0)
					lblNewLabel_5.setVisible(true);
				else {
					lblNewLabel_5.setVisible(false);
					filter.setSender(textField_1.getText());
					sort_table(table);
				}
			}
		});
		menuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_1.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("ByPriority");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter.setType("filterByPriority");
				if(textField_1.getText().length()==0)
					lblNewLabel_5.setVisible(true);
				else {
					lblNewLabel_5.setVisible(false);
					filter.setPriority(Integer.parseInt(textField_1.getText()));
					sort_table(table);
				}
			}
		});
		menuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("ByNumOfReceivers");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter.setType("filterByNumOfReceivers");
				if(textField_1.getText().length()==0)
					lblNewLabel_5.setVisible(true);
				else {
					lblNewLabel_5.setVisible(false);
					filter.setNumOfReceivers(Integer.parseInt(textField_1.getText()));
					sort_table(table);
				}
			}
		});
		menuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("ByNumOfAttachments");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter.setType("filterByNumOfAttachments");
				if(textField_1.getText().length()==0)
					lblNewLabel_5.setVisible(true);
				else {
					lblNewLabel_5.setVisible(false);
					filter.setNumOfAttachments(Integer.parseInt(textField_1.getText()));
					sort_table(table);
				}
			}
		});
		menuItem_5.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_1.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("ByNumOfLinesInBody");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter.setType("filterByNumOfLinesInBody");
				if(textField_1.getText().length()==0)
					lblNewLabel_5.setVisible(true);
				else {
					lblNewLabel_5.setVisible(false);
					filter.setNumOfLinesInBody(Integer.parseInt(textField_1.getText()));
					sort_table(table);
				}
			}
		});
		menuItem_6.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_1.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("ByNumOfWordsInBody");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter.setType("filterByNumOfWordsInBody");
				if(textField_1.getText().length()==0)
					lblNewLabel_5.setVisible(true);
				else {
					lblNewLabel_5.setVisible(false);
					filter.setNumOfWordsInBody(Integer.parseInt(textField_1.getText()));
					sort_table(table);
				}
			}
		});
		menuItem_7.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_1.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("ByNumOfLettersInBody");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter.setType("filterByNumOfLettersInBody");
				if(textField_1.getText().length()==0)
					lblNewLabel_5.setVisible(true);
				else {
					lblNewLabel_5.setVisible(false);
					filter.setNumOfLettersInBody(Integer.parseInt(textField_1.getText()));
					sort_table(table);
				}
			}
		});
		menuItem_8.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_1.add(menuItem_8);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Cancel");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filter.setType("");
				textField_1.setText("");
				lblNewLabel_5.setVisible(false);
				sort_table(table);
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(225, 172, 69, 35);
		contentPane.add(panel_6);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBackground(Color.BLACK);
		menuBar_2.setBounds(0, 0, 67, 38);
		panel_6.add(menuBar_2);
		
		JMenu mnNewMenu_2 = new JMenu("Sort:");
		mnNewMenu_2.setForeground(Color.WHITE);
		mnNewMenu_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 24));
		menuBar_2.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("ByDateNewestToOldest");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortByDateNewestToOldest");
				sort_table(table);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmBydateoldesttonewest = new JMenuItem("ByDateOldestToNewest");
		mntmBydateoldesttonewest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortByDateOldestToNewest");
				sort_table(table);
			}
		});
		mntmBydateoldesttonewest.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_2.add(mntmBydateoldesttonewest);
		
		JMenuItem mntmAscendingbysubject = new JMenuItem("AscendingBySubject");
		mntmAscendingbysubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortAscendingBySubject");
				sort_table(table);
			}
		});
		mntmAscendingbysubject.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_2.add(mntmAscendingbysubject);
		
		JMenuItem mntmDescendingbysubject = new JMenuItem("DescendingBySubject");
		mntmDescendingbysubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortDescendingBySubject");
				sort_table(table);
			}
		});
		mntmDescendingbysubject.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_2.add(mntmDescendingbysubject);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("AscendingBySender");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortAscendingBySender");
				sort_table(table);
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmDescendingbysender = new JMenuItem("DescendingBySender");
		mntmDescendingbysender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortDescendingBySender");
				sort_table(table);
			}
		});
		mntmDescendingbysender.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_2.add(mntmDescendingbysender);
		
		JMenuItem mntmAscendingbypriority = new JMenuItem("AscendingByPriority");
		mntmAscendingbypriority.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortAscendingByPriority");
				sort_table(table);
			}
		});
		mntmAscendingbypriority.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_2.add(mntmAscendingbypriority);
		
		JMenuItem mntmDescendingbypriority = new JMenuItem("DescendingByPriority");
		mntmDescendingbypriority.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortDescendingByPriority");
				sort_table(table);
			}
		});
		mntmDescendingbypriority.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mnNewMenu_2.add(mntmDescendingbypriority);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("AscendingByNumOfLinesInBody");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortAscendingByNumOfLinesInBody");
				sort_table(table);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmDescendingbynumoflinesinbody = new JMenuItem("DescendingByNumOfLinesInBody");
		mntmDescendingbynumoflinesinbody.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortDescendingByNumOfLinesInBody");
				sort_table(table);
			}
		});
		mntmDescendingbynumoflinesinbody.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_2.add(mntmDescendingbynumoflinesinbody);
		
		JMenuItem mntmAscendingbynumofwordsinbody = new JMenuItem("AscendingByNumOfWordsInBody");
		mntmAscendingbynumofwordsinbody.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortAscendingByNumOfWordsInBody");
				sort_table(table);
			}
		});
		mntmAscendingbynumofwordsinbody.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_2.add(mntmAscendingbynumofwordsinbody);
		
		JMenuItem mntmDescendingbynumofwordsinbody = new JMenuItem("DescendingByNumOfWordsInBody");
		mntmDescendingbynumofwordsinbody.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortDescendingByNumOfWordsInBody");
				sort_table(table);
			}
		});
		mntmDescendingbynumofwordsinbody.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_2.add(mntmDescendingbynumofwordsinbody);
		
		JMenuItem mntmAscendingbynumoflettersinbody = new JMenuItem("AscendingByNumOfLettersInBody");
		mntmAscendingbynumoflettersinbody.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortAscendingByNumOfLettersInBody");
				sort_table(table);
			}
		});
		mntmAscendingbynumoflettersinbody.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_2.add(mntmAscendingbynumoflettersinbody);
		
		JMenuItem mntmDescendingbynumoflettersinbody = new JMenuItem("DescendingByNumOfLettersInBody");
		mntmDescendingbynumoflettersinbody.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortDescendingByNumOfLettersInBody");
				sort_table(table);
			}
		});
		mntmDescendingbynumoflettersinbody.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_2.add(mntmDescendingbynumoflettersinbody);
		
		JMenuItem mntmAscendingbynumofreceivers = new JMenuItem("AscendingByNumOfReceivers");
		mntmAscendingbynumofreceivers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortAscendingByNumOfReceivers");
				sort_table(table);
			}
		});
		mntmAscendingbynumofreceivers.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_2.add(mntmAscendingbynumofreceivers);
		
		JMenuItem mntmDescendingbynumofreceivers = new JMenuItem("DescendingByNumOfReceivers");
		mntmDescendingbynumofreceivers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortDescendingByNumOfReceivers");
				sort_table(table);
			}
		});
		mntmDescendingbynumofreceivers.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_2.add(mntmDescendingbynumofreceivers);
		
		JMenuItem mntmAscendingbynumofattachments = new JMenuItem("AscendingByNumOfAttachments");
		mntmAscendingbynumofattachments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortAscendingByNumOfAttachments");
				sort_table(table);
			}
		});
		mntmAscendingbynumofattachments.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_2.add(mntmAscendingbynumofattachments);
		
		JMenuItem mntmDescendingbynumofattachments = new JMenuItem("DescendingByNumOfAttachments");
		mntmDescendingbynumofattachments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort.setType("sortDescendingByNumOfAttachments");
				sort_table(table);
			}
		});
		mntmDescendingbynumofattachments.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_2.add(mntmDescendingbynumofattachments);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.BLACK);
		panel_7.setBounds(1122, 145, 182, 53);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Compose");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(panel_7);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetcolor(panel_7);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				compose.radioButton_8.setSelected(true);
				compose.setVisible(true);
				compose.setLocationRelativeTo(null);
				compose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 0, 182, 53);
		panel_7.add(lblNewLabel_1);
		
		panel_8 = new JPanel();
		panel_8.setForeground(Color.WHITE);
		panel_8.setBackground(Color.LIGHT_GRAY);
		panel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_8.setBounds(232, 291, 911, 375);
		contentPane.add(panel_8);
		panel_8.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Set view information:", TitledBorder.CENTER, TitledBorder.TOP));
		table = new JTable(rec, header);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				File file= new File(signin.app.folder.getPath());
				
				if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Contact")) {
					try {
						signin.app.setViewingOptions(signin.app.folder,filter,sort);
						File[] contacts=signin.app.folder.listContact(num_page[0],signin.app.getMailsToBeShown());
						String name=contacts[index].getName();
						String[] name1=name.split(".txt");
						contactshow.textField.setText(name1[0]);
						File f=new File(contacts[index].getPath());
						FileReader fr = new FileReader(f);
						BufferedReader in=new BufferedReader(fr);
						String line;
						int i=0;
						while((line=in.readLine())!=null) {
							contactshow.table.setValueAt(line, i, 0);
							i++;
						}
						in.close();
					}
					catch(Exception e9) {
						   e9.getMessage();
					 }
					contactshow.setVisible(true);
					contactshow.setLocationRelativeTo(null);
					contactshow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}   
			   else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Inbox")) {
				   mail_form_show(index,num_page[1]);
				   
				}
				else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Sent")) {
					 mail_form_show(index,num_page[2]);
				}
				else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Draft")) {
					 compose.setVisible(true);
					//mail_form_show(index,num_page[3]);
					compose.textArea_1.setText("");
					compose.textArea.setText("");
					compose.textArea_2.setText("");
					compose.textArea_3.setText("");
					
					try {
						   signin.app.setViewingOptions(signin.app.folder, filter, sort);
						   IMail [] info=signin.app.listEmails(num_page[3]);
						   
						 
						   
						   String reciever = "";
							while(!info[index].getReceiver().isEmpty()) {
								reciever+=info[index].getReceiver().dequeue().toString();
								reciever+="\n";
							}
							compose.textArea_1.setText(reciever);
							compose.textArea_3.setText(info[index].getTextBody());
							//compose.lblNewLabel_2.setText(info[index].getDate().toString());
							compose.textArea_2.setText(info[index].getSubject());
							File att = new File(signin.app.folder.getPath()+"/"+Integer.toString(info[index].getId())+"/attachments");
							id=att.getPath();
							String atta="";
							File[] att1=att.listFiles();
							for(int i=0;i<att1.length;i++) {
								atta+=att1[i].getPath();
								atta+="\n";
							}
							  File file1=new File(signin.app.folder.getPath()+"/"+Integer.toString(info[index].getId()));
							   signin.app.folder.deleteFolder(file1.getPath());
					   }
					   catch(Exception e9) {
						   e9.getMessage();
					   }
					  
					   compose.setLocationRelativeTo(null);
					   compose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					  
				}
				else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Trash")) {
					 mail_form_show(index,num_page[4]);
				}
			}
		});
		table.setRowHeight(30);
		((javax.swing.border.TitledBorder) panel_8.getBorder()).setTitleFont(new Font("Arial", Font.ITALIC, 24));
		panel_8.repaint();
		table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 18));
		table.getTableHeader().setReorderingAllowed(false);
		table.setFont(new Font("Tahoma", Font.BOLD, 16));
		table.setDefaultEditor(Object.class,null);
		panel_8.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_8.add(scrollPane);
		getContentPane().add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.LIGHT_GRAY);
		panel_9.setBounds(212, 247, 396, 42);
		contentPane.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Next");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(206, 0, 136, 42);
		panel_9.add(lblNewLabel_3);
		
		JLabel lblPrevious = new JLabel("previous");
		lblPrevious.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPrevious.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPrevious.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrevious.setBounds(60, 0, 136, 42);
		panel_9.add(lblPrevious);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file= new File(signin.app.folder.getPath());
				File[] files = file.listFiles();
		        doubleLinkedList mails = new doubleLinkedList();
		        for (int i=0 ; i<files.length;i++){
		            if (files[i].isDirectory()){
		                mails.add(files[i]);
		            }
		        }
		        int num=0;
		        if(mails.size()%10==0){
		        	num=mails.size()/10;
		        }
		        else {
		        	num=(mails.size()/10)+1;
		        }

		        doubleLinkedList contacts = new doubleLinkedList();
		        for (int i=0 ; i<files.length;i++){
		        	if (files[i].isFile()){
		        		contacts.add(files[i]);
		        	}
		        }
		        int num1=0;
		        if(contacts.size()%10==0){
		        	num1=contacts.size()/10;
		        }
		        else {
		        	num1=(contacts.size()/10)+1;
		        }
			   if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Contact")&& (num_page[0]<num1)) {
						num_page[0]++;
						remove_table(table);
						fill_contact(table,num_page[0]);
			   }
			   else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Inbox")&& (num_page[1]<num)) {
						num_page[1]++;
						remove_table(table);
						fill_inbox_table(table,num_page[1]);
			   }
			   else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Sent") &&num_page[2]<num) {
						num_page[2]++;
						remove_table(table);
						fill_sent_table( table ,num_page[2]);
			   }
			   else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Draft")&&num_page[3]<num) {
						num_page[3]++;
						remove_table(table);
						fill_Draft_table( table ,num_page[3]);
			   }
			   else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Trash")&&num_page[4]<num) {
						num_page[4]++;
						remove_table(table);
						fill_Trash_table( table , num_page[4]);
			   }
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setIcon(new ImageIcon(images5));
		btnNewButton_1.setBounds(336, 0, 64, 42);
		panel_9.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file= new File(signin.app.folder.getPath());
			      
			 if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Contact")&& (num_page[0]>1)) {
							num_page[0]--;
							remove_table(table);
							fill_contact(table,num_page[0]);
				}   
			 else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Inbox")&& (num_page[1]>1)) {
						num_page[1]--;
						remove_table(table);
						fill_inbox_table(table,num_page[1]);
				}
				else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Sent") &&num_page[2]>1) {
						num_page[2]--;
						remove_table(table);
						fill_sent_table( table ,num_page[2]);
				}
				else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Draft")&&num_page[3]>1) {
						num_page[3]--;
						remove_table(table);
						fill_Draft_table( table ,num_page[3]);
				}
				else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Trash")&&num_page[4]>1) {
						num_page[4]--;
						remove_table(table);
						fill_Trash_table( table , num_page[4]);
				}
			}
		});
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setIcon(new ImageIcon(images6));
		btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBounds(0, 0, 63, 42);
		panel_9.add(btnNewButton_2);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.LIGHT_GRAY);
		panel_10.setBounds(212, 291, 21, 375);
		contentPane.add(panel_10);
		panel_10.setLayout(null);
		
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
		checkBox.setBounds(0, 62, 21, 23);
		panel_10.add(checkBox);
		
		checkBox_1 = new JCheckBox("");
		checkBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_1.isSelected()&&table.getValueAt(1,0)!=null)
					check_box[1]=1;
				else
					check_box[1]=0;
			}
		});
		checkBox_1.setBounds(0, 92, 21, 23);
		panel_10.add(checkBox_1);
		checkBox_1.setBackground(Color.LIGHT_GRAY);
		
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
		checkBox_2.setBounds(0, 121, 21, 23);
		panel_10.add(checkBox_2);
		
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
		checkBox_3.setBounds(0, 149, 21, 23);
		panel_10.add(checkBox_3);
		
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
		checkBox_4.setBounds(0, 181, 21, 23);
		panel_10.add(checkBox_4);
		
		checkBox_5 = new JCheckBox("");
		checkBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_5.isSelected()&&table.getValueAt(5,0)!=null)
					check_box[5]=1;
				else
					check_box[5]=0;
			}
		});
		checkBox_5.setBackground(Color.LIGHT_GRAY);
		checkBox_5.setBounds(0, 211, 21, 23);
		panel_10.add(checkBox_5);
		
		checkBox_6 = new JCheckBox("");
		checkBox_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_6.isSelected()&&table.getValueAt(6,0)!=null)
					check_box[6]=1;
				else
					check_box[6]=0;
			}
		});
		checkBox_6.setBackground(Color.LIGHT_GRAY);
		checkBox_6.setBounds(0, 237, 21, 23);
		panel_10.add(checkBox_6);
		
		checkBox_7 = new JCheckBox("");
		checkBox_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_7.isSelected()&&table.getValueAt(7,0)!=null)
					check_box[7]=1;
				else
					check_box[7]=0;
			}
		});
		checkBox_7.setBackground(Color.LIGHT_GRAY);
		checkBox_7.setBounds(0, 269, 21, 23);
		panel_10.add(checkBox_7);
		
		checkBox_8 = new JCheckBox("");
		checkBox_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_8.isSelected()&&table.getValueAt(8,0)!=null)
					check_box[8]=1;
				else
					check_box[8]=0;
			}
		});
		checkBox_8.setBackground(Color.LIGHT_GRAY);
		checkBox_8.setBounds(0, 300, 21, 23);
		panel_10.add(checkBox_8);
		
		checkBox_9 = new JCheckBox("");
		checkBox_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox_9.isSelected()&&table.getValueAt(9,0)!=null)
					check_box[9]=1;
				else
					check_box[9]=0;
			}
		});
		checkBox_9.setBackground(Color.LIGHT_GRAY);
		checkBox_9.setBounds(0, 328, 21, 23);
		panel_10.add(checkBox_9);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.BLACK);
		panel_11.setBounds(1133, 29, 171, 59);
		contentPane.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("SignOut");
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cv=true;
				signin.app.folder.setPath("System");
				signin.setVisible(true);
				signin.setLocationRelativeTo(null);
				signin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(panel_11);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetcolor(panel_11);
			}
		});
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(0, 0, 171, 59);
		panel_11.add(lblNewLabel_4);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBackground(Color.BLACK);
		panel_12.setBounds(961, 236, 182, 53);
		contentPane.add(panel_12);
		
		JLabel lblDelete = new JLabel("Delete:");
		lblDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(panel_12);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetcolor(panel_12);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				File file= new File(signin.app.folder.getPath());
				IMail[] mail = new mail[10];
				doubleLinkedList list=new doubleLinkedList();
				File[] contact = new File[10];
				
				if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Contact")) {
					try{
						signin.app.setViewingOptions(signin.app.folder,filter,sort);
						contact=signin.app.folder.listContact(num_page[0],signin.app.getMailsToBeShown());
					}catch(Exception e1){
						e1.getMessage();
					}
				}
				
				if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Inbox")) {
						try{mail=signin.app.listEmails(num_page[1]);
						}catch(Exception e1) {
							e1.getMessage();
						}
				}
				else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Sent")) {
					try{mail=signin.app.listEmails(num_page[2]);
					}catch(Exception e1) {
						e1.getMessage();
					}
				}
				else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Draft")) {
					try{mail=signin.app.listEmails(num_page[3]);
					}catch(Exception e1) {
						e1.getMessage();
					}
				}
				else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Trash")) {
					try{mail=signin.app.listEmails(num_page[4]);
					}catch(Exception e1) {
						e1.getMessage();
					}
				}
				
				
				if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Contact")) {
					for(int i=0 ; i<10 ; i++) {
						if(check_box[i]==1) {
							File file1=contact[i];
							list.add(file1);	
							check_box[i]=0;
						}
					}
				}
				else {
					for(int i=0 ; i<10 ; i++) {
						if(check_box[i]==1) {
							File file1=new File(signin.app.folder.getPath()+"/"+Integer.toString(mail[i].getId()));
							list.add(file1);
							
							check_box[i]=0;
						}
					}
					
					
				}
				if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Contact")) {
					for(int i=0 ; i<list.size() ; i++)  {
						File file1=(File)list.get(i);
				        file1.delete();
					}
				}
				else {
				signin.app.deleteEmails(list);
				}
				sort_table(table);
				set_checkbox();
			}
		});
		lblDelete.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setForeground(Color.WHITE);
		lblDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDelete.setBackground(Color.BLACK);
		lblDelete.setBounds(0, 0, 182, 53);
		panel_12.add(lblDelete);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_1.setBounds(309, 126, 299, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_5 = new JLabel("please enter your filter type:");
		lblNewLabel_5.setVisible(false);
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(711, 126, 262, 35);
		contentPane.add(lblNewLabel_5);
		
		panel_13 = new JPanel();
		panel_13.setVisible(false);
		panel_13.setLayout(null);
		panel_13.setBackground(Color.BLACK);
		panel_13.setBounds(212, 667, 227, 53);
		contentPane.add(panel_13);
		
		JLabel lblAddcontact = new JLabel("Add_Contact:");
		lblAddcontact.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAddcontact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(panel_13);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				resetcolor(panel_13);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Add_contact c =new Add_contact();
				c.setVisible(true);
				c.setLocationRelativeTo(null);
				c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		lblAddcontact.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAddcontact.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddcontact.setForeground(Color.WHITE);
		lblAddcontact.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddcontact.setBackground(Color.BLACK);
		lblAddcontact.setBounds(0, 0, 227, 53);
		panel_13.add(lblAddcontact);
		//this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	void setcolor(JPanel panel) {
		panel.setBackground(new Color(105,105,105));
	}
	void resetcolor(JPanel panel) {
		panel.setBackground(new Color(0,0,0));
	}
	private void change_title_name(String name,int colm) {
		JTableHeader th = table.getTableHeader();
		TableColumnModel tcm = th.getColumnModel();
		TableColumn tc = tcm.getColumn(colm);
		tc.setHeaderValue( name );
		th.repaint();
	}
	private void set_checkbox() {
		checkBox.setSelected(false);
		checkBox_1.setSelected(false);
		checkBox_2.setSelected(false);
		checkBox_3.setSelected(false);
		checkBox_4.setSelected(false);
		checkBox_5.setSelected(false);
		checkBox_6.setSelected(false);
		checkBox_7.setSelected(false);
		checkBox_8.setSelected(false);
		checkBox_9.setSelected(false);
	}
	private  static void remove_table(JTable table) {
		for(int i=0;i<table.getRowCount();i++) {
			for(int j=0; j<table.getColumnCount();j++) {
				table.setValueAt("", i, j);
			}
		}
	}
	public void fill_inbox_table(JTable table, int pachage) {		
		String [] arr=signin.app.folder.getPath().split("/",5);
		while(arr.length>2) {
			signin.app.folder.setPath(signin.app.folder.backStep());
			arr=signin.app.folder.getPath().split("/",5);
		}
		signin.app.folder.setPath(signin.app.folder.getPath()+"/Inbox");	
		try {
			if (sort.getType()=="sortContactAscending"|sort.getType()=="sortContactDescending"){
				sort.setType("");
			}
			signin.app.setViewingOptions(signin.app.folder,filter, sort);
			IMail [] info=signin.app.listEmails(pachage);
			for(int i=0 ; i<info.length;i++) {
				if(info[i]==null) {
					break;
				}
				table.setValueAt(info[i].getSubject(),i, 0);
				table.setValueAt(info[i].getSender(),i, 1);
				table.setValueAt(info[i].getDate(),i, 2);
			}
		}catch(Exception e1){
			e1.getMessage();
		}
	}

	public void fill_sent_table(JTable table , int pachage) {
		String [] arr=signin.app.folder.getPath().split("/",5);
		while(arr.length>2) {
			signin.app.folder.setPath(signin.app.folder.backStep());
			arr=signin.app.folder.getPath().split("/",5);
		}
		signin.app.folder.setPath(signin.app.folder.getPath()+"/Sent");
		try {
			if (sort.getType()=="sortContactAscending"|sort.getType()=="sortContactDescending"){
				sort.setType("");
			}
			signin.app.setViewingOptions(signin.app.folder,filter, sort);
			IMail [] info=signin.app.listEmails(pachage);
			for(int i=0 ; i<info.length;i++) {
				if(info[i]==null) {
					break;
				}
				table.setValueAt(info[i].getSubject(),i, 0);
				String reciever ="";
				while(!info[i].getReceiver().isEmpty()) {
					reciever+=info[i].getReceiver().dequeue().toString();
					if(!info[i].getReceiver().isEmpty()) {
						reciever+=",";
					}
				}
				table.setValueAt(reciever,i, 1);
				table.setValueAt(info[i].getDate(),i, 2);
			}
		}catch(Exception e1) {
			e1.getMessage();
		}
	}


	@SuppressWarnings("static-access")
	public  void fill_Draft_table(JTable table , int pachage) {
		String [] arr=signin.app.folder.getPath().split("/",5);
		while(arr.length>2) {
			signin.app.folder.setPath(signin.app.folder.backStep());
			arr=signin.app.folder.getPath().split("/",5);
		}
		signin.app.folder.setPath(signin.app.folder.getPath()+"/Draft");
		try {
			if (sort.getType()=="sortContactAscending"|sort.getType()=="sortContactDescending"){
				sort.setType("");
			}
			signin.app.setViewingOptions(signin.app.folder,filter, sort);
			IMail [] info=signin.app.listEmails(pachage);
			for(int i=0 ; i<info.length;i++) {
				if(info[i]==null) {
					break;
				}
				table.setValueAt(info[i].getSubject(),i, 0);
				String reciever ="";
				while(!info[i].getReceiver().isEmpty()) {
					reciever+=info[i].getReceiver().dequeue().toString();
					if(!info[i].getReceiver().isEmpty()) {
						reciever+=",";
					}
				}
				table.setValueAt(reciever,i, 1);
				table.setValueAt(info[i].getDate(),i, 2);
			}
		}catch(Exception e1) {
			e1.getMessage();
		}
	}


	@SuppressWarnings("static-access")
	public void fill_Trash_table(JTable table , int pachage) {
		String [] arr=signin.app.folder.getPath().split("/",5);
		while(arr.length>2) {
			signin.app.folder.setPath(signin.app.folder.backStep());
			arr=signin.app.folder.getPath().split("/",5);
		}
		signin.app.folder.setPath(signin.app.folder.getPath()+"/Trash");
		try {
			if (sort.getType()=="sortContactAscending"|sort.getType()=="sortContactDescending"){
				sort.setType("");
			}
			signin.app.setViewingOptions(signin.app.folder, filter, sort);
			IMail [] info=signin.app.listEmails(pachage);
			for(int i=0 ; i<info.length;i++) {
				if(info[i]==null) {
					break;
				}
				table.setValueAt(info[i].getSubject(),i, 0);
				String reciever ="";
				while(!info[i].getReceiver().isEmpty()) {
					reciever+=info[i].getReceiver().dequeue().toString();
					if(!info[i].getReceiver().isEmpty()) {
						reciever+=",";
					}
				}
				table.setValueAt(info[i].getSender(),i, 1);
				table.setValueAt(reciever,i, 2);
				table.setValueAt(info[i].getDate(),i,3);
			}
		}catch(Exception e1) {
			e1.getMessage();
		}
	}

	@SuppressWarnings("static-access")
	public void fill_contact(JTable table , int pachage) {
		String [] arr=signin.app.folder.getPath().split("/",5);
		while(arr.length>2) {
			signin.app.folder.setPath(signin.app.folder.backStep());
			arr=signin.app.folder.getPath().split("/",5);
		}
		signin.app.folder.setPath(signin.app.folder.getPath()+"/Contact");
		try {
			if (sort.getType()!="sortContactAscending"&sort.getType()!="sortContactDescending"){
				sort.setType("");
			}
			signin.app.setViewingOptions(signin.app.folder,filter,sort);
			File [] info=signin.app.folder.listContact(pachage,signin.app.getMailsToBeShown());
		
        for(int i=0 ; i<info.length;i++) {
			if(info[i]==null) {
				break;
			}
			
			String name=info[i].getName();
			String[] name1=name.split(".txt");
			table.setValueAt(name1[0],i, 0);
		}
		}
        catch(Exception e1) {
			e1.getMessage();
		}
        
	}
	private void mail_form_show(int index,int n) {
		c.textArea_1.setText("");
		c.textArea.setText("");
		c.lblNewLabel_2.setText("");
		c.lblNewLabel_3.setText("");
		remove_table(c.table);
		try {
			   signin.app.setViewingOptions(signin.app.folder, filter, sort);
			   IMail [] info=signin.app.listEmails(n);
			   String reciever = "";
				while(!info[index].getReceiver().isEmpty()) {
					reciever+=info[index].getReceiver().dequeue().toString();
					reciever+="\n";
				}
				c.textArea_1.setText(reciever);
				c.textArea.setText(info[index].getTextBody());
				c.lblNewLabel_2.setText(info[index].getDate().toString());
				c.lblNewLabel_3.setText(info[index].getSubject());
				File att = new File(signin.app.folder.getPath()+"/"+Integer.toString(info[index].getId())+"/attachments");
				id=att.getPath();
				File[] att1=att.listFiles();
				for(int i=0;i<att1.length;i++) {
					c.table.setValueAt(att1[i].getName(), i, 0);
					
				}
		}
		catch(Exception e9) {
		   e9.getMessage();
		}
		c.setVisible(true);
		c.setLocationRelativeTo(null);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void sort_table(JTable table) {
		File file= new File(signin.app.folder.getPath());
		if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Contact")) {
			num_page[0]=1;
			remove_table(table);
			fill_contact(table,num_page[0]);
		}   
		else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Inbox")) {
				num_page[1]=1;
				remove_table(table);
				fill_inbox_table(table,num_page[1]);
		}
		else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Sent")) {
				num_page[2]=1;
				remove_table(table);
				fill_sent_table( table ,num_page[2]);
		}
		else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Draft")) {
				num_page[3]=1;
				remove_table(table);
				fill_Draft_table( table ,num_page[3]);
		}
		else if(signin.app.folder.checkEqualityOfTwoStrings(file.getName(), "Trash")) {
				num_page[4]=1;
				remove_table(table);
				fill_Trash_table( table , num_page[4]);
		}
	}
	
}
