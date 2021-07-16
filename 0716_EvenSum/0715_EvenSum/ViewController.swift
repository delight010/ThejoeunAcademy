//
//  ViewController.swift
//  0715_EvenSum
//
//  Created by TJ on 2021/07/16.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var tfNum1: UITextField!
    @IBOutlet weak var tfNum2: UITextField!
    @IBOutlet weak var lblResult: UILabel!
    @IBOutlet weak var tfEvenSumResult: UITextField!
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        lblResult.text = "짝수만 입력하세요!"
        readOnly()
    }

    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
            self.view.endEditing(true)
        }
    
    // 덧셈 계산 버튼
    @IBAction func btnEvenSum(_ sender: UIButton) {
        self.view.endEditing(true)
        
        let numCheck1 = checkNil(str: tfNum1.text!)
        let numCheck2 = checkNil(str: tfNum2.text!)
        
        if numCheck1 == 0{
            tfNum1.becomeFirstResponder()
            lblResult.text = "첫번째 숫자를 입력하세요"
        }else if numCheck2 == 0{
            tfNum2.becomeFirstResponder()
            lblResult.text = "두번째 숫자를 입력하세요"
        }else if numberDicsion(tfNum1.text!) == 1{
            lblResult.text = "첫번째 숫자에 짝수를 입력해주세요"
        }else if numberDicsion(tfNum2.text!) == 1{
            lblResult.text = "두번째 숫자에 짝수를 입력해 주세요"
        }else{
            var evenSumResult = numEvenSum(tfNum1.text, tfNum2.text)
            tfEvenSumResult.text = "\(evenSumResult)"
            lblResult.text = ("\(tfNum1.text!)과 \(tfNum2.text!)의 덧셈 결과는 \(evenSumResult)입니다.")
        }
        
    }
    
    // 공란을 체크하는 함수
    func checkNil(str: String!) -> Int{// return type = Int
      // 공백을 전부 없앰
        let check = str.trimmingCharacters(in: .whitespacesAndNewlines)
         
        if check.isEmpty{
            return 0
        }else{
            return 1
        }
     }
    
    // 결과값 readOnly
    func readOnly(){
        tfEvenSumResult.isUserInteractionEnabled = false
    }
    
    // 홀짝 구분
    func numberDicsion(_ number: String) -> Int {
        if Int(number)! % 2 == 0 {
            return 0
        }else {
            return 1
        }
    }
    
    // 덧셈 연산
    func numEvenSum(_ number1: String!, _ number2: String!) -> Int{
        var sum: Int = Int(number1!)! + Int(number2!)!
        
        return sum
    }
    

} // ViewController

