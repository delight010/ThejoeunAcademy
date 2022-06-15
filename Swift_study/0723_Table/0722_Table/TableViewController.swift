//
//  TableViewController.swift
//  0722_Table
//
//  Created by Seong A Oh on 2021/07/22.
//

import UIKit

// 변수 선언을 Class 정의 전에 한다.
var items = ["책 구매", "철수와 약속", "스터디 준비하기"]
var itemsImageFile = ["cart.png", "clock.png", "pencil.png"]



class TableViewController: UITableViewController {
    @IBOutlet var tvListView: UITableView! // UITableView인지 확인
    
    // 화면 뜨기 전에 실행(1회)
    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
        
        // Edit 버튼을 만들어 삭제 기능 추가하기, 왼쪽으로 배치 (모양만)
        self.navigationItem.leftBarButtonItem = self.editButtonItem
    }
    
    // ****화면이 뒤에 있었다가 다시 올라왔을 때 실행되는 기능****
    override func viewWillAppear(_ animated: Bool) {
        // 화면 재구성 (numberOfSections, tableView, tableView 실행)
        tvListView.reloadData() //
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1 // Section의 수를 리턴
    }

    // Section당 열의 갯수
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return items.count // count한 만큼 열을 생성
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "myCell", for: indexPath)

        // Configure the cell...// 셀 내용 구성
        cell.textLabel?.text = items[indexPath.row]
        cell.imageView?.image = UIImage(named: itemsImageFile[indexPath.row])
        
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
            items.remove(at: indexPath.row) // 선택한 셀의 내용 삭제
            itemsImageFile.remove(at: indexPath.row) // 선택한 셀의 이미지 삭제
            tableView.deleteRows(at: [indexPath], with: .fade) // 셀 행 삭제
            // Delete the row from the data source
            //tableView.deleteRows(at: [indexPath], with: .fade)
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
        let itemToMove = items[fromIndexPath.row] // 이동시킬 셀(Data)
        let itemImageToMove = itemsImageFile[fromIndexPath.row] // 옮길 위치의 셀(Data)
        
        // 이동할 item을 삭제
        items.remove(at: fromIndexPath.row)
        itemsImageFile.remove(at: fromIndexPath.row)
        
        // 해당 위치로 삽입 (이동시킴)
        items.insert(itemToMove, at: to.row)
        itemsImageFile.insert(itemImageToMove, at: to.row)
        
        
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
            detailView.receiveItems(items[indexPath!.row]) //클릭한 셀의 indexPath의 Data를 가져옴
            
        }
    }
    

} // TableViewController
