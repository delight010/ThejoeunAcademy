//
//  ViewController.swift
//  0720_TimerAlert
//
//  Created by Seong A Oh on 2021/07/20.
//

import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var lblCurrentTime: UILabel!
    @IBOutlet weak var lblPickerTime: UILabel!
    
    let interval = 1.0 // 1초 (간격)
    let timeSelector: Selector = #selector(ViewController.updateTime) // 선택자
    //let timeSelector: Selector = #selector(ViewController.equalTime) // ViewController의 equalTime을 실행
    
    var currentTime = ""
    var pickerTime = ""
    var overTime = ""
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        lblPickerTime.text = "시간을 선택하세요!"
        Timer.scheduledTimer(timeInterval: interval, target: self, selector: timeSelector, userInfo: nil, repeats: true) // Async
    }

    // 선택한 시간
    @IBAction func changeDatePicker(_ sender: UIDatePicker) {
        // sender는 UIDatePicker의 time을 알고 있음.
        let datePickerView = sender
        print(datePickerView.date)
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko") // 지역
        formatter.dateFormat = "yyyy-MM-dd EEE a hh:mm"
        lblPickerTime.text = "선택시간 : \(formatter.string(from: datePickerView.date))"
        
        pickerTime = formatter.string(from: datePickerView.date) + ":00"
        print(pickerTime)
    }
    
    
    // 현재 시간 변경 : 선택자
    @objc func updateTime(){
        let date = NSDate() // Next Step
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko")
        formatter.dateFormat = "yyyy-MM-dd EEE a hh:mm:ss"
        lblCurrentTime.text = "현재 시간 : \(formatter.string(from: date as Date))"
        
        currentTime = formatter.string(from: date as Date)
        
        print(date)
        print(currentTime)
        
        
        // 시간이 같다면
        if currentTime == pickerTime{
            // Controller 초기화
            // Title과 메세지 만들기
            let timeAlert = UIAlertController(title: "알림", message: "설정된 시간입니다!!!", preferredStyle: .alert)
            
            // AlertAction 생성
            let okAction = UIAlertAction(title: "네, 알겠습니다.", style: .cancel, handler: nil)
            
            // Controller와 Action 결합
            timeAlert.addAction(okAction)
            
            // 화면 띄우기
            present(timeAlert, animated: true, completion: nil)
        }else{
            
        }
        
    }
    

} // ViewController

