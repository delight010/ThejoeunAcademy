//
//  TableViewController.swift
//  0728_DBCRUD
//
//  Created by Seong A Oh on 2021/07/28.
//

import UIKit

class TableViewController: UITableViewController {
    @IBOutlet var listTableView: UITableView! // UITableView!인 것을 확인
    //var feedItem: NSArray = NSArray() // 배열 생성, NSArray는 한번 생성되면 값을 바꿀 수 없음
    var feedItem: NSMutableArray = NSMutableArray() // 배열 생성, NSArray는 한번 생성되면 값을 바꿀 수 없음
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Edit 버튼을 만들어 삭제 기능 추가하기, 왼쪽으로 배치 (모양만)
        self.navigationItem.leftBarButtonItem = self.editButtonItem

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
    }
    
    // 화면이 내려가있다가 다시 팝업될 때 실행
    override func viewWillAppear(_ animated: Bool) {
        let queryModel = QueryModel() // 생성자 생성
        
        // extension으로 정의한 것을 실행
        queryModel.delegate = self
        queryModel.downloadItems()
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return feedItem.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "myCell", for: indexPath)

        // Configure the cell... 셀의 모양 구성.
        // feedItem의 값을 1줄씩 받아와 셀을 구성
        let item: DBModel = feedItem[indexPath.row] as! DBModel
        
        cell.textLabel?.text = "성명 : \(item.sname!)"
        cell.detailTextLabel?.text = "학번 : \(item.scode!)"
        // Key 값을 잘 확인 할 것

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
            print("Cell Delete")
            
            
            // 클릭한 셀의 내용을 DBModel로 변환
            let item: DBModel = feedItem[indexPath.row] as! DBModel
            let code = item.scode // 선택한 행의 scode를 불러옴
            
            let deleteModel = DeleteModel()
            let result = deleteModel.deleteItems(code: code!)
            // 입력이 되면 true, 안되면 false
            
            if result{
                
                feedItem.removeObject(at: indexPath.row) // 선택한 셀의 내용 삭제
                tableView.deleteRows(at: [indexPath], with: .fade) // 셀 행 삭제
            }
            
            
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
        let itemToMove = feedItem[fromIndexPath.row] // 이동시킬 셀(Data)
        let itemDataToMove = feedItem[fromIndexPath.row] // 옮길 위치의 셀(Data)
                        
        // 이동할 item을 삭제
        feedItem.remove(fromIndexPath.row)
                        
                // 해당 위치로 삽입 (이동시킴)
        feedItem.insert(itemToMove, at: to.row)
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
            let indexPath = self.listTableView.indexPath(for: cell) // 클릭한 셀의 indexPath를 가져옴
            
            let detailView = segue.destination as! DetailViewController // sender를 이용해서 DetailViewController과 연결
            
            // 클릭한 셀의 내용을 DBModel로 변환
            let item: DBModel = feedItem[indexPath!.row] as! DBModel
            // 클릭한 셀의 indexPath의 Data를 가져옴
            detailView.receiveItems(item.scode!, item.sname!, item.sdept!, item.sphone!)
        }
    }
    

} // TableViewController

// JsonModel에 설정한 Protocol 사용
extension TableViewController: QueryModelProtocol{
    func itemDownloaded(items: NSMutableArray) {
        feedItem = items
        self.listTableView.reloadData() // TableView 재구성
    }
}
