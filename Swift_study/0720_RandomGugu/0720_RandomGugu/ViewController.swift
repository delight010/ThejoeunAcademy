//
//  ViewController.swift
//  0720_RandomGugu
//
//  Created by Seong A Oh on 2021/07/20.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var lblNum1: UILabel!
    @IBOutlet weak var lblNum2: UILabel!
    @IBOutlet weak var tfInput: UITextField!
    
    var ranNum1 = 0
    var ranNum2 = 0
    var resultNum = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        lblNum1.text = ranNum()
        lblNum2.text = ranNum()
        
        ranNum1 = Int(lblNum1.text!)!
        ranNum2 = Int(lblNum2.text!)!
        
        print(ranNum1, ranNum2)
        
    }
    
    // 랜덤 숫자 만들기
    func ranNum() -> String{
        return String(Int.random(in: 1..<10))
    }
    
    // 키패드에서 빠져나가기
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
                    self.view.endEditing(true)
                }
    
    // 공란을 체크하는 함수
    func checkNil(str: String!) -> Int{// return type = Int
       // 공백을 전부 없앰
       let check = str.trimmingCharacters(in: .whitespacesAndNewlines)
             
       if check.isEmpty{
            return 0 // 공란이면
       }else{
            return 1
       }
     }
    
    // OK 버튼 클릭
    @IBAction func btnCheckResult(_ sender: UIButton) {
        resultNum = ranNum1 * ranNum2
        let checkInput = checkNil(str: tfInput.text!) // 공란 체크
        let inputNum = Int(tfInput.text!.trimmingCharacters(in: .whitespacesAndNewlines)) // 입력한 숫자
        
        switch checkInput {
        case 1:
            // 입력한 답과 같다면
            if resultNum == inputNum{
                // Controller 초기화
                // Title과 메세지 만들기
                let resultAlert = UIAlertController(title: "결과", message: "정답입니다", preferredStyle: .alert)
                
                // 버튼 만들기
                let onAction = UIAlertAction(title: "다음 문제 진행", style: .default, handler: {ACTION in
                    // 실행할 내용
                    // 텍스트필드, 라벨과 변수 초기화
                    self.tfInput.text = ""
                    self.lblNum1.text = self.ranNum()
                    self.lblNum2.text = self.ranNum()
                    
                    self.ranNum1 = Int(self.lblNum1.text!)!
                    self.ranNum2 = Int(self.lblNum2.text!)!
                })
                
                // Controller와 Action 결합
                resultAlert.addAction(onAction)
                
                // 화면 띄우기
                present(resultAlert, animated: true, completion: nil)
                
            }else{
                // Controller 초기화
                // Title과 메세지 만들기
                let resultAlert = UIAlertController(title: "결과", message: "정답이 아닙니다", preferredStyle: .alert)
                
                // 버튼 만들기
                let onAction = UIAlertAction(title: "네, 알겠습니다.", style: .default, handler: nil)
                
                // Controller와 Action 결합
                resultAlert.addAction(onAction)
                
                // 화면 띄우기
                present(resultAlert, animated: true, completion: nil)
                
                // 텍스트 필드 초기화
                tfInput.text = ""
            }
        default:
            // Controller 초기화
            // Title과 메세지 만들기
            let resultAlert = UIAlertController(title: "경고", message: "숫자를 입력해주세요", preferredStyle: .alert)
            
            // 버튼 만들기
            let onAction = UIAlertAction(title: "네, 알겠습니다.", style: .default, handler: nil)
            
            // Controller와 Action 결합
            resultAlert.addAction(onAction)
            
            // 화면 띄우기
            present(resultAlert, animated: true, completion: nil)
            
            // 텍스트 필드 초기화
            tfInput.becomeFirstResponder()
        }
        
        
    }
    

} // ViewController

