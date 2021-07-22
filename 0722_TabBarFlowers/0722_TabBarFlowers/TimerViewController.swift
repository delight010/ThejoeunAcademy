//
//  ViewController.swift
//  0719_3SecondImageChange
//
//  Created by TJ on 2021/07/19.
//

import UIKit

class TimerViewController: UIViewController {
    
    
    @IBOutlet weak var imgTitle: UILabel!
    @IBOutlet weak var imgView: UIImageView!
    
    var numImage = 0
    var imageName = ["flower_01.png", "flower_02.png", "flower_03.png", "flower_04.png", "flower_05.png", "flower_06.png"]
    
    let interval = 3.0 // 3초 (간격)
    let timeSelector: Selector = #selector(TimerViewController.displayImage(numImage:))

    override func viewDidLoad() {
        super.viewDidLoad()
        Timer.scheduledTimer(timeInterval: interval, target: self, selector: timeSelector, userInfo: nil, repeats: true) // Async
        displayImage(numImage: numImage)
    }

    
    // 이미지뷰 내용 및 라벨 변경
    @objc func displayImage (numImage: Int){
        
        if self.numImage >= imageName.count{
            self.numImage = 0
        }
        
        print(self.numImage)
      
        imgTitle.text = imageName[self.numImage]
        imgView.image = UIImage(named: imageName[self.numImage])
        
        self.numImage += 1
    }

}// ViewController

