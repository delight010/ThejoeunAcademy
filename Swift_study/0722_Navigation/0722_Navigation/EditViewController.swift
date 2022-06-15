//
//  EditViewController.swift
//  0722_Navigation
//
//  Created by Seong A Oh on 2021/07/22.
//

import UIKit

class EditViewController: UIViewController {
    
    @IBOutlet weak var lblWay: UILabel!
    @IBOutlet weak var lblOnOff: UILabel!
    @IBOutlet weak var tfMessage: UITextField!
    @IBOutlet weak var swIsOn: UISwitch!
    
    var textWayValue: String = "" // ViewController에서 받아오는 내용 저장할 곳
    var textMessage: String = "" // ViewController에서 받아오는 내용(textField)
    var isOn: Bool = false // 전구의 state 변수
    
    
    // protocol 연결
    var delegate : EditDelegate?
    
    // EditViewController의 viewDidLoad는 계속 실행&종료가 반복되므로
    // 여기에 설정을 함
    override func viewDidLoad() {
        super.viewDidLoad()
        lblWay.text = textWayValue // ViewController에서 받아온 내용 출력
        tfMessage.text = textMessage
        
        swIsOn.isOn = isOn // switch에 isOn 값 적용
        if isOn{
            lblOnOff.text = "On"
        }else{
            lblOnOff.text = "Off"
        }
    }
    
    @IBAction func btnDone(_ sender: UIButton) {
        if delegate != nil{
            delegate?.didMessageEditDone(self, message: tfMessage.text!)
            delegate?.didImageOnOffDone(self, isOn: isOn)
        }
        // 현재화면 없애고 직전 화면 띄우기
        navigationController?.popViewController(animated: true)
    }
    
    
    @IBAction func swImageOff(_ sender: UISwitch) {
        if sender.isOn{
            isOn = true
            lblOnOff.text = "On"
        }else{
            isOn = false
            lblOnOff.text = "Off"
        }
    }
    
    
} // EditViewController
