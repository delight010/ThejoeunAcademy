//
//  DetailViewController.swift
//  0723_TablePickerView
//
//  Created by TJ on 2021/07/23.
//

import UIKit

class DetailViewController: UIViewController {
    
    
    @IBOutlet weak var imgView: UIImageView!
    @IBOutlet weak var lblItem: UILabel!
    
    var receiveItem = ""
    var receiveImageFile = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()

        imgView.image = UIImage(named: receiveImageFile)
        lblItem.text = receiveItem
        // Do any additional setup after loading the view.
    }
    
    // 셀 클릭시 셀에 해당하는 내용 가져오기
    func receiveItems(_ item: String, _ imageFile: String){
        receiveItem = item
        receiveImageFile = imageFile
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
