package org.didi.BlackFridayApp.gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class LoginPage {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("log in");
		btnNewButton.setBounds(289, 99, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setText("      username");
		txtpnUsername.setBounds(22, 48, 96, 20);
		frame.getContentPane().add(txtpnUsername);

		textField = new JTextField();
		textField.setBounds(22, 79, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setText("      password");
		txtpnPassword.setBounds(22, 184, 96, 20);
		frame.getContentPane().add(txtpnPassword);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(22, 213, 96, 20);
		frame.getContentPane().add(textPane);
	}
}
