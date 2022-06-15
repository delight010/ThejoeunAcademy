//
//  ViewController.swift
//  0720_Delegate01
//
//  Created by Seong A Oh on 2021/07/20.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var tfInput: UITextField!
    @IBOutlet weak var lblResult: UILabel!
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        tfInput.delegate = self // extension ViewController의 내용을 적용
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
            self.view.endEditing(true)
        }
    
    
    @IBAction func btnAction(_ sender: UIButton) {
        lblResult.text = tfInput.text
        self.view.endEditing(true)
        tfInput.text = ""
        
    }
    


} // ViewController

// 확장
extension ViewController: UITextFieldDelegate{
    
    // return 버튼을 눌렀을 시에도 적용 ( 기능 정의)
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        lblResult.text = tfInput.text
        return true
    }
}
