package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class GUI_01_exam {

	private JFrame frame;
	private JLabel lbl01;
	private JLabel lbl02;
	public JTextField tfNum1;
	public JTextField tfNum2;
	private JTextField tfNum1_1;
	private JTextField tfNum2_1;
	private JTextField tfResult;
	private JLabel lbl03;
	private JLabel lbl01_2;
	private JButton btnPlus;
	private JButton btnSub;
	private JButton btnMul;
	private JButton btnDiv;
	
	
	
	//---------------------------------------------
	
	
	
//	public int number1 = Integer.parseInt(tfNum1.getText());
//	public int number2 = Integer.parseInt(tfNum2.getText());
	//---------------------------------------------
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_01_exam window = new GUI_01_exam();
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
	public GUI_01_exam() {
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
		frame.getContentPane().add(getLbl01());
		frame.getContentPane().add(getLbl02());
		frame.getContentPane().add(getTfNum1());
		frame.getContentPane().add(getTfNum2());
		frame.getContentPane().add(getTfNum1_1());
		frame.getContentPane().add(getTfNum2_1());
		frame.getContentPane().add(getTfResult());
		frame.getContentPane().add(getLbl03());
		frame.getContentPane().add(getLbl01_2());
		frame.getContentPane().add(getBtnPlus());
		frame.getContentPane().add(getBtnSub());
		frame.getContentPane().add(getBtnMul());
		frame.getContentPane().add(getBtnDiv());
	}

	private JLabel getLbl01() {
		if (lbl01 == null) {
			lbl01 = new JLabel("1 : ");
			lbl01.setBounds(40, 34, 33, 15);
		}
		return lbl01;
	}
	private JLabel getLbl02() {
		if (lbl02 == null) {
			lbl02 = new JLabel("2 : ");
			lbl02.setBounds(40, 59, 33, 15);
		}
		return lbl02;
	}
	private JTextField getTfNum1() {
		if (tfNum1 == null) {
			tfNum1 = new JTextField();
			tfNum1.setBounds(62, 31, 41, 21);
			tfNum1.setColumns(10);
		}
		return tfNum1;
	}
	private JTextField getTfNum2() {
		if (tfNum2 == null) {
			tfNum2 = new JTextField();
			tfNum2.setColumns(10);
			tfNum2.setBounds(62, 56, 41, 21);
		}
		return tfNum2;
	}
	private JTextField getTfNum1_1() {
		if (tfNum1_1 == null) {
			tfNum1_1 = new JTextField();
			tfNum1_1.setEditable(false);
			tfNum1_1.setColumns(10);
			tfNum1_1.setBounds(62, 151, 41, 21);
		}
		return tfNum1_1;
	}
	private JTextField getTfNum2_1() {
		if (tfNum2_1 == null) {
			tfNum2_1 = new JTextField();
			tfNum2_1.setEditable(false);
			tfNum2_1.setColumns(10);
			tfNum2_1.setBounds(155, 151, 41, 21);
		}
		return tfNum2_1;
	}
	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setEditable(false);
			tfResult.setColumns(10);
			tfResult.setBounds(267, 151, 41, 21);
		}
		return tfResult;
	}
	private JLabel getLbl03() {
		if (lbl03 == null) {
			lbl03 = new JLabel("+");
			lbl03.setHorizontalAlignment(SwingConstants.CENTER);
			lbl03.setBounds(110, 154, 33, 15);
		}
		return lbl03;
	}
	private JLabel getLbl01_2() {
		if (lbl01_2 == null) {
			lbl01_2 = new JLabel("=");
			lbl01_2.setBounds(210, 154, 33, 15);
		}
		return lbl01_2;
	}
	
	private JButton getBtnPlus() {
		if (btnPlus == null) {
			btnPlus = new JButton("+");
			btnPlus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addResult();
				}
			});
			btnPlus.setBounds(155, 34, 41, 23);
		}
		return btnPlus;
	}
	private JButton getBtnSub() {
		if (btnSub == null) {
			btnSub = new JButton("-");
			btnSub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					subResult();
				}
			});
			btnSub.setBounds(210, 34, 41, 23);
		}
		return btnSub;
	}
	private JButton getBtnMul() {
		if (btnMul == null) {
			btnMul = new JButton("x");
			btnMul.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mulResult();
				}
			});
			btnMul.setBounds(267, 34, 41, 23);
		}
		return btnMul;
	}
	private JButton getBtnDiv() {
		if (btnDiv == null) {
			btnDiv = new JButton("/");
			btnDiv.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					divResult();
				}
			});
			btnDiv.setBounds(320, 34, 41, 23);
		}
		return btnDiv;
	}
	
	
	//--------------------------------------------------------------------------------
	
	public int num1; //????????? ??????(?????????)
	public int num2; //????????? ??????(?????????)
	public int result; //??????(?????????)
	
	public void numberSet(){ // ????????? ??????
		tfNum1_1.setText(tfNum1.getText()); // tfNum1??? -> tfNum1_1 ??????
		tfNum2_1.setText(tfNum2.getText()); // tfNum2??? -> tfNum2_1 ??????
	}
	
	public void number() { //int????????? ??? ????????????
		this.num1 = Integer.parseInt(tfNum1.getText()); // int num1(??????) = tfNum1???
		this.num2 = Integer.parseInt(tfNum2.getText()); // int num2(??????) = tfNum2???
	}
	
	public void resultSet() { //????????????
		tfResult.setText(Integer.toString(result)); // Result -> String ??????
	}
	
	//---------------------------------------------------------------------------------
	
	private void addResult() {
		number();
		this.result = (num1 + num2); //?????? 	
		numberSet(); //??????
		resultSet();
		lbl03.setText("+");
	}
	
	private void subResult() {
		number();
		this.result = (num1 - num2); //??????		
		numberSet(); //????????? ??????, ????????? ????????????
		resultSet(); //?????? ??????
		lbl03.setText("-");
	}
	
	private void mulResult() {
		number();
		this.result = (num1 * num2); //??????		
		numberSet(); //????????? ??????, ????????? ????????????
		resultSet(); //?????? ??????
		lbl03.setText("x");
	}
	
	private void divResult() {
		number();
		if(num1!=0 && num2!=0) {
			if(num1>num2) {				
				this.result = (num1 / num2); //??????			
			}else {
				JOptionPane.showMessageDialog(null, "?????? ??? ????????????");
			}
		}else {
			JOptionPane.showMessageDialog(null, "?????? ??? ????????????");
		}
		numberSet(); //????????? ??????, ????????? ????????????
		resultSet(); //?????? ??????
		lbl03.setText("/");
	}
	

	

	
}
