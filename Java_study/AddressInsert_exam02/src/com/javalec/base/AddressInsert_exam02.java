package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddressInsert_exam02 {

	private JFrame frame;
	private JComboBox cbSelection;
	private JTextField tfSelection;
	private JButton btnQuery;
	private JScrollPane scrollPane;
	private JTable inner_Table;
	private JLabel lblNewLabel;
	private JTextField tfSeqno;
	private JLabel lblNewLabel_1;
	private JTextField tfName;
	private JLabel lblNewLabel_2;
	private JTextField tfTelno;
	private JLabel lblNewLabel_3;
	private JTextField tfAddress;
	private JLabel lblNewLabel_4;
	private JTextField tfEmail;
	private JLabel lblNewLabel_5;
	private JTextField tfRelation;
	
	//Database 환경 정의
		private final String url_mysql = "jdbc:mysql://127.0.0.1/newschema?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
		private final String id_mysql = "root";
		private final String pw_mysql = "qwer1234";
		
	//Table 환경 정의
		private final DefaultTableModel Outer_Table = new DefaultTableModel();
		private JTextField tfCount;
		private JLabel lblNewLabel_6;
		private JButton btnEdit;
		private JButton btnRemove;
		private JButton btnNewButton;
		private JButton btnDelete;
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressInsert_exam02 window = new AddressInsert_exam02();
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
	public AddressInsert_exam02() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();
				searchAction();
			}
		});
		frame.setTitle("주소록 검색");
		frame.setBounds(100, 100, 486, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getCbSelection());
		frame.getContentPane().add(getTfSelection());
		frame.getContentPane().add(getBtnQuery());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTfSeqno());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getTfTelno());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getTfAddress());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getLblNewLabel_5());
		frame.getContentPane().add(getTfRelation());
		frame.getContentPane().add(getTfCount());
		frame.getContentPane().add(getLblNewLabel_6());
		frame.getContentPane().add(getBtnEdit());
		frame.getContentPane().add(getBtnDelete());
	}
	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.setModel(new DefaultComboBoxModel(new String[] {"이름", "주소", "관계"}));
			cbSelection.setBounds(23, 19, 105, 27);
		}
		return cbSelection;
	}
	private JTextField getTfSelection() {
		if (tfSelection == null) {
			tfSelection = new JTextField();
			tfSelection.setBounds(140, 18, 184, 26);
			tfSelection.setColumns(10);
		}
		return tfSelection;
	}
	private JButton getBtnQuery() {
		if (btnQuery == null) {
			btnQuery = new JButton("검색");
			btnQuery.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionQuery();
				}
			});
			btnQuery.setBounds(327, 18, 117, 29);
		}
		return btnQuery;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(33, 68, 392, 91);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (inner_Table == null) {
			inner_Table = new JTable();
			inner_Table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					tableClick();
				}
			});
			inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			inner_Table.setModel(Outer_Table); // 테이블을 불러오기 위해 ******꼭 써야할 것******			
		}
		return inner_Table;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Seq No:");
			lblNewLabel.setBounds(23, 191, 61, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTfSeqno() {
		if (tfSeqno == null) {
			tfSeqno = new JTextField();
			tfSeqno.setBounds(96, 186, 61, 26);
			tfSeqno.setColumns(10);
		}
		return tfSeqno;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름:");
			lblNewLabel_1.setBounds(23, 229, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(96, 224, 130, 26);
		}
		return tfName;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("전화번호:");
			lblNewLabel_2.setBounds(23, 267, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setColumns(10);
			tfTelno.setBounds(96, 262, 130, 26);
		}
		return tfTelno;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("주소:");
			lblNewLabel_3.setBounds(23, 305, 61, 16);
		}
		return lblNewLabel_3;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(96, 300, 301, 26);
		}
		return tfAddress;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("전자우편:");
			lblNewLabel_4.setBounds(23, 345, 61, 16);
		}
		return lblNewLabel_4;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(96, 340, 184, 26);
		}
		return tfEmail;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("관계:");
			lblNewLabel_5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JOptionPane.showMessageDialog(null, "이용할수없음");
				}
			});
			lblNewLabel_5.setBounds(23, 383, 61, 16);
		}
		return lblNewLabel_5;
	}
	private JTextField getTfRelation() {
		if (tfRelation == null) {
			tfRelation = new JTextField();
			tfRelation.setColumns(10);
			tfRelation.setBounds(96, 378, 301, 26);
		}
		return tfRelation;
	}
	//----------------------------------------
	//화면 Table 초기화
	private void tableInit() {
		Outer_Table.addColumn("순서"); // 테이블 내부의 항목 outer_table 만들기
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("전화번호");
		Outer_Table.addColumn("관계");
		Outer_Table.setColumnCount(4); // Column이 4개
		
		int i = Outer_Table.getRowCount();
		for(int j=0; j<i; j++) {
			Outer_Table.removeRow(0);
		}
		
		inner_Table.setAutoResizeMode(inner_Table.AUTO_RESIZE_OFF); // 마음대로 리사이징 x
		
		int vColIndex = 0; // 첫번째 행
		TableColumn col = inner_Table.getColumnModel().getColumn(vColIndex);
		int width = 30; // 첫번째 행 가로
		col.setPreferredWidth(width);; // 첫번째 행 가로크기 설정
		
		vColIndex = 1; // 2번째 행
		col = inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100; // 2번째 행 가로
		col.setPreferredWidth(width);; // 2번째 행 가로크기 설정
		
		vColIndex = 2; // 3번째 행
		col = inner_Table.getColumnModel().getColumn(vColIndex);
		width = 150; // 2번째 행 가로
		col.setPreferredWidth(width);; // 3번째 행 가로크기 설정
		
		vColIndex = 3; // 4번째 행
		col = inner_Table.getColumnModel().getColumn(vColIndex);
		width = 100; // 3번째 행 가로
		col.setPreferredWidth(width);; // 4번째 행 가로크기 설정
		
	}
	
	
	private void searchAction() {
		String query = "select seqno, name, telno, relation from userinfo ";
		int dataCount = 0; //while문이 몇번 돌았는지 세기위한 변수
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->결과값 저장
			
			while(rs.next()) { //ResultSet에서 
				String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
					Outer_Table.addRow(qTxt);
					dataCount++;
				}
				
			
			conn_mysql.close(); //DB 연결 끊기
			tfCount.setText(Integer.toString(dataCount)); //while문이 몇번 돌았는지 센다
			
		}catch(Exception e) {//java.lang
			e.printStackTrace();// 화면에 에러코드 보여주기
		}
	
	}
	
	//Table clicked
	private void tableClick() {
		int i = inner_Table.getSelectedRow(); // i행을 불러옴, Seqno의 숫자 1~n까지
		String wkSeq = (String) inner_Table.getValueAt(i, 0); // String값으로 차례로 i행을 불러와 넣어줌
		String query = "select seqno, name, telno, address, email, relation from userinfo where seqno="+wkSeq;
		// 열값을 차례로 불러오기 위함(순서, 이름, 전화번호, 이메일, 관계)
		String query2 = "where seqno = ";		
		PreparedStatement ps = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc 드라이버를 로딩
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); //DB환경 연결&로그인
		Statement stmt_mysql = conn_mysql.createStatement(); // DB에서 데이터를 불러옴
		
		ResultSet rs = stmt_mysql.executeQuery(query); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->객체 rs에 결과값 저장
		
		while(rs.next()) {
		tfSeqno.setText(rs.getString(1)); // 열값을 차례로 불러오기 위함(순서, 이름, 전화번호, 이메일, 관계)
		tfName.setText(rs.getString(2));
		tfTelno.setText(rs.getString(3));
		tfAddress.setText(rs.getString(4));
		tfEmail.setText(rs.getString(5));
		tfRelation.setText(rs.getString(6));
		}
			
		conn_mysql.close(); //DB 연결 끊기
		
		
		}catch(Exception e) {
			e.printStackTrace();// 화면에 에러코드 보여주기
		}
	}
	
	
	private void conditionQuery() {
		int i = cbSelection.getSelectedIndex(); // 전환한 문자열을 받을 변수 선언
		String conditionQueryColumn = ""; // ""값으로 초기화
		switch(i) {
		case 0:
			conditionQueryColumn = "name";
			break;
		case 1:
			conditionQueryColumn = "address";
			break;
		case 2 : 
			conditionQueryColumn = "relation";
			break;
		default:
			break;
		}
		
		tableInit(); // table을 재구성함
		clearColumn(); // 화면 지우는 메소드
		conditionQueryAction(conditionQueryColumn); // 검색메소드 실행
//		System.out.println(conditionQueryColumn);
	}
	
	private void conditionQueryAction(String columnName) { // conditionQueryColumn를 columnName으로 받아옴
		String query = "select seqno, name, telno, relation from userinfo where "+columnName;
		String query2 = " like '%" + tfSelection.getText() + "%'"; // 검색용 필터
//		System.out.println(query+query2); // sql 문장 확인용
		PreparedStatement ps = null;
		int dataCount = 0; // while문이 몇번돌았는지 확인용
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc 드라이버를 로딩
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); //DB환경 연결&로그인
			Statement stmt_mysql = conn_mysql.createStatement(); // DB에서 데이터를 불러옴
			
			ResultSet rs = stmt_mysql.executeQuery(query+query2); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->객체 rs에 결과값 저장
			
			while(rs.next()) {
			 String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
			 Outer_Table.addRow(qTxt); // 열값을 차례대로 불러오기 (순서, 이름, 전화번호, 관계)
			 dataCount++;
			}
				
			conn_mysql.close(); //DB 연결 끊기
			tfCount.setText(Integer.toString(dataCount)); //while문이 몇번 돌았는지 센다
			
			
			}catch(Exception e) {
				e.printStackTrace();// 화면에 에러코드 보여주기
			}
	}
	
	private void clearColumn() { // 테이블 화면 공백 만들기
		tfSeqno.setText("");//화면 지우기
		tfName.setText("");
		tfTelno.setText("");
		tfAddress.setText("");
		tfEmail.setText("");
		tfRelation.setText("");
		tfCount.setText("");
	}
	
	
	private void conditionDeleteAction() {
		int i = inner_Table.getSelectedRow(); // 클릭한 i행을 불러옴, Seqno의 숫자 1~n까지
		String wkSeq = (String) inner_Table.getValueAt(i, 0); // String값으로 차례로 i행을 불러와 넣어줌
		String query = "delete from userinfo where seqno="+wkSeq;
//		System.out.println(query+query2); // sql 문장 확인용
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc 드라이버를 로딩
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); //DB환경 연결&로그인
			Statement stmt_mysql = conn_mysql.createStatement(); // DB에서 데이터를 불러옴
			
			stmt_mysql.executeUpdate(query); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->객체 rs에 결과값 저장
			clearColumn(); // 화면지우는 메소드
			tableInit(); // table을 재구성함
			searchAction(); //테이블내용 불러오기
			
			conn_mysql.close(); //DB 연결 끊기
			
			
			}catch(Exception e) {
				e.printStackTrace();// 화면에 에러코드 보여주기
			}
		
	}
	
	
	private void conditionEditAction() {
		int i = inner_Table.getSelectedRow(); // 클릭한 i행을 불러옴, Seqno의 숫자 1~n까지
		String wkSeq = (String) inner_Table.getValueAt(i, 0); // String값으로 차례로 i행을 불러와 넣어줌
		String query = "update userinfo set name=?, telno=?, address=?, email=?, relation=? where seqno="+wkSeq;
		// 열값을 차례로 불러오기 위함(순서, 이름, 전화번호, 이메일, 관계)
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc 드라이버를 로딩
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); //DB환경 연결&로그인
//			Statement stmt_mysql = conn_mysql.createStatement(); // DB에서 데이터를 불러옴
			ps = conn_mysql.prepareStatement(query);
			
			ps.setString(1, tfName.getText());
			ps.setString(2, tfTelno.getText());
			ps.setString(3, tfAddress.getText());
			ps.setString(4, tfEmail.getText());
			ps.setString(5, tfRelation.getText());
			ps.executeUpdate(); // update문 실행
			
			tableInit();
			searchAction();
			clearColumn();
			conn_mysql.close(); //DB 연결 끊기
			
			
			}catch(Exception e) {
				e.printStackTrace();// 화면에 에러코드 보여주기
			}
	}
	
	private JTextField getTfCount() {
		if (tfCount == null) {
			tfCount = new JTextField();
			tfCount.setEditable(false);
			tfCount.setHorizontalAlignment(SwingConstants.TRAILING);
			tfCount.setColumns(10);
			tfCount.setBounds(306, 186, 61, 26);
		}
		return tfCount;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("명");
			lblNewLabel_6.setBounds(383, 191, 61, 16);
		}
		return lblNewLabel_6;
	}
	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("수정");
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionEditAction();
				}
			});
			btnEdit.setBounds(60, 441, 97, 23);
		}
		return btnEdit;
	}
	
	

	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionDeleteAction();
				}
			});
			btnDelete.setBounds(270, 441, 97, 23);
		}
		return btnDelete;
	}
}//----------