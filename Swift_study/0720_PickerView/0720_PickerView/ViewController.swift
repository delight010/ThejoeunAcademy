//
//  ViewController.swift
//  0720_PickerView
//
//  Created by Seong A Oh on 2021/07/20.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var pickerImage: UIPickerView!
    @IBOutlet weak var lblImageFileName: UILabel!
    @IBOutlet weak var imageView: UIImageView!
    
    var imageFileName = ["w1.jpg", "w2.jpg", "w3.jpg", "w4.jpg", "w5.jpg", "w6.jpg", "w7.jpg", "w8.jpg", "w9.jpg", "w10.jpg"]
    var imageArray = [UIImage?]() // image'File'을 넣는 배열
    var maxArrayNum = 0
    let viewColumn = 1

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        maxArrayNum = imageFileName.count
        
        // imageArray Data 설정(이유: 로딩을 줄이기 위해 미리 데이터를 넣어둠)
        for i in 0..<maxArrayNum{
            let image = UIImage(named: imageFileName[i])
            imageArray.append(image)
        }
        
        lblImageFileName.text = imageFileName[0]
        imageView.image = imageArray[0]
        
        // extension으로 설정한 것을 사용
        pickerImage.dataSource = self // 갯수만큼 행을 만듦
        pickerImage.delegate = self
    }


} // ViewController

extension ViewController: UIPickerViewDataSource{
    
    // pickerView의 컬럼 갯수
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return viewColumn // 1개만 return
    }
    
    // 출력할 이미지 파일 갯수
    // numberOfRowsInComponent : 사용자가 알기 쉽도록 정의한 이름
    // component : 파라미터명
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return maxArrayNum
    }
} // UIPickerViewDataSource


extension ViewController: UIPickerViewDelegate{
    // PickerView에 Title 입히기
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return imageFileName[row] // PickerView에 titleForRow 입력
    }
    
    // PickerView에 Image 선택
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        lblImageFileName.text = imageFileName[row] // 라벨에 이미지 파일 이름 입력
        imageView.image = imageArray[row] // 이미지 뷰에 이미지 띄우기
    }
    
} // UIPickerViewDelegate
