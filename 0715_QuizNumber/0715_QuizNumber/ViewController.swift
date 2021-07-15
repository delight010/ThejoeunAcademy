//
//  ViewController.swift
//  0715_QuizNumber
//
//  Created by TJ on 2021/07/15.
//

import UIKit

class ViewController: UIViewController {
    
    
    
    @IBOutlet weak var lblResult: UILabel!
    
    @IBOutlet weak var tfInputNumber: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        lblResult.text = ""
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
    
    
    @IBAction func btnDecision(_ sender: UIButton) {
        // var message: String
        /*
        let checkNumber = Int(tfInputNumber.text!) ?? 0
         // ??는 무조건 true만을 확인
        if checkNumber % 2 == 0{
            message = "짝수"
        }else{
            message = "홀수"
        }
        
        lblResult.text = "입력하신 숫자는 \(message)입니다."
         */
        
        let numCheck = checkNil(str: tfInputNumber.text!)
        // 비어있다면 0, 비어있지않다면 1
        
        if numCheck == 1{
            let returnValue = numberDecision(str: tfInputNumber.text!)
            lblResult.text = "입력 하신 숫자는 \(returnValue)입니다."
        }else{
            lblResult.text = "숫자를 확인하세요!"
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
    
    // 홀수 짝수를 판별하는 함수
    func numberDecision(str: String!) -> String{ // return type = String
        if Int(str)! % 2 == 0{
            return "짝수"
        }else{
            return "홀수"
        }
    }
        
    


} //ViewController

