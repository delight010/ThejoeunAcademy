package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressInsert_exam03 {

	private JFrame frame;
	private JRadioButton rdbtnInsert;
	private JRadioButton rdbtnEdit;
	private JRadioButton rdbtnDelete;
	private JRadioButton rdbtnSearch;
	private JComboBox cbSelection;
	private JButton btnSearch;
	private JTextField tfSelection;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_2_1;
	private JButton btnOK;
	private JTextField tfSeqno;
	private JTextField tfName;
	private JTextField tfTelno;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JTextField tfRelation;
	private JScrollPane scrollPane;
	private JTable inner_Table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	//Database 환경 정의
	private final String url_mysql = "jdbc:mysql://127.0.0.1/newschema?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	private final String id_mysql = "root";
	private final String pw_mysql = "qwer1234";
	
	//Table 환경 정의
	private final DefaultTableModel Outer_Table = new DefaultTableModel();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressInsert_exam03 window = new AddressInsert_exam03();
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
	public AddressInsert_exam03() {
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
		frame.addMouseListener(new MouseAdapter() {
		});
		frame.setTitle("주소록");
		frame.setBounds(100, 100, 450, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getRdbtnInsert());
		frame.getContentPane().add(getRdbtnEdit());
		frame.getContentPane().add(getRdbtnDelete());
		frame.getContentPane().add(getRdbtnSearch());
		frame.getContentPane().add(getCbSelection());
		frame.getContentPane().add(getBtnSearch());
		frame.getContentPane().add(getTfSelection());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getLblNewLabel_2_2());
		frame.getContentPane().add(getLblNewLabel_2_2_1());
		frame.getContentPane().add(getBtnOK());
		frame.getContentPane().add(getTfSeqno());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getTfTelno());
		frame.getContentPane().add(getTfAddress());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getTfRelation());
		frame.getContentPane().add(getScrollPane());
	}
	private JRadioButton getRdbtnInsert() {
		if (rdbtnInsert == null) {
			rdbtnInsert = new JRadioButton("입력");
			rdbtnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			buttonGroup.add(rdbtnInsert);
			rdbtnInsert.setBounds(8, 6, 60, 23);
		}
		return rdbtnInsert;
	}
	private JRadioButton getRdbtnEdit() {
		if (rdbtnEdit == null) {
			rdbtnEdit = new JRadioButton("수정");
			buttonGroup.add(rdbtnEdit);
			rdbtnEdit.setBounds(72, 6, 60, 23);
		}
		return rdbtnEdit;
	}
	private JRadioButton getRdbtnDelete() {
		if (rdbtnDelete == null) {
			rdbtnDelete = new JRadioButton("삭제");
			buttonGroup.add(rdbtnDelete);
			rdbtnDelete.setBounds(136, 6, 60, 23);
		}
		return rdbtnDelete;
	}
	private JRadioButton getRdbtnSearch() {
		if (rdbtnSearch == null) {
			rdbtnSearch = new JRadioButton("검색");
			buttonGroup.add(rdbtnSearch);
			rdbtnSearch.setBounds(200, 6, 60, 23);
		}
		return rdbtnSearch;
	}
	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.setBounds(8, 35, 70, 23);
			cbSelection.setModel(new DefaultComboBoxModel(new String[] {"이름", "전화번호", "관계"}));
		}
		return cbSelection;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					conditionQuery();
				}
			});
			btnSearch.setBounds(325, 35, 97, 23);
		}
		return btnSearch;
	}
	private JTextField getTfSelection() {
		if (tfSelection == null) {
			tfSelection = new JTextField();
			tfSelection.setBounds(82, 35, 242, 23);
			tfSelection.setColumns(10);
		}
		return tfSelection;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("순서 :");
			lblNewLabel.setBounds(11, 196, 57, 15);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름 : ");
			lblNewLabel_1.setBounds(11, 231, 57, 15);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("전화번호 : ");
			lblNewLabel_2.setBounds(11, 266, 87, 15);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("주소 : ");
			lblNewLabel_2_1.setBounds(11, 298, 57, 15);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("전자우편 : ");
			lblNewLabel_2_2.setBounds(11, 334, 87, 15);
		}
		return lblNewLabel_2_2;
	}
	private JLabel getLblNewLabel_2_2_1() {
		if (lblNewLabel_2_2_1 == null) {
			lblNewLabel_2_2_1 = new JLabel("관계 : ");
			lblNewLabel_2_2_1.setBounds(11, 372, 87, 15);
		}
		return lblNewLabel_2_2_1;
	}
	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("확인");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					click_btn_OK();					
				}
			});
			btnOK.setBounds(298, 406, 97, 23);
		}
		return btnOK;
	}
	private JTextField getTfSeqno() {
		if (tfSeqno == null) {
			tfSeqno = new JTextField();
			tfSeqno.setBounds(72, 193, 116, 21);
			tfSeqno.setColumns(10);
		}
		return tfSeqno;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(72, 228, 116, 21);
		}
		return tfName;
	}
	private JTextField getTfTelno() {
		if (tfTelno == null) {
			tfTelno = new JTextField();
			tfTelno.setColumns(10);
			tfTelno.setBounds(72, 263, 116, 21);
		}
		return tfTelno;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setColumns(10);
			tfAddress.setBounds(72, 295, 350, 21);
		}
		return tfAddress;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(72, 331, 216, 21);
		}
		return tfEmail;
	}
	private JTextField getTfRelation() {
		if (tfRelation == null) {
			tfRelation = new JTextField();
			tfRelation.setColumns(10);
			tfRelation.setBounds(72, 369, 350, 21);
		}
		return tfRelation;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(8, 70, 414, 116);
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
			inner_Table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			inner_Table.setModel(Outer_Table); // 테이블을 불러오기 위해 ******꼭 써야할 것******
		}
		return inner_Table;
	}

//-----------------------------------------------------------------------------
//화면 Table 초기화
	private void tableInit() {
		Outer_Table.addColumn("순서");
		Outer_Table.addColumn("이름");
		Outer_Table.addColumn("전화번호");
		Outer_Table.addColumn("관계");
		Outer_Table.setColumnCount(4); // Column이 4개	
		
		int i = Outer_Table.getRowCount();
		for(int j=0; j<i; j++) {
			Outer_Table.removeRow(0);
		}
		
		inner_Table.setAutoResizeMode(inner_Table.AUTO_RESIZE_OFF); // 마음대로 리사이징 x
		inner_Table.setCellEditor(null);
		
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
		width = 130; // 3번째 행 가로
		col.setPreferredWidth(width);; // 4번째 행 가로크기 설정
		
	}

	private void searchAction() { // inner_table에 자료를 넣기
		String query = "select seqno, name, telno, relation from userinfo ";
//		int dataCount = 0; //while문이 몇번 돌았는지 세기위한 변수
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->결과값 저장
			
			while(rs.next()) { //ResultSet에서 
				String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
					Outer_Table.addRow(qTxt);
//					dataCount++;
				}
				
			
			conn_mysql.close(); //DB 연결 끊기
//			tfCount.setText(Integer.toString(dataCount)); //while문이 몇번 돌았는지 센다
			
		}catch(Exception e) {//java.lang
			e.printStackTrace();// 화면에 에러코드 보여주기
		}
	}

	
	//Table_Click
	private void tableClick() { // 테이블 밑 명세에 내용 출력하기
		int i = inner_Table.getSelectedRow(); // 선택한 행을 불러옴, Seqno의 숫자 1~n까지
		String wkSeq = (String) inner_Table.getValueAt(i, 0); // String값으로 차례로 i행을 불러와 넣어줌
		String query = "select seqno, name, telno, address, email, relation from userinfo ";
		// 열값을 차례로 불러오기 위함(순서, 이름, 전화번호, 이메일, 관계)
		String query2 = "where seqno = "+wkSeq;		
	
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc 드라이버를 로딩
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); //DB환경 연결&로그인
		Statement stmt_mysql = conn_mysql.createStatement(); // DB에서 데이터를 불러옴
		
		ResultSet rs = stmt_mysql.executeQuery(query+query2); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->객체 rs에 결과값 저장
		
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
	
	
	private void conditionQuery() { // 콤보박스의 인덱스 확인
		if(rdbtnSearch.isSelected()==true) { // 검색라디오 버튼 체크
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
		}else {
			JOptionPane.showMessageDialog(null, "검색 라디오버튼을 누르세요");
		}

	}
	
	private void clearColumn() { // 테이블 화면 공백 만들기
		tfSeqno.setText("");//화면 지우기
		tfName.setText("");
		tfTelno.setText("");
		tfAddress.setText("");
		tfEmail.setText("");
		tfRelation.setText("");
	}
	
	
	//검색
	private void conditionQueryAction(String columnName) { // conditionQueryColumn를 columnName으로 받아옴
		String query = "select seqno, name, telno, relation from userinfo where "+columnName;
		String query2 = " like '%" + tfSelection.getText() + "%'"; // 검색용 필터
//		System.out.println(query+query2); // sql 문장 확인용
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // jdbc 드라이버를 로딩
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql); //DB환경 연결&로그인
			Statement stmt_mysql = conn_mysql.createStatement(); // DB에서 데이터를 불러옴
			
			ResultSet rs = stmt_mysql.executeQuery(query+query2); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->객체 rs에 결과값 저장
			
			while(rs.next()) {
			 String[] qTxt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
			 Outer_Table.addRow(qTxt); // 열값을 차례대로 불러오기 (순서, 이름, 전화번호, 관계)
			}
				
			conn_mysql.close(); //DB 연결 끊기
			
			
			}catch(Exception e) {
				e.printStackTrace();// 화면에 에러코드 보여주기
			}
	}
	
	//사용자 정보 입력 체크
	private int insertFieldCheck() {
		int i = 0;
		String message = "";
		if(tfName.getText().trim().length()==0) {
			i++;
			message = "이름을 ";
			tfName.requestFocus(); // 커서 띄워주기
		}
		if(tfTelno.getText().trim().length()==0) {
			i++;
			message = "전화번호를 ";
			tfTelno.requestFocus();
		}
		if(tfAddress.getText().trim().length()==0) {
			i++;
			message = "주소를 ";
			tfAddress.requestFocus();
		}
		if(tfEmail.getText().trim().length()==0) {
			i++;
			message = "전자우편을 ";
			tfEmail.requestFocus();
		}
		if(tfRelation.getText().trim().length()==0) {
			i++;
			message = "관계를 ";
			tfRelation.requestFocus();
		}
		
		if(i>0) {
			JOptionPane.showMessageDialog(null, message + "확인하세요");
		}
		
		return i;		
	}
	
	
	//입력
	private void conditionInsertAction() { //사용자 정보 입력
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			String query = "insert into userinfo (name, telno, address, email, relation) values (?,?,?,?,?)";
//			String query1 = " values (?,?,?,?,?)"; // 위의 쿼리를 줄여쓰기, 띄어쓰기 주의
			
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, tfName.getText().trim()); // 위의 (?)값에 넣어주기
			ps.setString(2, tfTelno.getText().trim());
			ps.setString(3, tfAddress.getText().trim());
			ps.setString(4, tfEmail.getText().trim());
			ps.setString(5, tfRelation.getText().trim());
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, tfName.getText() + "님의 정보가 입력되었습니다.");
			
			clearColumn(); // 화면지우는 메소드
			tableInit(); // table을 재구성함
			searchAction(); //테이블내용 불러오기
			conn_mysql.close(); //DB 연결 끊기
			
		}catch(Exception e) {//java.lang
			e.printStackTrace();// 화면에 에러코드 보여주기
		}
	}
	
	
	
	
	//수정
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
			
			JOptionPane.showMessageDialog(null, tfName.getText() + "님의 정보가 수정되었습니다.");
			
			tableInit();
			searchAction();
			clearColumn();
			conn_mysql.close(); //DB 연결 끊기
			
			
			}catch(Exception e) {
				e.printStackTrace();// 화면에 에러코드 보여주기
			}
	}
	
	
	//삭제
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
			
			JOptionPane.showMessageDialog(null, tfName.getText() + "님의 정보가 삭제되었습니다.");
			
			stmt_mysql.executeUpdate(query); // 쿼리문장을 실행하여 ResultSet타입으로 변환 ->객체 rs에 결과값 저장
			clearColumn(); // 화면지우는 메소드
			tableInit(); // table을 재구성함
			searchAction(); //테이블내용 불러오기
			
			conn_mysql.close(); //DB 연결 끊기
			
			
			}catch(Exception e) {
				e.printStackTrace();// 화면에 에러코드 보여주기
			}
		
	}
	
	//radioCheck 라디오버튼을 선택하지않으면
	private void noCheckRadio() {
		if(rdbtnInsert.isSelected()!=true&&rdbtnEdit.isSelected()!=true&&rdbtnDelete.isSelected()!=true&&rdbtnSearch.isSelected()!=true) {
			JOptionPane.showMessageDialog(null, "라디오 버튼을 선택하세요");
		}
	}
	
	
	//OK 버튼 클릭시 
	private void click_btn_OK() {
		noCheckRadio();
		if(rdbtnInsert.isSelected()==true) {
			conditionInsertAction();
		}
		
		if(rdbtnEdit.isSelected()==true) {
			conditionEditAction();
		}		
		
		if(rdbtnDelete.isSelected()==true) {
			conditionDeleteAction();
		}
		
		
	}
	
	
	
	
	
}//----------------------------------------------------------------------------
