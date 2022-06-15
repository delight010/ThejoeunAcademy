package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GUI06_exam1 {

	private JFrame frame;
	private JTextField tfResult;
	private JButton btn_0;
	private JButton btn_1;
	private JButton btn_2;
	private JButton btn_3;
	private JButton btn_4;
	private JButton btn_5;
	private JButton btn_6;
	private JButton btn_7;
	private JButton btn_8;
	private JButton btn_9;
	private JButton btn_result;
	private JButton btn_plus;
	
	private static ArrayList<String> PrintArrayList = new ArrayList<String>();// arrayList 주소 전부 null로 초기화 / tfResult 출력값
	private static ArrayList<String> SumArrayList = new ArrayList<String>();// arrayList 주소 전부 null로 초기화 / 1차 합산값 계산
	private JButton btn_C;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI06_exam1 window = new GUI06_exam1();
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
	public GUI06_exam1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 338, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTfResult());
		frame.getContentPane().add(getBtn_0());
		frame.getContentPane().add(getBtn_1());
		frame.getContentPane().add(getBtn_2());
		frame.getContentPane().add(getBtn_3());
		frame.getContentPane().add(getBtn_4());
		frame.getContentPane().add(getBtn_5());
		frame.getContentPane().add(getBtn_6());
		frame.getContentPane().add(getBtn_7());
		frame.getContentPane().add(getBtn_8());
		frame.getContentPane().add(getBtn_9());
		frame.getContentPane().add(getBtn_result());
		frame.getContentPane().add(getBtn_plus());
		frame.getContentPane().add(getBtn_C());
	}

	private JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setFont(new Font("굴림", Font.PLAIN, 24));
			tfResult.setHorizontalAlignment(SwingConstants.TRAILING);
			tfResult.setText("0");
			tfResult.setEditable(false);
			tfResult.setBounds(25, 20, 274, 54);
			tfResult.setColumns(10);
		}
		return tfResult;
	}
	private JButton getBtn_0() {
		if (btn_0 == null) {
			btn_0 = new JButton("0");
			btn_0.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					numPrint(0);
				}
			});
			btn_0.setBounds(29, 309, 58, 54);
		}
		return btn_0;
	}
	private JButton getBtn_1() {
		if (btn_1 == null) {
			btn_1 = new JButton("1");
			btn_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					numPrint(1);
					
				}
			});
			btn_1.setBounds(29, 245, 58, 54);
		}
		return btn_1;
	}
	private JButton getBtn_2() {
		if (btn_2 == null) {
			btn_2 = new JButton("2");
			btn_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					numPrint(2);
					
				}
			});
			btn_2.setBounds(99, 245, 58, 54);
		}
		return btn_2;
	}
	private JButton getBtn_3() {
		if (btn_3 == null) {
			btn_3 = new JButton("3");
			btn_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					numPrint(3);
				}
			});
			btn_3.setBounds(169, 245, 58, 54);
		}
		return btn_3;
	}
	private JButton getBtn_4() {
		if (btn_4 == null) {
			btn_4 = new JButton("4");
			btn_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					numPrint(4);
				}
			});
			btn_4.setBounds(29, 181, 58, 54);
		}
		return btn_4;
	}
	private JButton getBtn_5() {
		if (btn_5 == null) {
			btn_5 = new JButton("5");
			btn_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					numPrint(5);
				}
			});
			btn_5.setBounds(99, 181, 58, 54);
		}
		return btn_5;
	}
	private JButton getBtn_6() {
		if (btn_6 == null) {
			btn_6 = new JButton("6");
			btn_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					numPrint(6);
				}
			});
			btn_6.setBounds(169, 181, 58, 54);
		}
		return btn_6;
	}
	private JButton getBtn_7() {
		if (btn_7 == null) {
			btn_7 = new JButton("7");
			btn_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					numPrint(7);
				}
			});
			btn_7.setBounds(29, 117, 58, 54);
		}
		return btn_7;
	}
	private JButton getBtn_8() {
		if (btn_8 == null) {
			btn_8 = new JButton("8");
			btn_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					numPrint(8);
				}
			});
			btn_8.setBounds(99, 117, 58, 54);
		}
		return btn_8;
	}
	private JButton getBtn_9() {
		if (btn_9 == null) {
			btn_9 = new JButton("9");
			btn_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					numPrint(9);
				}
			});
			btn_9.setBounds(169, 117, 58, 54);
		}
		return btn_9;
	}
	private JButton getBtn_result() {
		if (btn_result == null) {
			btn_result = new JButton("=");
			btn_result.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Calc();
				}
			});
			btn_result.setBounds(99, 309, 58, 54);
		}
		return btn_result;
	}
	private JButton getBtn_plus() {
		if (btn_plus == null) {
			btn_plus = new JButton("+");
			btn_plus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					numAdd();
				}
			});
			btn_plus.setBounds(169, 309, 58, 54);
		}
		return btn_plus;
	}
	
	private JButton getBtn_C() {
		if (btn_C == null) {
			btn_C = new JButton("C");
			btn_C.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					numZero();
				}
			});
			btn_C.setBounds(239, 309, 58, 54);
		}
		return btn_C;
	}
	
	//----------------------------------------------
	
	
	private void numPrint(int j) {
		tfResult.setText(Integer.toString(j));
		String number="";
		PrintArrayList.add(tfResult.getText());
		for(int i = 0; i<PrintArrayList.size(); i++) {
			number += PrintArrayList.get(i);
		}
		tfResult.setText(number); // 숫자값 출력
		
	}
	
	private void numAdd() {
		SumArrayList.add(tfResult.getText());
		int SumResult=0; // 1차 합산값		
		PrintArrayList.clear();//tfResult의 값 초기화
		
		for(int i=0; i<SumArrayList.size(); i++) {
			SumResult+=Integer.parseInt(SumArrayList.get(i)); //1차 합산값 계산
		}
		
		tfResult.setText(Integer.toString(SumResult)); // 1차 합산값 출력
	}
	
	
	private void Calc() {
		SumArrayList.add(tfResult.getText());
		int numSum = 0; //최종 합산값
		
		for(int i=0; i<SumArrayList.size(); i++) {
			numSum= numSum + Integer.parseInt(SumArrayList.get(i)); //최종합산값 계산
		}
		
		tfResult.setText(Integer.toString(numSum)); //최종합산값 출력
		
		
	}
	
	
	private void numZero() {
		PrintArrayList.clear();
		tfResult.setText("0");
	}
	
	
}//---------------------------------------------
