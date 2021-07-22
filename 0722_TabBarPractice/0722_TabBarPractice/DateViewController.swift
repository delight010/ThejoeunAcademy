//
//  ViewController.swift
//  0719_DatePicker
//
//  Created by TJ on 2021/07/19.
//

import UIKit

class DateViewController: UIViewController {

    @IBOutlet weak var lblCurrentTime: UILabel!
    @IBOutlet weak var lblPickerTime: UILabel!
    
    let interval = 1.0 // 1초 (간격)
    let timeSelector: Selector = #selector(DateViewController.updateTime) // 선택자
    // ViewController의 updateTime을 실행
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        lblPickerTime.text = "시간을 선택하세요!"
        Timer.scheduledTimer(timeInterval: interval, target: self, selector: timeSelector, userInfo: nil, repeats: true)// Async
    }
    
    
    
    @IBAction func changeDatePicker(_ sender: UIDatePicker) {
        //sender는 UIDatePicker의 time을 알고 있음.
        let datePickerView = sender
        print(datePickerView.date)
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko") // 지역
        formatter.dateFormat = "yyyy-MM-dd EEE a hh:mm" // 24시간은 HH
        // EEE :: 요일
        // a  :: 오전/오후
        lblPickerTime.text = "선택시간 : \(formatter.string(from: datePickerView.date))"
    }
    
    // 선택자
    @objc func updateTime(){
        let date = NSDate() // Next Step
        let formatter = DateFormatter()
        
        
        formatter.locale = Locale(identifier: "ko")
        formatter.dateFormat = "yyyy-MM-dd EEE a hh:mm"
        lblCurrentTime.text = "현재 시간 : \(formatter.string(from: date as Date))"
        
        print(date)
    }

}// ViewController

