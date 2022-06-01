package isimArama;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class form1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	ArrayList<String> liste = new ArrayList<>(Arrays.asList(Adlar.isimler));
	DefaultListModel<String> model = new DefaultListModel<>();
	private JLabel lblNewLabel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form1 frame = new form1();
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
	public form1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setBounds(27, 20, 298, 49);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 107, 298, 382);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.BOLD, 16));
		scrollPane.setViewportView(list);
		
		Collections.sort(liste);
		for(int i=0;i<liste.size();i++) {
			model.addElement(liste.get(i));
		}
		
		list.setModel(model);
		
		lblNewLabel = new JLabel("Yasin Sa\u011Flam");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(218, 499, 107, 19);
		contentPane.add(lblNewLabel);
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				model.removeAllElements();
				list.setModel(model);
				String s= textField.getText();
				for(int i=0;i<liste.size();i++) {
					String p="";
					for(int j=0;j<s.length();j++) {
						p+=liste.get(i).charAt(j);
					}
					if(s.equals(p)) model.addElement(liste.get(i));
				}
				list.setModel(model);
				
			}
		});
		
		
	}
}
