package org.didi.BlackFridayApp.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;

public class EmployeeLogin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					EmployeeLogin window = new EmployeeLogin();
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
	public EmployeeLogin() {
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

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(275, 54, 96, 122);
		frame.getContentPane().add(scrollBar);

		JButton btnAdd = new JButton("add");
		btnAdd.setBounds(171, 23, 89, 23);
		frame.getContentPane().add(btnAdd);

		JButton btnEdit = new JButton("edit");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEdit.setBounds(171, 70, 89, 23);
		frame.getContentPane().add(btnEdit);

		JButton btnRemove = new JButton("remove");
		btnRemove.setBounds(171, 130, 89, 23);
		frame.getContentPane().add(btnRemove);

		JButton btnBlackFriday = new JButton("black friday");
		btnBlackFriday.setBounds(171, 183, 89, 23);
		frame.getContentPane().add(btnBlackFriday);

		JButton btnRegulationOfTransaction = new JButton("regulation of transaction");
		btnRegulationOfTransaction.setBounds(68, 227, 192, 23);
		frame.getContentPane().add(btnRegulationOfTransaction);

		JTextPane txtpnProducts = new JTextPane();
		txtpnProducts.setText("products");
		txtpnProducts.setBounds(282, 23, 89, 20);
		frame.getContentPane().add(txtpnProducts);
	}

}
