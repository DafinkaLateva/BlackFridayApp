package org.didi.BlackFridayApp.gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class ClientLogin extends JFrame {

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
					ClientLogin frame = new ClientLogin();
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
	public ClientLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAddToShopcart = new JButton("add to shopcart");
		btnAddToShopcart.setBounds(36, 181, 123, 23);
		contentPane.add(btnAddToShopcart);

		JButton btnLogOut = new JButton("log out ");
		btnLogOut.setBounds(226, 181, 89, 23);
		contentPane.add(btnLogOut);

		JButton btnBuy = new JButton("buy");
		btnBuy.setBounds(226, 144, 89, 23);
		contentPane.add(btnBuy);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(245, 23, 70, 107);
		contentPane.add(scrollBar);

		JList list = new JList();
		list.setBounds(85, 11, -60, 49);
		contentPane.add(list);

		textField = new JTextField();
		textField.setBounds(29, 141, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JTextPane txtpnAmount = new JTextPane();
		txtpnAmount.setText("amount");
		txtpnAmount.setBounds(29, 110, 100, 20);
		contentPane.add(txtpnAmount);
	}
}
