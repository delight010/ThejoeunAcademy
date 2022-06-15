//
//  TableViewController.swift
//  0728_KannaPractice
//
//  Created by Seong A Oh on 2021/07/28.
//

import UIKit
import Kanna

var list: [String] = [] // crawling한 data 값을 넣을 변수

class TableViewController: UITableViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
        
        dataCrawling()
    }
    
    // dataCrawling 메소드 정의
    func dataCrawling(){
        let mainUrl = "https://shoppinghow.kakao.com/search/%EC%95%84%EA%B8%B0%20%EC%9A%B0%EC%A3%BC%EB%B3%B5"
        
        // 만일 url이 null 이라면
        guard let main = URL(string: mainUrl) else {
            print("Error: \(mainUrl) doesn't seem to be a valid URL")
            return
        }
        
        do{
            // //*[@id="E5102934697"]/strong/a
            // //*[@id="C5102818531"]/strong/a
            
            // main 주소를 utf8로 인코딩
            let htmlData = try String(contentsOf: main, encoding: .utf8)
            // htmlData에 접근 시도 utf8로 인코딩
            let doc = try HTML(html: htmlData, encoding: .utf8)
            
            var count = 1 // 순서 번호를 보여주기 위한 변수
            for title in doc.xpath("//strong/a") {// xpath는 Python으로 찾든 Xcode로 찾든 동일
                // 번호와 title을 불러옴.
                // .trimmingCharacters(in: .whitespacesAndNewlines)를 이용하여 공백을 제거
                print(count, title.text!.trimmingCharacters(in: .whitespacesAndNewlines))
                
                // list 배열에 Data 추가
                list.append(title.text!.trimmingCharacters(in: .whitespacesAndNewlines))
                count += 1
            }
            
        }catch let error{
            print("Error : \(error)")
        }
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return list.count
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "myCell", for: indexPath)

        // Configure the cell...// cell 내용 구성
        cell.textLabel?.text = "\(indexPath.row+1): \(list[indexPath.row])"

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

}
