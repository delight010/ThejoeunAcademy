//
//  ViewController.swift
//  0715_quiz2
//
//  Created by TJ on 2021/07/15.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var tfNum1: UITextField!
    @IBOutlet weak var tfNum2: UITextField!
    @IBOutlet weak var tfAddition: UITextField!
    @IBOutlet weak var tfSubtraction: UITextField!
    @IBOutlet weak var tfMultiplication: UITextField!
    @IBOutlet weak var tfDivisionQuotient: UITextField!
    @IBOutlet weak var tfDivisionRemainder: UITextField!
    @IBOutlet weak var tfMessage: UILabel!
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        tfMessage.text = "숫자만 입력하세요!"
        readOnly()
        
    }
    
    
    @IBAction func btnCalc(_ sender: UIButton) {
        // Optional 제거
        guard let strNum1 = tfNum1.text else { return }
        guard let strNum2 = tfNum2.text else {
            return
        }
        
        if strNum1.isEmpty == true{
            // textfield에 포커스
            tfNum1.becomeFirstResponder()
            
            tfMessage.text = "첫번째 숫자를 입력하세요!"
        }else if strNum2.isEmpty == true {
            // textfield에 포커스
            tfNum2.becomeFirstResponder()
            
            tfMessage.text = "두번째 숫자를 입력하세요!"
        }else{
            // 숫자로 넘기기
            let num1 = Int(strNum1)!
            let num2 = Int(strNum2)!
            calculation(num1, num2)
        }
        
        
//        if tfNum1.text?.isEmpty == true {
//            // textfield에 포커스
//            tfNum1.becomeFirstResponder()
//
//            tfMessage.text = "첫번째 숫자를 입력하세요!"
//        }else if tfNum2.text?.isEmpty == true{
//            // textfield에 포커스
//            tfNum2.becomeFirstResponder()
//
//            tfMessage.text = "두번째 숫자를 입력하세요!"
//
//        }else{
//            tfAddition.text = String(Int(tfNum1.text!)! + Int(tfNum2.text!)!)
//            tfSubtraction.text = String(Int(tfNum1.text!)! - Int(tfNum2.text!)!)
//            tfMultiplication.text = String(Int(tfNum1.text!)! * Int(tfNum2.text!)!)
//
//            if tfNum2.text == "0"{
//                tfDivisionQuotient.text = "계산불가"
//                tfDivisionRemainder.text = "계산불가"
//            }else{
//
//            tfDivisionQuotient.text = String(Int(tfNum1.text!)! / Int(tfNum2.text!)!)
//            tfDivisionRemainder.text = String(Int(tfNum1.text!)! % Int(tfNum2.text!)!)
//
//            tfMessage.text = "계산이 완료 되었습니다."
//
//            }
//            self.view.endEditing(true)
//        }
                
    
    }
    
    // 계산 함수
    func calculation(_ num1: Int, _ num2: Int){
        tfAddition.text = String(num1 + num2)
        tfSubtraction.text = String(num1 - num2)
        tfMultiplication.text = String(num1 * num2)
        
        if num2 == 0{
            tfDivisionQuotient.text = "계산불가"
           tfDivisionRemainder.text = "계산불가"
        }else{
            tfDivisionQuotient.text = String(num1 / num2)
            tfDivisionRemainder.text = String(num1 % num2)
        }
        
        
        
        tfMessage.text = "계산이 완료 되었습니다."
        self.view.endEditing(true)
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }

    // 결과값들 readOnly 설정
    func readOnly(){
        tfAddition.isUserInteractionEnabled = false
        tfSubtraction.isUserInteractionEnabled = false
        tfMultiplication.isUserInteractionEnabled = false
        tfDivisionQuotient.isUserInteractionEnabled = false
        tfDivisionRemainder.isUserInteractionEnabled = false
        
    }

} // ViewController

