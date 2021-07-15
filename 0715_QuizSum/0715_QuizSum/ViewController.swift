//
//  ViewController.swift
//  0715_QuizSum
//
//  Created by TJ on 2021/07/15.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var tfNum1: UITextField!
    @IBOutlet weak var tfNum2: UITextField!
    
    @IBOutlet weak var lblResult: UILabel!
    
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        lblResult.text = ""
        
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
    
    
    @IBAction func btnSum(_ sender: UIButton) {
        // 비어 있다면 0, 비어있지 않다면 1
        let numCheck1 = checkNil(str: tfNum1.text)
        let numCheck2 = checkNil(str: tfNum2.text)
    
        
        
        // 공백을 먼저 확인
        if numCheck1 == 0 {
            tfNum1.becomeFirstResponder()
            lblResult.text = "시작 숫자를 확인하세요!"
        }else if numCheck2 == 0 {
            tfNum2.becomeFirstResponder()
            lblResult.text = "끝 숫자를 확인하세요!"
        }else{
            guard let num1 = Int(tfNum1.text!) else { return }
            guard let num2 = Int(tfNum2.text!) else { return}
            if num1 > num2{
                lblResult.text = "시작 숫자가 끝 숫자보다 큽니다."
            }else{
            // 합계 계산
                let numResult: Int = numberSum(num1, num2)
            lblResult.text = "\(num1) ~ \(num2)의 합계는 \(numResult)입니다."
            }
        }
        
        self.view.endEditing(true)
        
        
        
    }
    
    // 공란을 체크하는 함수
    func checkNil(str: String!) -> Int{
        // 공백을 전부 없앰
        let check = str.trimmingCharacters(in: .whitespacesAndNewlines)
//        let check2 = str.trimmingCharacters(in: .whitespacesAndNewlines)
        
        if check.isEmpty == true{
            return 0
        }else{
            return 1
        }
        
    }
    
    // 합계 계산
    func numberSum(_ num1: Int, _ num2: Int) -> Int{
        var sum: Int = 0
        for i in num1...num2{
            sum += i
        }
        return sum
    }


}// ViewController

