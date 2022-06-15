//
//  ViewController.swift
//  0719_ImageViewLamp
//
//  Created by TJ on 2021/07/19.
//

import UIKit

class ImageViewController: UIViewController {
    
    
    @IBOutlet weak var imgView: UIImageView!
    @IBOutlet weak var btnResize: UIButton!
    
    var imgOn: UIImage? // 켜진 전구 이미지
    var imgOff: UIImage? // 꺼진 전구 이미지
    
    var isZoom = false // 이미지 확대 여부, 상태변수

    override func viewDidLoad() {
        super.viewDidLoad()
        
        // 이미지 파일 준비
        imgOn = UIImage(named: "lamp_on.png")
        imgOff = UIImage(named: "lamp_off.png")
        
        // 이미지 할당
        imgView.image = imgOn
        
    }


    @IBAction func btnResizeImage(_ sender: UIButton) {
        // 이미지 크기를 2배로
        let scale: CGFloat = 2.0
        var newWidth: CGFloat
        var newHeight: CGFloat
        
        if isZoom{ // isZoom = true
            newWidth = imgView.frame.width / scale// 가로 길이
            newHeight = imgView.frame.height / scale // 세로 길이
            btnResize.setTitle("Image 확대", for: .normal) // 버튼 이름 변경
            
        }else{
            newWidth = imgView.frame.width * scale// 가로 길이
            newHeight = imgView.frame.height * scale // 세로 길이
            btnResize.setTitle("Image 축소", for: .normal) // 버튼 이름 변경
        }
        
        // 그림 사이즈 변경
        imgView.frame.size = CGSize(width: newWidth, height: newHeight)
        
        // isZoom 상태 변경
        isZoom = !isZoom
        // false -> true
        // true -> false로 변경
    }
    
    
    
    @IBAction func switchImageOnOff(_ sender: UISwitch) {
        //sender로 on, off를 구별함
        switch sender.isOn {
        case true:
            imgView.image = imgOn
        default:
            imgView.image = imgOff
        }
        
//        if sender.isOn{ // 스위치가 On이면
//            imgView.image = imgOn
//        }else{
//            imgView.image = imgOff
//        }
    }
    
    
}// ViewController

