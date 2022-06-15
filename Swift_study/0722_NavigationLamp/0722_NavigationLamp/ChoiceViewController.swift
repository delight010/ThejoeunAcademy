//
//  ChoiceViewController.swift
//  0722_NavigationLamp
//
//  Created by Seong A Oh on 2021/07/22.
//

import UIKit

class ChoiceViewController: UIViewController {
    @IBOutlet weak var swIsOn: UISwitch!
    @IBOutlet weak var swRed: UISwitch!
    
    var isOn: Bool = false // 전구 on/off state 변수
    var isRed: Bool = false // 전구 red state 변수
    
    // protocol 연결
    var delegate: ChoiceDelegate?
    
    // EditViewController의 viewDidLoad는 계속 실행&종료가 반복되므로
    // 여기에 설정을 함
    override func viewDidLoad() {
        super.viewDidLoad()
        
        swIsOn.isOn = isOn // switch에 isOn 값 적용
        swRed.isOn = isRed // switch에 isRed 값 적용
        
        if isOn{
            
        }
        

        
    }
    
    // 완료 버튼
    @IBAction func btnDone(_ sender: UIButton) {
        if delegate != nil{
            delegate?.didLampOnOffDone(self, isOn: isOn, isRed: isRed) // 변경
        }
        
        // 현재화면 없애고 직전 화면 띄우기
        navigationController?.popViewController(animated: true)
    }
    
    
    // On Switch
    @IBAction func swLampOn(_ sender: UISwitch) {
        if sender.isOn{
            isOn = true
        }else{
            isOn = false
        }
    }
    
    // Red Switch
    @IBAction func swLampRed(_ sender: UISwitch) {
        if sender.isOn{
            isRed = true
        }else{
            isRed = false
        }
    }
    

}
