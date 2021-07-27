//
//  ViewController.swift
//  0727_ServerImageArray
//
//  Created by TJ on 2021/07/27.
//

import UIKit

var imgList = [UIImage?]() // 이미지 파일을 넣는 배열
var numImage = 0

class ViewController: UIViewController {
    @IBOutlet weak var imgView: UIImageView!
    @IBOutlet weak var btnPrev: UIButton!
    @IBOutlet weak var btnNext: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        getImage() // 이미지 파일을 불러와서 배열에 저장
        //print(imgList)
        imgView.image = UIImage?(imgList[0]!)
    }

    // 이미지 파일 불러와서 배열에 저장
    func getImage(){
        for i in 1...6{
            let url = URL(string: "http://192.168.200.180:8080/ios/flower_0\(i).png")
            let data = try? Data(contentsOf: url!) // url에서 Data를 가져옴
            imgList.append(UIImage(data: data!))
        }
        //imgView.image = UIImage(data: data!) // 이미지를 띄움
        // 여러 이미지일 경우 배열에 저장
    }
    
    
    @IBAction func btnPrev(_ sender: UIButton) {
        numImage -= 1
        if numImage < 0 {
            numImage = imgList.count-1
        }
        
        imgView.image = UIImage?(imgList[numImage]!)
    }
    
    
    @IBAction func btnNext(_ sender: UIButton) {
        numImage += 1
        if numImage >= imgList.count{
            numImage = 0
        }
        
        imgView.image = UIImage?(imgList[numImage]!)
    }
    

}

