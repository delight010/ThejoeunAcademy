package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI04_exam1 { // 비밀번호 확인 후 로그인 여부

	private JFrame frmLogin;
	private JLabel lblUser;
	private JLabel lblPasswrod;
	private JPasswordField pfPassword;
	private JTextField tfUser;
	private JTextField tfResult;
	private JButton btnOK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI04_exam1 window = new GUI04_exam1();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI04_exam1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.getContentPane().add(getLblUser());
		frmLogin.getContentPane().add(getLblPasswrod());
		frmLogin.getContentPane().add(getPfPassword());
		frmLogin.getContentPane().add(getTfUser());
		frmLogin.getContentPane().add(getTfResult());
		frmLogin.getContentPane().add(getBtnOK());
	}

	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("User");
			lblUser.setBounds(36, 42, 57, 15);
		}
		return lblUser;
	}
	private JLabel getLblPasswrod() {
		if (lblPasswrod == null) {
			lblPasswrod = new JLabel("Password");
			lblPasswrod.setBounds(36, 72, 57, 15);
		}
		return lblPasswrod;
	}
	private JPasswordField getPfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.setBounds(141, 69, 124, 21);
		}
		return pfPassword;
	}
	private JTextField getTfUser() {
		if (tfUser == null) {
			tfUser = new JTextField();
			tfUser.setBounds(141, 39, 124, 21);
			tfUser.setColumns(10);
		}
		return tfUser;
	}
	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setColumns(10);
			tfResult.setBounds(36, 152, 360, 21);
		}
		return tfResult;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("OK");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loginConfirm();
				}
			});
			btnOK.setBounds(292, 68, 97, 23);
		}
		return btnOK;
	}
	//-------------------------------------------------------------
	private void loginConfirm() {
		String User = tfUser.getText();	// id 불러오기
		char[] str = pfPassword.getPassword(); // 패드워드 불러오기
		String passString = new String(str);
			
		
		if(User.equals("abc") && passString.equals("1234")) {
			tfResult.setText("로그인 성공");
		}else {
			tfResult.setText("로그인에 실패하였습니다");
		}
	}
	
	
	
	
}//---------------------------------------------------------------
