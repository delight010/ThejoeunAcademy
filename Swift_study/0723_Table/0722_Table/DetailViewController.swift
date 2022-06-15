//
//  DetailViewController.swift
//  0722_Table
//
//  Created by Seong A Oh on 2021/07/22.
//

import UIKit

class DetailViewController: UIViewController {
    
    @IBOutlet weak var lblItem: UILabel!
    
    var receiveItem = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        lblItem.text = receiveItem
    }
    

    // 셀 클릭시 셀에 해당하는 내용 가져오기
    func receiveItems(_ item: String){
        receiveItem = item
    }
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

} // DetailViewController
