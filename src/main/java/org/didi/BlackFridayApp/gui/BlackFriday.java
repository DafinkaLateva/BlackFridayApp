package org.didi.BlackFridayApp.gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class BlackFriday extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BlackFriday frame = new BlackFriday();
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
	public BlackFriday() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane txtpnProducts = new JTextPane();
		txtpnProducts.setText("products");
		txtpnProducts.setBounds(10, 41, 87, 20);
		contentPane.add(txtpnProducts);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(39, 94, 69, 67);
		contentPane.add(scrollBar);

		JTextPane txtpnDiscount = new JTextPane();
		txtpnDiscount.setText("discount");
		txtpnDiscount.setBounds(161, 41, 48, 20);
		contentPane.add(txtpnDiscount);

		textField = new JTextField();
		textField.setBounds(131, 72, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnAdd = new JButton("add");
		btnAdd.setBounds(131, 138, 89, 23);
		contentPane.add(btnAdd);

		JButton btnSave = new JButton("save");
		btnSave.setBounds(131, 183, 89, 23);
		contentPane.add(btnSave);
	}

}
