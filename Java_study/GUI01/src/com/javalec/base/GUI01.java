package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI01 {

	private JFrame frame;
	protected JTextField tfNum1;
	protected JTextField tfNum2;
	private JTextField tfResult;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI01 window = new GUI01();
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
	public GUI01() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("더하기");
		frame.setBounds(100, 100, 484, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfNum1());
		frame.getContentPane().add(getTfNum2());
		frame.getContentPane().add(getTfResult());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getBtnAdd());
	}

	private JTextField getTfNum1() {
		if (tfNum1 == null) {
			tfNum1 = new JTextField();
			tfNum1.setHorizontalAlignment(SwingConstants.RIGHT);
			tfNum1.setBounds(23, 36, 69, 21);
			tfNum1.setColumns(10);
		}
		return tfNum1;
	}
	private JTextField getTfNum2() {
		if (tfNum2 == null) {
			tfNum2 = new JTextField();
			tfNum2.setHorizontalAlignment(SwingConstants.RIGHT);
			tfNum2.setColumns(10);
			tfNum2.setBounds(142, 36, 69, 21);
		}
		return tfNum2;
	}
	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setEditable(false);
			tfResult.setHorizontalAlignment(SwingConstants.RIGHT);
			tfResult.setColumns(10);
			tfResult.setBounds(275, 36, 69, 21);
		}
		return tfResult;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("+");
			lblNewLabel.setBounds(115, 39, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("=");
			lblNewLabel_1.setBounds(235, 39, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//방법 1st
//					String stNum1 = tfNum1.getText();
//					String stNum2 = tfNum2.getText();
//					
//					int wkNum1 = Integer.parseInt(stNum1);
//					int wkNum2 = Integer.parseInt(stNum2);
//					int wkResult = wkNum1 + wkNum2;
//					
//					String stResult = Integer.toString(wkResult);
//					tfResult.setText(stResult);
					
					
					//방법 2nd
//					int wkNum1 = Integer.parseInt(tfNum1.getText());
//					int wkNum2 = Integer.parseInt(tfNum2.getText());
//					int wkResult = wkNum1 + wkNum2;
//					
//					tfResult.setText(Integer.toString(wkResult));
					
					
					//방법 3rd
					addSum();
						
					
				}
			});
			btnAdd.setBounds(366, 36, 78, 21);
		}
		return btnAdd;
	}
	
	private void addSum() {
		int wkNum1 = Integer.parseInt(tfNum1.getText());
		int wkNum2 = Integer.parseInt(tfNum2.getText());
		int wkResult = wkNum1 + wkNum2;
		
		tfResult.setText(Integer.toString(wkResult));
		JOptionPane.showMessageDialog(frame, Integer.toString(wkResult));
	}
	
}//---
