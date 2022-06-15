//
//  ViewController.swift
//  0722_NavigationLamp
//
//  Created by Seong A Oh on 2021/07/22.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var imgView: UIImageView!
    
    let imgOn = UIImage(named: "lamp_on.png")
    let imgOff = UIImage(named: "lamp_off.png")
    let imgRed = UIImage(named: "lamp_red.png")
    
    var isOn: Bool = true // 전구 on/off state 변수
    var isRed: Bool = false // 전구 Red state 변수
    
    // ViewController의 viewDidLoad는 1번만 실행됨
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        imgView.image = imgOn
    }
    
    // Segue의 사용
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // choiceViewController는 segue와 연결되어있음
        // 인스턴스 생성
        let choiceViewController = segue.destination as! ChoiceViewController
        
        // seque.identifier :: segue에 설정되어있는 이름 확인
        if segue.identifier == "choiceBarButton"{
            choiceViewController.isOn = self.isOn
            choiceViewController.isRed = self.isRed
        }else{
            choiceViewController.isOn = self.isOn
            choiceViewController.isRed = self.isRed
        }
        
        choiceViewController.isOn = self.isOn // isOn의 내역 전달, self 떼도 됨.
        choiceViewController.isRed = self.isRed // isRed의 내역 전달, self 떼도 됨.
        choiceViewController.delegate = self // <<<<<< ****extension에 정의한 기능 사용****
        
        
    }


} // ViewController

// protocol의 확장
extension ViewController: ChoiceDelegate{
    func didLampOnOffDone(_ controller: ChoiceViewController, isOn: Bool, isRed: Bool) {
        // EditViewController에서 받아온 isOn에 따라서
        if isOn && isRed{
            imgView.image = imgRed
            self.isOn = true
            self.isRed = true
        }else if isOn{
            imgView.image = imgOn
            self.isOn = true
            self.isRed = false
        }else{
            imgView.image = imgOff
            self.isOn = false
        }
    }
    
    
    
}

