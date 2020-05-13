package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import mailServer.IMail;
import mailServer.mail;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class compose_jframe extends JFrame {

	private JPanel contentPane;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_4;
	private JRadioButton radioButton_5;
	private JRadioButton radioButton_6;
	private JRadioButton radioButton_7;
	public static JRadioButton radioButton_8;
	private JRadioButton radioButton_3;
	public static JTextArea textArea_1;
	private JLabel label_7;
	private JLabel label_8;
	public static JTextArea textArea_3;
	public static JTextArea textArea_2;
	public static JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					compose_jframe frame = new compose_jframe();
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
	public compose_jframe() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 727);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 31, 678, 3);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 89, 678, 3);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 34, 143, 55);
		contentPane.add(panel_2);
		
		JLabel label = new JLabel("Reciever:");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(0, 0, 143, 55);
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(0, 90, 143, 55);
		contentPane.add(panel_3);
		
		JLabel label_1 = new JLabel("Subject:");
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(0, 0, 143, 55);
		panel_3.add(label_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(255, 140, 0));
		panel_4.setBounds(0, 0, 678, 31);
		contentPane.add(panel_4);
		
		JLabel label_2 = new JLabel("X");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean check1=true;
				label_7.setText("");
				if(textArea.getText().length()==0&&textArea_1.getText().length()==0&&textArea_2.getText().length()==0&&textArea_3.getText().length()==0) {
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					dispose();
				}
				else {
					IMail newMail = new mail();
					String sender= signIn.app.folder.getPath();
					String[] sender1=sender.split("/");
					try{
						newMail.setSender(sender1[1]);
					}catch(Exception e1) {
						setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						dispose();
						e1.getMessage();
					}
					
					String rec=textArea_1.getText();
					String[] rec1=rec.split("\n");
					for(int i=0;i<rec1.length;i++) {
						try {
							newMail.setReceiver(rec1[i]);
							label_7.setText("");
						}
						catch(Exception e2) {
							check1=false;
							label_7.setText("Email Not in server....change it or remove it");
						}
					}
					if(check1 || textArea_1.getText().isEmpty()) {
					newMail.setTextBody(textArea_3.getText());
					String v=textArea_3.getText();
					String[] s=v.split("\n");
					String attachment=textArea.getText();
					String[] attachment1=attachment.split("\n");
					for(int i=0;i<attachment1.length;i++) {
						try {
							if(!attachment1[i].equals("")) {
							newMail.setAttachment(new File (attachment1[i]));
							}
							label_8.setText("");
						}
						catch(Exception e2) {
							label_8.setText("Some thing wrong in attachments");
						}
					}
					newMail.setSubject(textArea_2.getText());
					newMail.setPriority(check_box());
						
							try {
								Date date=new Date();
						        newMail.setDate(date);
								newMail.draft();
								setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								dispose();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.getMessage();
							}
							
						
				
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					dispose();
					}
				}
			}
		});
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setHorizontalTextPosition(SwingConstants.CENTER);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_2.setBounds(618, 0, 60, 31);
		panel_4.add(label_2);
		
		JLabel label_3 = new JLabel("Compose Form.");
		label_3.setHorizontalTextPosition(SwingConstants.CENTER);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_3.setBounds(0, 0, 628, 31);
		panel_4.add(label_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 492, 678, 158);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 20));
		scrollPane.setViewportView(textArea);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(51, 102, 204));
		panel_5.setBounds(0, 693, 182, 34);
		contentPane.add(panel_5);
		
		JLabel label_4 = new JLabel("Sent:");
		label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_5.setBackground(new Color(51,204,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_5.setBackground(new Color(51,102,204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean check1=true;
				IMail newMail = new mail();
				
				String sender= signIn.app.folder.getPath();
				String[] sender1=sender.split("/");
				try{
					newMail.setSender(sender1[1]);
				}catch(Exception e1) {
					e1.getMessage();
				}
				String rec=textArea_1.getText();
				String[] rec1=rec.split("\n");
				for(int i=0;i<rec1.length;i++) {
					try {
						newMail.setReceiver(rec1[i]);
						label_7.setText("");
					}
					catch(Exception e2) {
						check1=false;
						label_7.setText("Email Not in server or you should enter the emails one per each line");
					}
				}
				if(check1) {
				newMail.setTextBody(textArea_3.getText());
				String v=textArea_3.getText();
				String[] s=v.split("\n");
				String attachment=textArea.getText();
				String[] attachment1=attachment.split("\n");
				for(int i=0;i<attachment1.length;i++) {
					try {
						if(!attachment1[i].equals("")) {
						newMail.setAttachment(new File (attachment1[i]));
						}
						label_8.setText("");
					}
					catch(Exception e2) {
						label_8.setText("Some thing wrong in attachments");
					}
				}
				newMail.setSubject(textArea_2.getText());
				newMail.setPriority(check_box());
					if(signIn.app.compose(newMail)) {
						try {
							Date date=new Date();
					        newMail.setDate(date);
							newMail.send();
							textArea.setText("");
							textArea_1.setText("");
							textArea_2.setText("");
							textArea_3.setText("");
							setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							dispose();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.getMessage();
						}
					}
					else {
						label_7.setText("you must fill all data");
					}
				}
			}
		});
		label_4.setHorizontalTextPosition(SwingConstants.CENTER);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 26));
		label_4.setBackground(new Color(51, 204, 255));
		label_4.setBounds(0, 0, 182, 34);
		panel_5.add(label_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(51, 102, 204));
		panel_6.setBounds(496, 693, 182, 34);
		contentPane.add(panel_6);
		
		JLabel label_5 = new JLabel("Insert:");
		label_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_6.setBackground(new Color(51,204,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_6.setBackground(new Color(51,102,204));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fc=new JFileChooser();
				FileNameExtensionFilter fileExtensionFilter = new FileNameExtensionFilter("*.mdb", "mdb");
				fc.addChoosableFileFilter(fileExtensionFilter);
	            int returnVal = fc.showDialog(textArea, "choose file");
				if (returnVal != JFileChooser.APPROVE_OPTION) {
	            } else {
	                try {
	                	String s=textArea.getText()+fc.getSelectedFile().toString()+"\n";
						textArea.setText(s);
	                } catch (Exception e1) {
	                }
	            }
			}
		});
		label_5.setHorizontalTextPosition(SwingConstants.CENTER);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 26));
		label_5.setBackground(Color.WHITE);
		label_5.setBounds(0, 0, 182, 34);
		panel_6.add(label_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(142, 34, 536, 55);
		contentPane.add(scrollPane_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		scrollPane_1.setViewportView(textArea_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(142, 92, 536, 53);
		contentPane.add(scrollPane_2);
		
		textArea_2 = new JTextArea();
		textArea_2.setLineWrap(true);
		textArea_2.setFont(new Font("Monospaced", Font.BOLD, 20));
		scrollPane_2.setViewportView(textArea_2);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(Color.BLACK);
		panel_8.setBounds(0, 147, 143, 55);
		contentPane.add(panel_8);
		
		JLabel label_6 = new JLabel("Priority:");
		label_6.setHorizontalTextPosition(SwingConstants.CENTER);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_6.setBounds(0, 0, 143, 55);
		panel_8.add(label_6);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.BLACK);
		panel_9.setBounds(0, 145, 678, 3);
		contentPane.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.BLACK);
		panel_10.setBounds(142, 148, 536, 54);
		contentPane.add(panel_10);
		panel_10.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		rdbtnNewRadioButton = new JRadioButton("1");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					radioButton_8.setSelected(false);
					radioButton_7.setSelected(false);
					radioButton_6.setSelected(false);
					radioButton_5.setSelected(false);
					radioButton_4.setSelected(false);
					radioButton_3.setSelected(false);
					radioButton_2.setSelected(false);
					radioButton_1.setSelected(false);
					radioButton.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		rdbtnNewRadioButton.setBackground(Color.BLACK);
		panel_10.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		radioButton = new JRadioButton("2");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton.isSelected()) {
					radioButton_8.setSelected(false);
					radioButton_7.setSelected(false);
					radioButton_6.setSelected(false);
					radioButton_5.setSelected(false);
					radioButton_4.setSelected(false);
					radioButton_3.setSelected(false);
					radioButton_2.setSelected(false);
					radioButton_1.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
				}
			}
		});
		radioButton.setForeground(Color.WHITE);
		radioButton.setBackground(Color.BLACK);
		panel_10.add(radioButton);
		radioButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		radioButton_1 = new JRadioButton("3");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_1.isSelected()) {
					radioButton_8.setSelected(false);
					radioButton_7.setSelected(false);
					radioButton_6.setSelected(false);
					radioButton_5.setSelected(false);
					radioButton_4.setSelected(false);
					radioButton_3.setSelected(false);
					radioButton_2.setSelected(false);
					radioButton.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
				}
			}
		});
		radioButton_1.setForeground(Color.WHITE);
		radioButton_1.setBackground(Color.BLACK);
		panel_10.add(radioButton_1);
		radioButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		radioButton_2 = new JRadioButton("4");
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_2.isSelected()) {
					radioButton_8.setSelected(false);
					radioButton_7.setSelected(false);
					radioButton_6.setSelected(false);
					radioButton_4.setSelected(false);
					radioButton_3.setSelected(false);
					radioButton_5.setSelected(false);
					radioButton_1.setSelected(false);
					radioButton.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
				}
			}
		});
		radioButton_2.setForeground(Color.WHITE);
		radioButton_2.setBackground(Color.BLACK);
		panel_10.add(radioButton_2);
		radioButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		radioButton_3 = new JRadioButton("5");
		radioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_3.isSelected()) {
					radioButton_8.setSelected(false);
					radioButton_7.setSelected(false);
					radioButton_6.setSelected(false);
					radioButton_5.setSelected(false);
					radioButton_4.setSelected(false);
					radioButton_2.setSelected(false);
					radioButton_1.setSelected(false);
					radioButton.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
				}
			}
		});
		radioButton_3.setForeground(Color.WHITE);
		radioButton_3.setBackground(Color.BLACK);
		panel_10.add(radioButton_3);
		radioButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		radioButton_4 = new JRadioButton("6");
		radioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_4.isSelected()) {
					radioButton_8.setSelected(false);
					radioButton_7.setSelected(false);
					radioButton_6.setSelected(false);
					radioButton_5.setSelected(false);
					radioButton_3.setSelected(false);
					radioButton_2.setSelected(false);
					radioButton_1.setSelected(false);
					radioButton.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
				}
			}
		});
		radioButton_4.setForeground(Color.WHITE);
		radioButton_4.setBackground(Color.BLACK);
		panel_10.add(radioButton_4);
		radioButton_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		radioButton_5 = new JRadioButton("7");
		radioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_5.isSelected()) {
					radioButton_8.setSelected(false);
					radioButton_7.setSelected(false);
					radioButton_6.setSelected(false);
					radioButton_4.setSelected(false);
					radioButton_3.setSelected(false);
					radioButton_2.setSelected(false);
					radioButton_1.setSelected(false);
					radioButton.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
				}
			}
		});
		radioButton_5.setForeground(Color.WHITE);
		radioButton_5.setBackground(Color.BLACK);
		panel_10.add(radioButton_5);
		radioButton_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		radioButton_6 = new JRadioButton("8");
		radioButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_6.isSelected()) {
					radioButton_8.setSelected(false);
					radioButton_7.setSelected(false);
					radioButton_5.setSelected(false);
					radioButton_4.setSelected(false);
					radioButton_3.setSelected(false);
					radioButton_2.setSelected(false);
					radioButton_1.setSelected(false);
					radioButton.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
				}
			}
		});
		radioButton_6.setForeground(Color.WHITE);
		radioButton_6.setBackground(Color.BLACK);
		panel_10.add(radioButton_6);
		radioButton_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		radioButton_7 = new JRadioButton("9");
		radioButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_7.isSelected()) {
					radioButton_8.setSelected(false);
					radioButton_6.setSelected(false);
					radioButton_5.setSelected(false);
					radioButton_4.setSelected(false);
					radioButton_3.setSelected(false);
					radioButton_2.setSelected(false);
					radioButton_1.setSelected(false);
					radioButton.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
				}
			}
		});
		radioButton_7.setForeground(Color.WHITE);
		radioButton_7.setBackground(Color.BLACK);
		panel_10.add(radioButton_7);
		radioButton_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		radioButton_8 = new JRadioButton("10");
		radioButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_8.isSelected()) {
					radioButton_7.setSelected(false);
					radioButton_6.setSelected(false);
					radioButton_5.setSelected(false);
					radioButton_4.setSelected(false);
					radioButton_3.setSelected(false);
					radioButton_2.setSelected(false);
					radioButton_1.setSelected(false);
					radioButton.setSelected(false);
					rdbtnNewRadioButton.setSelected(false);
				}
			}
		});
		radioButton_8.setForeground(Color.WHITE);
		radioButton_8.setBackground(Color.BLACK);
		panel_10.add(radioButton_8);
		radioButton_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.BLACK);
		panel_11.setBounds(0, 201, 678, 3);
		contentPane.add(panel_11);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 201, 678, 243);
		contentPane.add(scrollPane_3);
		
		textArea_3 = new JTextArea();
		textArea_3.setLineWrap(true);
		textArea_3.setFont(new Font("Monospaced", Font.BOLD, 20));
		scrollPane_3.setViewportView(textArea_3);
		
		JLabel lblNewLabel = new JLabel("Attachment:");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 443, 678, 47);
		contentPane.add(lblNewLabel);
		
		label_7 = new JLabel("");
		label_7.setForeground(Color.RED);
		label_7.setHorizontalTextPosition(SwingConstants.LEFT);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_7.setBounds(0, 648, 678, 45);
		contentPane.add(label_7);
		
		label_8 = new JLabel("");
		label_8.setHorizontalTextPosition(SwingConstants.LEFT);
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_8.setBounds(182, 693, 315, 34);
		contentPane.add(label_8);
		this.setLocationRelativeTo(null);
	}
	private int check_box() {
		if(rdbtnNewRadioButton.isSelected()) {
			return 1;
		}
		else if (radioButton.isSelected()) {
			return 2;
		}
		else if (radioButton_1.isSelected()) {
			return 3;
		}
		else if (radioButton_2.isSelected()) {
			return 4;
		}
		else if (radioButton_3.isSelected()) {
			return 5;
		}
		else if (radioButton_4.isSelected()) {
			return 6;
		}
		else if (radioButton_5.isSelected()) {
			return 7;
		}
		else if (radioButton_6.isSelected()) {
			return 8;
		}
		else if (radioButton_1.isSelected()) {
			return 9;
		}
		else
			return 10;
	}
}
