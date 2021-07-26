//
//  TableViewController.swift
//  0726_Kanna04_TableView_WebView
//
//  Created by Seong A Oh on 2021/07/26.
//

import UIKit
import Kanna

var list: [String] = [] // crawling한 data 값을 넣을 변수
var listUrl: [String] = [] // // crawling한 data의 url 값을 넣을 변수

class TableViewController: UITableViewController {
    @IBOutlet var tvListView: UITableView! // UITableView인지 확인
    
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
        let mainUrl = "https://www.rottentomatoes.com/top/bestofrt/?year=2019"
        
        // 만일 url이 null 이라면
        guard let main = URL(string: mainUrl) else {
            print("Error: \(mainUrl) doesn't seem to be a valid URL")
            return
        }
        
        do{
            // //*[@id="top_movies_main"]/div/table/tbody/tr[1]/td[3]/a
        
            // main 주소를 utf8로 인코딩
            let htmlData = try String(contentsOf: main, encoding: .utf8)
            // htmlData에 접근 시도 utf8로 인코딩
            let doc = try HTML(html: htmlData, encoding: .utf8)
            
            var count = 1 // 순서 번호를 보여주기 위한 변수
            for title in doc.xpath("//*[@id='top_movies_main']/div/table/tr/td/a") {// xpath는 Python으로 찾든 Xcode로 찾든 동일
                // 번호와 title을 불러옴.
                // .trimmingCharacters(in: .whitespacesAndNewlines)를 이용하여 공백을 제거
                //print(count, title.text!.trimmingCharacters(in: .whitespacesAndNewlines), title["href"]!)
                
                // list 배열에 Data 추가
                list.append(title.text!.trimmingCharacters(in: .whitespacesAndNewlines))
                // listUrl 배열에 Data의 url 값 추가
                listUrl.append(title["href"]!)
                count += 1
                
                //print(list, listUrl)
            }
            
        }catch let error{
            print("Error : \(error)")
        }
    }

    // MARK: - Table view data source

    // Section당 열의 갯수
    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1 // Section의 수를 리턴
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return list.count // count한 만큼 열을 생성
    }

    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "myCell", for: indexPath)

        // Configure the cell... // cell 내용 구성
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
            
            let detailView = segue.destination as! ViewController // sender를 이용해서 ViewController과 연결
            detailView.receiveItems(listUrl[indexPath!.row])
        }
        
    }
    

} // TableViewController
