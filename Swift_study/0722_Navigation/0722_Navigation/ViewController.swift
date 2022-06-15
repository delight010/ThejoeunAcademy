//
//  ViewController.swift
//  0722_Navigation
//
//  Created by Seong A Oh on 2021/07/22.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var tfMessage: UITextField!
    @IBOutlet weak var imgView: UIImageView!
    
    let imgOn = UIImage(named: "lamp_on.png")
    let imgOff = UIImage(named: "lamp_off.png")
    
    var isOn:Bool = true // 전구의 state 변수
    
    // ViewController의 viewDidLoad는 1번만 실행됨
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        imgView.image = imgOn
        
    }
    
    // Segue 사용
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // editViewController는 segue와 연결되어있음
        // 인스턴스 생성
        let editViewController = segue.destination as! EditViewController
        
        // seque.identifier :: segue에 설정되어있는 이름 확인
        if segue.identifier == "editButton"{
            editViewController.textWayValue = "Seque : Use Button!" // 내용 전달
        }else{
            editViewController.textWayValue = "Seque : Use Bar Button!" // 내용 전달
        }
        
        editViewController.textMessage = tfMessage.text! // 내용 전달
        editViewController.delegate = self // <<<<<< ****extension에 정의한 기능 사용****
        editViewController.isOn = self.isOn // isOn의 내역 전달, self 떼도 됨.
        
    }


} //ViewController


// protocol의 확장
extension ViewController: EditDelegate{
    func didMessageEditDone(_ controller: EditViewController, message: String) {
        tfMessage.text = message // EditViewController에서 받아온 메세지출력
    }
    
    func didImageOnOffDone(_ controller: EditViewController, isOn: Bool) {
        // EditViewController에서 받아온 isOn에 따라서 
        if isOn{
            imgView.image = imgOn
            self.isOn = true
        }else{
            imgView.image = imgOff
            self.isOn = false
        }
    }
    
}

