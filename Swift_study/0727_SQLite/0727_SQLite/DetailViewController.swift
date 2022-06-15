//
//  DetailViewController.swift
//  0727_SQLite
//
//  Created by TJ on 2021/07/27.
//

import UIKit
import SQLite3

class DetailViewController: UIViewController {
    var db: OpaquePointer? // 포인터 설정
    
    @IBOutlet weak var tfNum: UITextField!
    @IBOutlet weak var tfName: UITextField!
    @IBOutlet weak var tfDept: UITextField!
    @IBOutlet weak var tfPhone: UITextField!
    
    var id = 0
    var name = ""
    var dept = ""
    var phone = ""
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        tfNum.text = String(id)
        tfName.text = name
        tfDept.text = dept
        tfPhone.text = phone
        
        
        // SQLite 생성하기
        // for: .documentDirectory.  :: 디렉터리 위치
        // in: .userDomainMask    :: 현재 폰트를 사용
        // 파일이 있는 지 없는 지를 확인
        let fileURL = try! FileManager.default.url(for: .documentDirectory, in: .userDomainMask, appropriateFor: nil, create: false).appendingPathComponent("StudentsData1.sqlite")
        
        // SQLITE_OK가 아니라면 :: DB를 열 수 없다면
        if sqlite3_open(fileURL.path, &db) != SQLITE_OK{
            print("error opening database")
        }
        
    }
    
    // 셀 클릭시 셀에 해당하는 내용 가져오기
    func receiveItems(_ id: Int, _ name: String, _ dept: String, _ phone: String){
        self.id = id
        self.name = name
        self.dept = dept
        self.phone = phone
    }
    
    
    // 수정
    @IBAction func btnUpdate(_ sender: UIButton) {
        var stmt: OpaquePointer? // 포인터 설정
        // ***한글이 깨지는 것을 방지 (현재 타입(한글 2바이트)에서 -1바이트)***
        let SQLITE_TRANSIENT = unsafeBitCast(-1, to: sqlite3_destructor_type.self)
        
        let id = tfNum.text?.trimmingCharacters(in: .whitespacesAndNewlines)
        let name = tfName.text?.trimmingCharacters(in: .whitespacesAndNewlines)
        let dept = tfDept.text?.trimmingCharacters(in: .whitespacesAndNewlines)
        let phone = tfPhone.text?.trimmingCharacters(in: .whitespacesAndNewlines)
        
        let queryString = "UPDATE students SET sname = '\(name!)', sdept = '\(dept!)', sphone = '\(phone!)' WHERE sid = \(id!)"
        
        // 포인터로 쓰는 것은 '&'를 붙임, 한글 입력 때문에 -1이 들어감
        // data UPDATE 시 error가 생기면 출력
        if sqlite3_prepare(db, queryString, -1, &stmt, nil) != SQLITE_OK{
            let errmsg = String(cString: sqlite3_errmsg(db)!) // error code 생성
            print("error preparing update: \(errmsg)")
            return // error가 걸리면 이 메소드를 벗어남
        }
//
//
//        // 1번째 물음표 '?'에 대입
//        if sqlite3_bind_text(stmt, 1, name, -1, SQLITE_TRANSIENT) != SQLITE_OK{
//            let errmsg = String(cString: sqlite3_errmsg(db)!) // error code 생성
//            print("error binding name: \(errmsg)")
//            return // error가 걸리면 이 메소드를 벗어남
//        }
//
//        // 2번째 물음표 '?'에 대입
//        if sqlite3_bind_text(stmt, 2, dept, -1, SQLITE_TRANSIENT) != SQLITE_OK{
//            let errmsg = String(cString: sqlite3_errmsg(db)!) // error code 생성
//            print("error binding dept: \(errmsg)")
//            return // error가 걸리면 이 메소드를 벗어남
//        }
//
//        // 3번째 물음표 '?'에 대입
//        if sqlite3_bind_text(stmt, 3, phone, -1, SQLITE_TRANSIENT) != SQLITE_OK{
//            let errmsg = String(cString: sqlite3_errmsg(db)!) // error code 생성
//            print("error binding phone: \(errmsg)")
//            return // error가 걸리면 이 메소드를 벗어남
//        }
//
//        // 4번째 물음표 '?'에 대입
//        if sqlite3_bind_text(stmt, 4, id, -1, SQLITE_TRANSIENT) != SQLITE_OK{
//            let errmsg = String(cString: sqlite3_errmsg(db)!) // error code 생성
//            print("error binding id: \(errmsg)")
//            return // error가 걸리면 이 메소드를 벗어남
//        }
        
        
        // 쿼리문 실행
        if sqlite3_step(stmt) != SQLITE_DONE{
            let errmsg = String(cString: sqlite3_errmsg(db)!) // error code 생성
            print("failure updating student: \(errmsg)")
            return // error가 걸리면 이 메소드를 벗어남
        }
        
        
        
        
        // Alert 창 만들기(모양)
        let resultAlert = UIAlertController(title: "결과", message: "수정 되었습니다", preferredStyle: .alert)
        let okAction = UIAlertAction(title: "네, 알겠습니다", style: .default, handler:{ACTION in
            // 현재 화면을 지우고, 직전화면을 띄우기
            self.navigationController?.popViewController(animated: true)
        })
        
        // Alert 창에서 실행할 액션 추가
        resultAlert.addAction(okAction)
        
        // Alert 창 띄우기
        present(resultAlert, animated: true, completion: nil)
        
        // error가 걸리지 않았다면
        print("Students updated successfully")
        
    }
    
    
    
    // 삭제
    @IBAction func btnDelete(_ sender: UIButton) {
        var stmt: OpaquePointer? // 포인터 설정
        // ***한글이 깨지는 것을 방지 (현재 타입(한글 2바이트)에서 -1바이트)***
        let SQLITE_TRANSIENT = unsafeBitCast(-1, to: sqlite3_destructor_type.self)
        
        let id = tfNum.text?.trimmingCharacters(in: .whitespacesAndNewlines)
        
        let queryString = "DELETE FROM students WHERE sid = ?"
        
        // 포인터로 쓰는 것은 '&'를 붙임, 한글 입력 때문에 -1이 들어감
        // data DELETE 시 error가 생기면 출력
        if sqlite3_prepare(db, queryString, -1, &stmt, nil) != SQLITE_OK{
            let errmsg = String(cString: sqlite3_errmsg(db)!) // error code 생성
            print("error preparing delete: \(errmsg)")
            return // error가 걸리면 이 메소드를 벗어남
        }
        
        
        // 1번째 물음표 '?'에 대입
        if sqlite3_bind_text(stmt, 1, id, -1, SQLITE_TRANSIENT) != SQLITE_OK{
            let errmsg = String(cString: sqlite3_errmsg(db)!) // error code 생성
            print("error binding id: \(errmsg)")
            return // error가 걸리면 이 메소드를 벗어남
        }
        
        
        // 쿼리문 실행
        if sqlite3_step(stmt) != SQLITE_DONE{
            let errmsg = String(cString: sqlite3_errmsg(db)!) // error code 생성
            print("failure inserting student: \(errmsg)")
            return // error가 걸리면 이 메소드를 벗어남
        }
        
        
        
        
        // Alert 창 만들기(모양)
        let resultAlert = UIAlertController(title: "결과", message: "삭제 되었습니다", preferredStyle: .alert)
        let okAction = UIAlertAction(title: "네, 알겠습니다", style: .default, handler:{ACTION in
            // 현재 화면을 지우고, 직전화면을 띄우기
            self.navigationController?.popViewController(animated: true)
        })
        
        // Alert 창에서 실행할 액션 추가
        resultAlert.addAction(okAction)
        
        // Alert 창 띄우기
        present(resultAlert, animated: true, completion: nil)
        
        // error가 걸리지 않았다면
        print("Students removed successfully")
    }
    
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
