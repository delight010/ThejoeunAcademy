//
//  TableViewController.swift
//  0728_ServerJSON03
//
//  Created by Seong A Oh on 2021/07/28.
//

import UIKit

class TableViewController: UITableViewController {
    @IBOutlet var listTableView: UITableView! // UITableView! 인것을 확인
    var feedItem: NSArray = NSArray() // NSArray 생성, Json의 내용을 넣을 것, 어떤 자료형이 들어올 지 모르기때문에 NSArray로 생성
    // NextStepArray
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // extension으로 설정한 것들을 실행
        let jsonModel = JsonModel() // JsonModel에 설정한 생성자 생성
        jsonModel.delegate = self
        jsonModel.downloadItems()
        
        // Cell의 크기를 정의
        listTableView.rowHeight = 128 // 세로폭의 길이

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
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
        // as! TableViewCell   ::   cell -> TableViewCell로 변환
        let cell = tableView.dequeueReusableCell(withIdentifier: "myCell", for: indexPath) as! TableViewCell

        // Configure the cell... 셀의 모양 구성
        // feedItem의 값을 1줄씩 받아와 셀을 구성
        let item: DBModel = feedItem[indexPath.row] as! DBModel
        
        // TableViewCell에서 정한 이름으로 Cell을 재정의
        cell.lblName.text = "성명:\(item.sname!)"
        cell.lblPhone.text = "전화:\(item.sphone!)"
        cell.showImg()

        return cell
    }
    
    
    

    /*
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            // Delete the row from the data source
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

} // TableViewController

// JsonModel에 설정한 Protocol 사용
extension TableViewController: JsonModelProtocol{
    func itemDownloaded(items: NSArray) {
        feedItem = items
        self.listTableView.reloadData() // TableView 재구성
    }
}
