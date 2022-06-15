//
//  ViewController.swift
//  0716_avgGrade
//
//  Created by TJ on 2021/07/16.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var tfKor: UITextField!
    @IBOutlet weak var tfMath: UITextField!
    @IBOutlet weak var tfEng: UITextField!
    @IBOutlet weak var lblResult: UILabel!
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        lblResult.text = "숫자만 입력하세요"
        
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
            self.view.endEditing(true)
        }
    
    // 계산하기 버튼 이벤트
    @IBAction func btnResult(_ sender: UIButton) {
        self.view.endEditing(true)
        
        let checkKor = checkNil(str: tfKor.text!)
        let checkMath = checkNil(str: tfMath.text!)
        let checkEng = checkNil(str: tfEng.text!)
        
        if checkKor == 0{
            tfKor.becomeFirstResponder()
            lblResult.text = "국어 점수를 입력해주세요"
        }else if checkMath == 0{
            tfMath.becomeFirstResponder()
            lblResult.text = "수학 점수를 입력해주세요"
        }else if checkEng == 0{
            tfEng.becomeFirstResponder()
            lblResult.text = "영어 점수를 입력해주세요"
        }else if scoreDicision(tfKor.text) == 0{
            tfKor.becomeFirstResponder()
            lblResult.text = "국어 점수를 1~100까지 입력해주세요"
        }else if scoreDicision(tfMath.text) == 0{
            tfMath.becomeFirstResponder()
            lblResult.text = "국어 점수를 1~100까지 입력해주세요"
        }else if scoreDicision(tfEng.text) == 0{
            tfEng.becomeFirstResponder()
            lblResult.text = "국어 점수를 1~100까지 입력해주세요"
        }else{
            var avg: Double = avgScore(tfKor.text, tfMath.text, tfEng.text)
            var grade: String = gradeResult(avg)
            lblResult.text = "평균 점수는 \(String(format:"%.2f",avg))이고 등급은 \(grade)입니다."
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
    
    // 점수 판별 (1~100사이인지 확인)
    func scoreDicision(_ score: String!) -> Int {
        if Int(score!)! < 0{
            return 0
        }else if Int(score!)! > 100{
            return 0
        }else{
           return 1
        }
    }
    
    // 평균 구하기
    func avgScore(_ Kor: String!, _ Math: String!, _ Eng: String!) -> Double{
        var avg: Double = Double((Int(Kor!)! + Int(Math!)! + Int(Eng!)!) / 3)
        return avg
    }
    
    // 배열을 이용하여 등급매기기
    func gradeResult(_ avg: Double) -> String {
        var grade: String = ""
        var score = [90, 80, 70, 60, 0]
        var level = ["수", "우", "미", "양", "가"]
        
        for i in 0..<score.count{
            if avg >= Double(score[i]){
                grade = level[i]
                break
            }
        }
        return grade
    }
    

} // ViewController

