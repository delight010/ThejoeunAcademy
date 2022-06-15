//
//  AddViewController.swift
//  0723_TablePickerView
//
//  Created by TJ on 2021/07/23.
//

import UIKit

class AddViewController: UIViewController {
    @IBOutlet weak var imgView: UIImageView!
    @IBOutlet weak var lblImageName: UILabel!
    @IBOutlet weak var tfAddItem: UITextField!
    @IBOutlet weak var pickerView: UIPickerView!
    
    
    var imageFile = ["cart.png", "clock.png", "pencil.png"]
    var imageArray = [UIImage?]() // image'File'을 넣는 배열
    var maxArrayNum = 0
    let viewColumn = 1
    var selectImage = "" // Main View 배열에 추가할 이미지 이름
    
    override func viewDidLoad() {
        super.viewDidLoad()
        maxArrayNum = imageFile.count
        
        // imageArray Data 설정(이유: 로딩을 줄이기 위해 미리 데이터를 넣어둠)
        for i in 0..<maxArrayNum{
            let image = UIImage(named: imageFile[i])
            imageArray.append(image)
        }
        
        lblImageName.text = imageFile[0]
        imgView.image = imageArray[0]
        
        // extension으로 설정한 것을 사용
        pickerView.dataSource = self // 갯수만큼 행을 만듦
        pickerView.delegate = self
        
    }
    
    // 셀 추가 (배열에 추가)
    @IBAction func btnAddItem(_ sender: UIButton) {
        items.append(tfAddItem.text!)
        itemsImageFile.append(selectImage)

        // 현재 화면을 끄고 직전 화면 띄우기
        navigationController?.popViewController(animated: true)
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

} // AddViewController

extension AddViewController: UIPickerViewDataSource{
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
    
} // AddViewController

extension AddViewController: UIPickerViewDelegate{
//    // PickerView에 Title 입히기
//    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
//        return imageFile[row] // PickerView에 titleForRow 입력
//    }
    
    // PickerView에 thumnail 배치
    func pickerView(_ pickerView: UIPickerView, viewForRow row: Int, forComponent component: Int, reusing view: UIView?) -> UIView {
        let imageView = UIImageView(image: imageArray[row])
        imageView.frame = CGRect(x: 0, y: 0, width: 50, height: 20)
        
        return imageView
    }
    
    // PickerView에 Image 선택
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        lblImageName.text = imageFile[row] // 라벨에 이미지 파일 이름 입력
        imgView.image = imageArray[row] // 이미지 뷰에 이미지 띄우기
//        imgView.image = UIImage(named: imageFile[row]) // 이미지 뷰에 이미지 띄우기
        selectImage = imageFile[row] // 변수에 이미지파일 이름 입력
    }
} // // UIPickerViewDelegate
