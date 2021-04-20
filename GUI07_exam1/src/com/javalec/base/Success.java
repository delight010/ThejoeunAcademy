package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;

public class Success extends JDialog {
	private JLabel lblSuccess;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Success dialog = new Success();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Success() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		getContentPane().add(getLblSuccess());

	}

	private JLabel getLblSuccess() {
		if (lblSuccess == null) {
			lblSuccess = new JLabel("환영합니다");
			lblSuccess.setFont(new Font("굴림", Font.PLAIN, 25));
			lblSuccess.setBounds(153, 91, 165, 72);
		}
		return lblSuccess;
	}
}
