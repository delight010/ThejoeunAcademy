package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI07_exam1 {

	private JFrame frame;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JTextField tfUser;
	private JPasswordField pfPassword;
	private JButton btnOK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI07_exam1 window = new GUI07_exam1();
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
	public GUI07_exam1() {
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
		frame.getContentPane().add(getLblUser());
		frame.getContentPane().add(getLblPassword());
		frame.getContentPane().add(getTfUser());
		frame.getContentPane().add(getPfPassword());
		frame.getContentPane().add(getBtnOK());
	}

	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("User");
			lblUser.setBounds(33, 41, 57, 15);
		}
		return lblUser;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setBounds(33, 97, 57, 15);
		}
		return lblPassword;
	}
	private JTextField getTfUser() {
		if (tfUser == null) {
			tfUser = new JTextField();
			tfUser.setBounds(127, 38, 116, 21);
			tfUser.setColumns(10);
		}
		return tfUser;
	}
	private JPasswordField getPfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.setBounds(127, 94, 116, 21);
		}
		return pfPassword;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String User = tfUser.getText(); // user 불러오기
					char[]str = pfPassword.getPassword(); // 패스워드 불러오기
					String passString = new String(str);								
					
					if(User.equals("abc")&&passString.equals("1234")) {
						Success success = new Success();
						success.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "입력하신 정보가 맞지 않습니다.");
					}
					
					
				}
			});
			btnOK.setBounds(296, 93, 97, 23);
		}
		return btnOK;
	}
}
