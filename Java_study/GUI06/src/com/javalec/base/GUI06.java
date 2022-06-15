package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI06 { // 메뉴바 액션 이벤트 만들기

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem menuAdd;
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JTextField tfResult;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI06 window = new GUI06();
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
	public GUI06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(getMenuBar());
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfNum1());
		frame.getContentPane().add(getTfNum2());
		frame.getContentPane().add(getTfResult());
		frame.getContentPane().add(getBtnAdd());
	}

	private JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("File");
		}
		return mnNewMenu;
	}
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("Calc");
			mnNewMenu_1.add(getMenuAdd());
		}
		return mnNewMenu_1;
	}
	private JMenuItem getMenuAdd() {
		if (menuAdd == null) {
			menuAdd = new JMenuItem("Add");
			menuAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addAction();
				}
			});
		}
		return menuAdd;
	}
	private JTextField getTfNum1() {
		if (tfNum1 == null) {
			tfNum1 = new JTextField();
			tfNum1.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum1.setBounds(34, 33, 116, 21);
			tfNum1.setColumns(10);
		}
		return tfNum1;
	}
	private JTextField getTfNum2() {
		if (tfNum2 == null) {
			tfNum2 = new JTextField();
			tfNum2.setHorizontalAlignment(SwingConstants.TRAILING);
			tfNum2.setBounds(34, 94, 116, 21);
			tfNum2.setColumns(10);
		}
		return tfNum2;
	}
	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setHorizontalAlignment(SwingConstants.TRAILING);
			tfResult.setBounds(34, 152, 116, 21);
			tfResult.setColumns(10);
		}
		return tfResult;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addAction();
				}
			});
			btnAdd.setBounds(186, 151, 97, 23);
		}
		return btnAdd;
	}
	
	//--------------------------------------------------------
	
	private void addAction() {
		int num1 = Integer.parseInt(tfNum1.getText());
		int num2 = Integer.parseInt(tfNum2.getText());
		tfResult.setText(Integer.toString(num1+num2));
		
	}
	
	
}//---------------------
