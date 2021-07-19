//
//  ViewController.swift
//  0719_SwitchLampOnOff
//
//  Created by TJ on 2021/07/19.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var imgView: UIImageView!
    @IBOutlet weak var lblState: UILabel!
    @IBOutlet weak var lblLampState: UILabel!
    
    
    var imgOn: UIImage? // 켜진 전구 이미지
    var imgOff: UIImage? // 꺼진 전구 이미지
    
    var isZoom = false // 이미지 확대 여부, 상태 변수
    var isLamp = false // 전구 스위치 켜짐 여부, 상태 변수
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // 이미지 파일 준비
        imgOn = UIImage(named: "lamp_on.png")
        imgOff = UIImage(named: "lamp_off.png")
        
        // 이미지 할당
        imgView.image = imgOn
    }

    @IBAction func switchZoomOnOff(_ sender: UISwitch) {
        // 이미지 크기를 2배로
        let scale: CGFloat = 2.0
        var newWidth: CGFloat
        var newHeight: CGFloat
        
        if isZoom{ // isZoom = true
            newWidth = imgView.frame.width / scale // 가로 길이
            newHeight = imgView.frame.height / scale // 세로 길이
            lblState.text = "전구 확대"
        }else{
            newWidth = imgView.frame.width * scale // 가로 길이
            newHeight = imgView.frame.height * scale // 세로 길이
            lblState.text = "전구 축소"
        }
        
        // 그림 사이즈 변경
        imgView.frame.size = CGSize(width: newWidth, height: newHeight)
        
        // isZoom 상태 변경
        isZoom = !isZoom
        // false -> true
        // true -> false로 변경
    }
    
    
    
    @IBAction func switchLampOnOff(_ sender: UISwitch) {
        //sender로 on, off를 구별함
        switch sender.isOn {
        case true:
            imgView.image = imgOn
            lblLampState.text = "전구 스위치 끄기"
        default:
            imgView.image = imgOff
            lblLampState.text = "전구 스위치 켜기"
        }
    }
    
    

} // ViewController

