package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

public class GUI_03_exam03 {

	private JFrame frame;
	private JLabel lblResult0;
	private JTextField tfNum1;
	private JTextField tfNum2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private int Num1;
	private int Num2;
	private int Result;
	private String ResultStr;
	private String ResultList;
	private static ArrayList<String> arrayList = new ArrayList<String>(); // arrayList 주소 전부 null로 초기화
	private JLabel lblResult1;
	private JLabel lblResult2;
	private JLabel lblResult3;
	private JCheckBox cbAdd;
	private JCheckBox cbSub;
	private JCheckBox cbMul;
	private JCheckBox cbDiv;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_03_exam03 window = new GUI_03_exam03();
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
	public GUI_03_exam03() {
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
		frame.getContentPane().add(getLblResult0());
		frame.getContentPane().add(getTfNum1());
		frame.getContentPane().add(getTfNum2());
		frame.getContentPane().add(getLblResult1());
		frame.getContentPane().add(getLblResult2());
		frame.getContentPane().add(getLblResult3());
		frame.getContentPane().add(getCbAdd());
		frame.getContentPane().add(getCbSub());
		frame.getContentPane().add(getCbMul());
		frame.getContentPane().add(getCbDiv());
	}
	private JLabel getLblResult0() {
		if (lblResult0 == null) {
			lblResult0 = new JLabel("");
			lblResult0.setBounds(12, 105, 159, 21);
		}
		return lblResult0;
	}
	private JTextField getTfNum1() {
		if (tfNum1 == null) {
			tfNum1 = new JTextField();
			tfNum1.setBounds(25, 27, 73, 21);
			tfNum1.setColumns(10);
		}
		return tfNum1;
	}
	private JTextField getTfNum2() {
		if (tfNum2 == null) {
			tfNum2 = new JTextField();
			tfNum2.setColumns(10);
			tfNum2.setBounds(25, 69, 73, 21);
		}
		return tfNum2;
	}
	
	
	private JLabel getLblResult1() {
		if (lblResult1 == null) {
			lblResult1 = new JLabel("");
			lblResult1.setBounds(12, 136, 159, 21);
		}
		return lblResult1;
	}
	private JLabel getLblResult2() {
		if (lblResult2 == null) {
			lblResult2 = new JLabel("");
			lblResult2.setBounds(22, 167, 159, 21);
		}
		return lblResult2;
	}
	private JLabel getLblResult3() {
		if (lblResult3 == null) {
			lblResult3 = new JLabel("");
			lblResult3.setBounds(25, 198, 159, 21);
		}
		return lblResult3;
	}
	private JCheckBox getCbAdd() {
		if (cbAdd == null) {
			cbAdd = new JCheckBox("Add");
			cbAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NumCheck();
				}
			});
			cbAdd.setBounds(247, 26, 115, 23);
		}
		return cbAdd;
	}
	private JCheckBox getCbSub() {
		if (cbSub == null) {
			cbSub = new JCheckBox("Sub");
			cbSub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NumCheck();
				}
			});
			cbSub.setBounds(247, 68, 115, 23);
		}
		return cbSub;
	}
	private JCheckBox getCbMul() {
		if (cbMul == null) {
			cbMul = new JCheckBox("Mul");
			cbMul.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NumCheck();
				}
			});
			cbMul.setBounds(247, 103, 115, 23);
		}
		return cbMul;
	}
	private JCheckBox getCbDiv() {
		if (cbDiv == null) {
			cbDiv = new JCheckBox("Div");
			cbDiv.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NumCheck();
				}
			});
			cbDiv.setBounds(247, 146, 115, 23);
		}
		return cbDiv;
	}
	
	//----------------------------------------------------------------
	
	
		private void Num() { // tfNum1,2 값 -> int Num1,Num2값으로 지정
			Num1 = Integer.valueOf(tfNum1.getText());
			Num2 = Integer.valueOf(tfNum2.getText());
		}
		
		private void numAdd() {
			Num();
			Result = this.Num1 + this.Num2;
			ResultStr = Integer.toString(Result);
			ResultList = Num1 + "+" + Num2 + "=" + ResultStr;
			
			
			arrayList.add(0,ResultList); // 주소 지정
			
		}
		
		private void numSub() {
			Num();
			Result = this.Num1 - this.Num2;
			ResultStr = Integer.toString(Result);
			ResultList = Num1 + "-" + Num2 + "=" + ResultStr;
			
			arrayList.add(1,ResultList); // 주소 지정
			
		}
		
		private void numMul() {
			Num();
			Result = this.Num1 * this.Num2;
			ResultStr = Integer.toString(Result);
			ResultList = Num1 + "*" + Num2 + "=" + ResultStr;
			
			arrayList.add(2,ResultList); // 주소 지정
			
		}
		
		
		private void numDiv() {
			Num();
			double ResultDB;
			if(this.Num1==0 | this.Num2==0) {
				JOptionPane.showMessageDialog(null, "나눌 수 없습니다.");
			}else if(this.Num1%this.Num2==0){
				Result = this.Num1 /this.Num2;
				ResultStr = Integer.toString(Result);
			}
			else {
				ResultDB = Double.valueOf(tfNum1.getText()) / Double.valueOf(tfNum2.getText());
				ResultStr = String.format("%3.3f", ResultDB);
			}
			ResultList = Num1 + "/" + Num2 + "=" + ResultStr;
			
			
			arrayList.add(3,ResultList); // 주소 지정
		}	
	
	
	private void NumCheck() {
		if(cbAdd.isSelected()==true) {
			numAdd();
			lblResult0.setText(arrayList.get(0));
		}else if(cbAdd.isSelected()==false) {
			lblResult0.setText("");
			arrayList.add(0, null);
		}
		
		if(cbSub.isSelected()==true) {
			numSub();
			lblResult1.setText(arrayList.get(1));
		}else if(cbSub.isSelected()==false) {
			lblResult1.setText("");
			arrayList.add(1, null);
		}
		
		if(cbMul.isSelected()==true) {
			numMul();
			lblResult2.setText(arrayList.get(2));
		}else if(cbMul.isSelected()==false) {
			lblResult2.setText("");
			arrayList.add(2, null);
		}
		
		if(cbDiv.isSelected()==true) {
			numDiv();
			lblResult3.setText(arrayList.get(3));
		}else if(cbDiv.isSelected()==false) {
			lblResult3.setText("");
			arrayList.add(3, null);
		}
		
//		for(int i=0; i<arrayList.size(); i++) {
//			
//			lblResult0.setText(arrayList.get(i));
//			
//		}
		
	}
	
	
	
	
	
}//--------------------------------------------------------
