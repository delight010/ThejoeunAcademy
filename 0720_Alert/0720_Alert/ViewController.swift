//
//  ViewController.swift
//  0720_Alert
//
//  Created by Seong A Oh on 2021/07/20.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var lampImage: UIImageView!
    
    let imgOn = UIImage(named: "lamp_on.png")
    let imgOff = UIImage(named: "lamp_off.png")
    let imgRemove = UIImage(named: "lamp_Remove.png")
    
    var isLampOn = true // Lamp State, 상태 변수
    var isLampInsert = true // Lamp State, 상태 변수

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        lampImage.image = imgOn // image 출력
    }
    
    
    @IBAction func btnLampOn(_ sender: UIButton) {
        if isLampOn { // true 일 때
            // Controller 초기화
            // Title과 메세지 만들기
            let lampOnAlert = UIAlertController(title: "경고", message: "현재 On 상태 입니다!", preferredStyle: .alert)
            
            // AlertAction ( 중앙 메세지 )
            // 버튼 모양 + 기능 만들기
            // .default   ::  파란색 글씨
            // .destructive  ::  빨간색 글씨
            // .cancel  :: 파란색 Bold 글씨
            let onAction = UIAlertAction(title: "네, 알겠습니다.", style: .default, handler: nil)
            
            // Controller와 Action결합
            lampOnAlert.addAction(onAction)
            
            // 화면 띄우기
            // animated: true   :: 애니메이션 효과가 있음
            present(lampOnAlert, animated: true, completion: nil)
        }else{ // false 일 때
            lampImage.image = imgOn
            isLampOn = true
        }
    }
    
    @IBAction func btnLampOff(_ sender: UIButton) {
        if isLampOn { // true 일 때
            // Controller 초기화
            // Title과 메세지 만들기
            let lampOffAlert = UIAlertController(title: "램프 끄기", message: "램프를 끄겠습니까?", preferredStyle: .alert)
            
            // AlertAction ( 중앙 메세지 )
            // 버튼 모양 + 기능 만들기
            // .default   ::  파란색 글씨
            // .destructive  ::  빨간색 글씨
            // .cancel  :: 파란색 Bold 글씨
            let leftAction = UIAlertAction(title: "네", style: .default, handler: {ACTION in
                // 실행할 내용
                self.lampImage.image = self.imgOff
                self.isLampOn = false
            })
            let rightAction = UIAlertAction(title: "아니오", style: .default, handler: nil)
            
            // Controller와 Action결합
            lampOffAlert.addAction(leftAction)
            lampOffAlert.addAction(rightAction)
            
            // 화면 띄우기
            // animated: true   :: 애니메이션 효과가 있음
            present(lampOffAlert, animated: true, completion: nil)
        }else{ // false 일 때
            // Controller 초기화
            // Title과 메세지 만들기
            let lampOffAlert = UIAlertController(title: "경고", message: "현재 램프가 Off 상태입니다.", preferredStyle: .alert)
            
            present(lampOffAlert, animated: true, completion: nil)
        }
        
    }
    
    @IBAction func btnLampRemove(_ sender: UIButton) {
        if isLampInsert{ // true 일 때
            // Controller 초기화
            // Title과 메세지 만들기
            let lampStateAlert = UIAlertController(title: "램프 제거?", message: "램프를 제거할까요?", preferredStyle: .alert)
            
            // AlertAction ( 중앙 메세지 )
            // 버튼 모양 + 기능 만들기
            // .default   ::  파란색 글씨
            // .destructive  ::  빨간색 글씨
            // .cancel  :: 파란색 Bold 글씨
            let lampOffAction = UIAlertAction(title: "아니오, 끕니다!", style: .default, handler: {ACTION in
                // 실행할 내용
                self.lampImage.image = self.imgOff
                self.isLampOn = false
            })
            
            let lampOnAction = UIAlertAction(title: "아니오, 켭니다!", style: .default, handler: {ACTION in
                // 실행할 내용
                self.lampImage.image = self.imgOn
                self.isLampOn = true
            })
            
            let lampRemoveAction = UIAlertAction(title: "네, 제거 합니다!", style: .default, handler: {ACTION in
                // 실행할 내용
                self.lampImage.image = self.imgRemove
                self.isLampInsert = false
            })
            
            // Controller와 Action 결합
            lampStateAlert.addAction(lampOffAction)
            lampStateAlert.addAction(lampOnAction)
            lampStateAlert.addAction(lampRemoveAction)
            
            // 화면 띄우기
            present(lampStateAlert, animated: true, completion: nil)
            
        }else{ // false 일 때
            // Controller 초기화
            // Title과 메세지 만들기
            let lampStateAlert = UIAlertController(title: "경고", message: "현재 램프가 remove된 상태입니다.", preferredStyle: .alert)
            
            // 화면 띄우기
            present(lampStateAlert, animated: true, completion: nil)
            
        }
        
    }
    


} // ViewController

