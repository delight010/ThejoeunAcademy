//
//  TableViewController.swift
//  0727_SQLite
//
//  Created by TJ on 2021/07/27.
//

import UIKit
import SQLite3 // <<<<<<<<<< 잊지 말 것

class TableViewController: UITableViewController {
    @IBOutlet var tvListView: UITableView!
    
    var db: OpaquePointer? // 포인터 설정
    var studentsList: [Students] = [] // 생성자를 이용하여 배열 생성
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        
        // Edit 버튼을 만들어 삭제 기능 추가하기, 왼쪽으로 배치 (모양만)
        self.navigationItem.leftBarButtonItem = self.editButtonItem
        
        // SQLite 생성하기
        // for: .documentDirectory.  :: 디렉터리 위치
        // in: .userDomainMask    :: 현재 폰트를 사용
        // 파일이 있는 지 없는 지를 확인
        let fileURL = try! FileManager.default.url(for: .documentDirectory, in: .userDomainMask, appropriateFor: nil, create: false).appendingPathComponent("StudentsData1.sqlite")
        
        // SQLITE_OK가 아니라면 :: DB를 열 수 없다면
        if sqlite3_open(fileURL.path, &db) != SQLITE_OK{
            print("error opening database")
        }
        
        // students table이 존재하지 않는 다면 생성한다
        // 하지만 SQLITE_OK가 아니라면
        if sqlite3_exec(db, "CREATE TABLE IF NOT EXISTS students(sid INTEGER PRIMARY KEY AUTOINCREMENT, sname TEXT, sdept TEXT, sphone TEXT)", nil, nil, nil) != SQLITE_OK{
            let errmsg = String(cString: sqlite3_errmsg(db)!) // error code 생성
            print("error creating table: \(errmsg)")
        }
        
        // Temporary Insert **(맨 처음에만 실행하고, 그 이후에는 주석처리 할 것)**
        //tempInsert()
        
        // DB내용 불러오기
        readValues()
        
    }
    
    // Temporary Insert
    func tempInsert(){
        var stmt: OpaquePointer? // 포인터 설정
        // ***한글이 깨지는 것을 방지 (현재 타입(한글 2바이트)에서 -1바이트)***
        let SQLITE_TRANSIENT = unsafeBitCast(-1, to: sqlite3_destructor_type.self)
        
        let queryString = "INSERT INTO students (sname, sdept, sphone) VALUES (?,?,?)"
        
        // 포인터로 쓰는 것은 '&'를 붙임, 한글 입력 때문에 -1이 들어감
        // data INSERT 시 error가 생기면 출력
        if sqlite3_prepare(db, queryString, -1, &stmt, nil) != SQLITE_OK{
            let errmsg = String(cString: sqlite3_errmsg(db)!) // error code 생성
            print("error preparing insert: \(errmsg)")
            return // error가 걸리면 이 메소드를 벗어남
        }
        
        
        // 1번째 물음표 '?'에 대입
        if sqlite3_bind_text(stmt, 1, "유비", -1, SQLITE_TRANSIENT) != SQLITE_OK{
            let errmsg = String(cString: sqlite3_errmsg(db)!) // error code 생성
            print("error binding name: \(errmsg)")
            return // error가 걸리면 이 메소드를 벗어남
        }
        
        // 2번째 물음표 '?'에 대입
        if sqlite3_bind_text(stmt, 2, "컴퓨터공학과", -1, SQLITE_TRANSIENT) != SQLITE_OK{
            let errmsg = String(cString: sqlite3_errmsg(db)!) // error code 생성
            print("error binding dept: \(errmsg)")
            return // error가 걸리면 이 메소드를 벗어남
        }
        
        // 3번째 물음표 '?'에 대입
        if sqlite3_bind_text(stmt, 3, "1234", -1, SQLITE_TRANSIENT) != SQLITE_OK{
            let errmsg = String(cString: sqlite3_errmsg(db)!) // error code 생성
            print("error binding phone: \(errmsg)")
            return // error가 걸리면 이 메소드를 벗어남
        }
        
        
        // 쿼리문 실행
        if sqlite3_step(stmt) != SQLITE_DONE{
            let errmsg = String(cString: sqlite3_errmsg(db)!) // error code 생성
            print("failure inserting student: \(errmsg)")
            return // error가 걸리면 이 메소드를 벗어남
        }
        
        
        // error가 걸리지 않았다면
        print("Students saved successfully")
    }
    
    
    func readValues(){
        studentsList.removeAll() // 배열 내용을 전부 초기화
        
        let queryString = "SELECT * FROM students"
        
        var stmt: OpaquePointer?
        
        // Data를 읽어오는 게 실패하면 에러 출력
        if sqlite3_prepare(db, queryString, -1, &stmt, nil) != SQLITE_OK{
            let errmsg = String(cString: sqlite3_errmsg(db)!) // error code 생성
            print("error preparing select: \(errmsg)")
            return // error가 걸리면 이 메소드를 벗어남
        }
        
        
        // 1줄씩 Data 불러오기
        while(sqlite3_step(stmt) == SQLITE_ROW){
            let id = sqlite3_column_int(stmt, 0)
            let name = String(cString: sqlite3_column_text(stmt, 1))
            let dept = String(cString: sqlite3_column_text(stmt, 2))
            let phone = String(cString: sqlite3_column_text(stmt, 3))
            
            print(id, name, dept, phone)
            
            // 배열에 데이터 추가 (생성자 이용)
            // describing:   :: Optional을 제거
            studentsList.append(Students(id: Int(id), name: String(name), dept: String(dept), phone: String(phone)))
        }
        
        // table을 재구성
        self.tvListView.reloadData()
        
    }
    
    // ****화면이 뒤에 있었다가 다시 올라왔을 때 실행되는 기능****
    override func viewWillAppear(_ animated: Bool) {
    // 화면 재구성 (numberOfSections, tableView, tableView 실행)
        readValues() // DB내용을 다시 읽어와 배열을 재구성
        tvListView.reloadData() //Table을 재구성
    }
    

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1 // 사용할 섹션의 값
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return studentsList.count // count만큼 행을 추가
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "myCell", for: indexPath)

        // Configure the cell... 셀 모양 구성
        let students: Students
        students = studentsList[indexPath.row] // studentsList의 요소를 가져옴
        
        // cell의 title
        cell.textLabel?.text = "학번 : \(students.id)"
        // cell의 subtitle
        cell.detailTextLabel?.text = "성명 : \(students.name!)"

        return cell
    }
    

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    // Table 셀 삭제 ( 기능 )
    // 1. 왼쪽으로 드래그 해도 삭제가 됨
    // 2. 혹은 상단의 Edit을 누르고 - 버튼을 누른 후 delete 버튼을 눌러서 삭제
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            print("Delete")
            studentsList.remove(at: indexPath.row) // 선택한 셀의 내용 삭제
            tableView.deleteRows(at: [indexPath], with: .fade) // 셀 행 삭제
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    
    // 삭제시 'Delete' 글씨를 '삭제'로 보여주기
    override func tableView(_ tableView: UITableView, titleForDeleteConfirmationButtonForRowAt indexPath: IndexPath) -> String? {
        return "삭제"
    }

    // 목록 순서 바꾸기
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {
        // 이동할 item의 위치
        let itemToMove = studentsList[fromIndexPath.row] // 이동시킬 셀(Data)
        let itemDataToMove = studentsList[fromIndexPath.row] // 옮길 위치의 셀(Data)
                
        // 이동할 item을 삭제
        studentsList.remove(at: fromIndexPath.row)
                
        // 해당 위치로 삽입 (이동시킴)
        studentsList.insert(itemToMove, at: to.row)

    }
    

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
        
        // 클릭한 셀의 정보 가져오기
        // segue 이름이 "sgDetail"이면
        if segue.identifier == "sgDetail"{
            let cell = sender as! UITableViewCell // sender를 이용해서 UITableViewCell과 연결
            let indexPath = self.tvListView.indexPath(for: cell) // 클릭한 셀의 indexPath를 가져옴

            let detailView = segue.destination as! DetailViewController // sender를 이용해서 DetailViewController과 연결
            
            //클릭한 셀의 indexPath의 Data를 가져옴
            detailView.receiveItems(studentsList[indexPath!.row].id, studentsList[indexPath!.row].name!, studentsList[indexPath!.row].dept!, studentsList[indexPath!.row].phone!)
            
        }
    }
    

}
