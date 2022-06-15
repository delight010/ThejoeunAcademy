//
//  ViewController.swift
//  0716_Summary
//
//  Created by TJ on 2021/07/16.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var lblScoreTitle: UILabel!
    @IBOutlet weak var tfScore: UITextField!
    
    @IBOutlet weak var tvResult: UITextView!
    
    
    var scoreTitle = ["국어 점수", "영어 점수", "수학 점수", "요약"]
    var numTitle: Int = 0
    
    var score: [Int] = []

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        lblScoreTitle.text = "\(scoreTitle[0])"
        tvResult.text = ""
        tvResult.isEditable = false
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
            self.view.endEditing(true)
        }

    @IBAction func btnResult(_ sender: UIButton) {
        numTitle += 1
        if numTitle == scoreTitle.count{
            // 초기화
            numTitle = 0
            tfScore.isHidden = false // 텍스트 필드 띄우기
            lblScoreTitle.text = "\(scoreTitle[numTitle])"
            tvResult.text = ""
            score.removeAll()
            
        // 배열에 입력한 값 넣기
        }else if numTitle < Int(scoreTitle.count){
            lblScoreTitle.text = "\(scoreTitle[numTitle])"
            score.append(Int(tfScore.text!)!)
            
            tfScore.text = ""
            print(numTitle, score, scoreTitle[numTitle])
            
            // 요약
            if(numTitle == Int(scoreTitle.count-1)){
                tfScore.isHidden = true // 텍스트 필드 없애기
                lblScoreTitle.text = "\(scoreTitle[numTitle])"
                let totalScore = totalCalc(score) // 총점
                let avgScore = avgCalc(totalScore) // 평균
                
                let avgKor = scoreAndAvg(score[0], avgScore)
                let avgEng = scoreAndAvg(score[1], avgScore)
                let avgMath = scoreAndAvg(score[2], avgScore)
                
                tvResult.text = """
                총점은 \(totalScore)입니다.
                평균은 \(String(format:"%.2f",avgScore))
                \(scoreTitle[0])는 \(score[0])이며 \(avgKor)
                \(scoreTitle[1])는 \(score[1])이며 \(avgEng)
                \(scoreTitle[2])는 \(score[2])이며 \(avgMath)
                """
            }
            
            
        }else {
            
        }
        
    }
    
    // 총합계 구하기
    func totalCalc(_ scoreArray: [Int]) -> Int{ // [Int] = Array<Int>
        var totalScore:Int = 0
        
        for i in score{
            totalScore += i
        }
        
        return totalScore
    }
    
    // 평균 구하기
    func avgCalc(_ totalScore: Int) -> Double{
        var avgScore = Double(totalScore / 3)
        
        return avgScore
    }
    
    // 평균과 점수 비교
    func scoreAndAvg(_ score: Int, _ avg: Double) -> String{
        var value: String = Double(score) > avg ? "평균보다 높습니다." :
        Double(score) == avg ? "평균과 같습니다." : "평균보다 낮습니다."
        
        return value
    }
    
    
    

} // ViewController

