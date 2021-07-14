//
//  ViewController.swift
//  0714_CalcQuiz1
//
//  Created by Seong A Oh on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {

    
    
    @IBOutlet weak var lblNotice: UILabel!
    @IBOutlet weak var tfNum1: UITextField!
    @IBOutlet weak var tfNum2: UITextField!
    
    
    @IBOutlet weak var tfSum: UITextField!
    @IBOutlet weak var tfSub: UITextField!
    @IBOutlet weak var tfMul: UITextField!
    @IBOutlet weak var tfQuotient: UITextField!
    @IBOutlet weak var tfRemainder: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        lblNotice.text = "계산기입니다."
    }

    // 커맨드 + K = (컴퓨터에뮬상에서) 키보드자판 띄우기 or 없애기
    // 띄워져있는 키보드자판 없애기
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
        
    }
    
    // 계산하기 버튼
    @IBAction func btnCalc(_ sender: UIButton) {
        typealias number = (Number1: String, Number2: String)
        var numbers = (String(tfNum1.text!), String(tfNum2.text!))
        
        // 빈칸일 때
        if tfNum1.text?.isEmpty==true||tfNum2.text?.isEmpty==true{
            lblNotice.text = "숫자를 확인하세요!"
        }else{
            tfSum.text = String(Int(numbers.0)!+Int(numbers.1)!)
            tfSub.text = String(Int(numbers.0)!-Int(numbers.1)!)
            tfMul.text = String(Int(numbers.0)!*Int(numbers.1)!)
            tfQuotient.text = String(Int(numbers.0)!/Int(numbers.1)!)
            tfRemainder.text = String(Int(numbers.0)!%Int(numbers.1)!)
        }        
        
    } // btnCalc
    
    
} // ViewController

