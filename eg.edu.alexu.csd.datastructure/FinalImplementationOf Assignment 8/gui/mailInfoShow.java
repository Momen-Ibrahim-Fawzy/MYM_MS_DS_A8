package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import javax.swing.UIManager;

public class mailInfoShow extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	public static JTextArea textArea_1;
	public static JTextArea textArea;
	public static JLabel lblNewLabel_2;
	public static JLabel lblNewLabel_3;
	private Object[][] rec = {
	         {null },
		     {null },
	         {null },
	         {null },
	         {null },
	         {null },
	         {null },
	         {null },
	         {null },
	         {null },
	      };
	private Object[] header = {"Attachment_Name"};
	public JTable table;
	private mail_form c=new mail_form();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					mailInfoShow frame = new mailInfoShow();
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
	public mailInfoShow() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1089, 668);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 23, 1089, 645);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBounds(0, 0, 166, 60);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Subject:");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(0, 0, 166, 60);
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(0, 60, 166, 55);
		panel.add(panel_5);
		
		JLabel lblReciever = new JLabel("Reciever:");
		lblReciever.setHorizontalTextPosition(SwingConstants.CENTER);
		lblReciever.setHorizontalAlignment(SwingConstants.CENTER);
		lblReciever.setForeground(Color.WHITE);
		lblReciever.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReciever.setBounds(0, 0, 166, 55);
		panel_5.add(lblReciever);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.BLACK);
		panel_6.setBounds(645, 60, 166, 55);
		panel.add(panel_6);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDate.setBounds(0, 0, 166, 55);
		panel_6.add(lblDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 116, 1089, 326);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 20));
		textArea.setLineWrap(true);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(165, 60, 481, 55);
		panel.add(panel_9);
		panel_9.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 481, 55);
		panel_9.add(scrollPane_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setBackground(Color.WHITE);
		textArea_1.setEditable(false);
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		scrollPane_1.setViewportView(textArea_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(811, 60, 278, 55);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(165, 0, 924, 60);
		panel.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 441, 1089, 204);
		panel_2.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Attachment_Name:", TitledBorder.CENTER, TitledBorder.TOP));
		panel.add(panel_2);
		table = new JTable(rec, header);
		table.setForeground(Color.BLUE);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.dispose();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
                File f=new File(c.id);
                File[] attachment=f.listFiles();
				try {
					Desktop.getDesktop().open(attachment[index]);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.getMessage();
				}
			}
		});
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setRowHeight(30);
		((javax.swing.border.TitledBorder) panel_2.getBorder()).setTitleFont(new Font("Arial", Font.ITALIC, 24));
		panel_2.repaint();
		table.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 18));
		table.getTableHeader().setReorderingAllowed(false);
		table.setFont(new Font("Tahoma", Font.BOLD, 16));
		table.setDefaultEditor(Object.class,null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane(table);
		scrollPane_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		scrollPane_2.setBounds(0, 0, 1089, 204);
		panel_2.add(scrollPane_2);
		

				
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 140, 0));
		panel_1.setBounds(0, 0, 1089, 23);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(1052, 0, 27, 25);
		panel_1.add(lblNewLabel);
		
		JLabel lblMailsenterrecieverbody = new JLabel("Mail:  (senter......reciever....body)");
		lblMailsenterrecieverbody.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMailsenterrecieverbody.setHorizontalAlignment(SwingConstants.CENTER);
		lblMailsenterrecieverbody.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMailsenterrecieverbody.setBounds(350, 0, 406, 25);
		panel_1.add(lblMailsenterrecieverbody);
		this.setLocationRelativeTo(null);
	}
}
