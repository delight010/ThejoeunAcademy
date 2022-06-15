//
//  ViewController.swift
//  0719_BackgroundPicker
//
//  Created by TJ on 2021/07/19.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var lblCurrentTime: UILabel!
    @IBOutlet weak var lblPickerTime: UILabel!
    
    let interval = 1.0 // 1초 (간격)
    let timeSelector: Selector = #selector(ViewController.updateTime) // 선택자
    // ViewController의 updateTime을 실행
    //let timeSelector: Selector = #selector(ViewController.equalTime) // ViewController의 equalTime을 실행
    

    var currentTime = ""
    var pickerTime = ""
    var overTime = ""
    
    var count: Int = 0 // 1초마다 +1
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        lblPickerTime.text = "시간을 선택하세요!"
        Timer.scheduledTimer(timeInterval: interval, target: self, selector: timeSelector, userInfo: nil, repeats: true) // Async
        
        
    }

    // 선택한 시간
    @IBAction func changeDatePicker(_ sender: UIDatePicker) {
        //sender는 UIDatePicker의 time을 알고 있음.
        let datePickerView = sender
        print(datePickerView.date)
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko") // 지역
        formatter.dateFormat = "yyyy-MM-dd EEE a hh:mm"
        lblPickerTime.text = "선택시간 : \(formatter.string(from: datePickerView.date))"
        
        pickerTime = formatter.string(from: datePickerView.date)
        print(pickerTime)
    }
    
    
    // 현재시간 변경 : 선택자
    @objc func updateTime(){
        let date = NSDate() // Next Step
        let formatter = DateFormatter()
        
        formatter.locale = Locale(identifier: "ko")
        formatter.dateFormat = "yyyy-MM-dd EEE a hh:mm"
        lblCurrentTime.text = "현재 시간 : \(formatter.string(from: date as Date))"
        
        
        currentTime = formatter.string(from: date as Date)
        
        print(date)
        print(currentTime)
        //print("\(currentTime)과 \(pickerTime)")
        
        // 시간이 같다면
        if currentTime == pickerTime{
            self.view.backgroundColor = UIColor.blue
            count += 1
            // second % 2
            if count % 2 == 0{
                self.view.backgroundColor = UIColor.blue
            }else{
                self.view.backgroundColor = UIColor.red
            }
        // 시간이 다르다면
        }else{
            self.view.backgroundColor = UIColor.white
        }
        
        
    }

}// ViewController

