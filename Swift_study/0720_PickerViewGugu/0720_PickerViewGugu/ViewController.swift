//
//  ViewController.swift
//  0720_PickerViewGugu
//
//  Created by Seong A Oh on 2021/07/20.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var lblDan: UILabel!
    @IBOutlet weak var pickerDan: UIPickerView!
    @IBOutlet weak var tvResult: UITextView!
    
    var danList = Array<Int>(2...9) // 2단~9단
    let viewColumn = 1 // pickerView의 열의 갯수
    var maxArrayNum = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        maxArrayNum = danList.count // 출력할 데이터 갯수 설정
        tvResult.isEditable = false
        
        lblDan.text = "\(danList[0])단"
        tvResult.text = danCalc(danList[0])
        // extension으로 설정한 것을 사용
        pickerDan.dataSource = self// 갯수만큼 행을 만듦
        pickerDan.delegate = self // pickerView Title 입력 & tvResult 내용 출력
        
    }
    


} // ViewController


extension ViewController: UIPickerViewDataSource{

    // pickerView의 컬럼 갯수
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return viewColumn // 1개만 리턴
    }

    // 출력할 데이터 갯수
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return maxArrayNum
    }
} // UIPickerViewDataSource


extension ViewController: UIPickerViewDelegate{
    // PickerView에 Title 입히기
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        let dan: String? = "\(String(danList[row]))단"
        return dan
        // PickerView에 titleForRow 입력
    }


    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        lblDan.text = String(danList[row])+"단"

        var danResult = danCalc(danList[row])

        tvResult.text = "\(danResult)"
    }

} // UIPickerViewDelegate


func danCalc(_ dan: Int) -> String{
    var danResult = ""

    for i in 1...9{
        danResult += "\(dan) X \(i) = \(dan*i) \n"
    }

    return danResult
}
