//
//  TableViewCell.swift
//  0728_ServerJSON03
//
//  Created by Seong A Oh on 2021/07/28.
//

import UIKit

class TableViewCell: UITableViewCell {

    @IBOutlet weak var imgView: UIImageView!
    @IBOutlet weak var lblName: UILabel!
    @IBOutlet weak var lblPhone: UILabel!
    
    func showImg(){
        let url = URL(string: "http://192.168.200.180:8080/ios/clock.png")
        let data = try? Data(contentsOf: url!) // url에서 Data를 가져옴
                    
        imgView.image = UIImage(data: data!) // 이미지를 띄움
        
    }
    
    
}
