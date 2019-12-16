package org.didi.BlackFridayApp.gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BeginningWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BeginningWindow window = new BeginningWindow();
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
	public BeginningWindow() {
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

		JButton btnNewButton = new JButton("sing in ");
		btnNewButton.setBounds(42, 43, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("sing up");
		btnNewButton_1.setBounds(42, 127, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
