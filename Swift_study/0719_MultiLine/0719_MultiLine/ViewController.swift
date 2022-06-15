//
//  ViewController.swift
//  0719_MultiLine
//
//  Created by TJ on 2021/07/19.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var tfInput: UITextField!
    @IBOutlet weak var tvResult: UITextView!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        tvResult.isEditable = false // readOnly
        
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
                self.view.endEditing(true)
            }

    
    @IBAction func btnAppend(_ sender: UIButton) {
        self.view.endEditing(true)
        // 공백이 들어가지 않도록 설정
        let strInput = tfInput.text!.trimmingCharacters(in: .whitespacesAndNewlines)
        
        // strInput이 비어있지 않으면 = !strInput
        if !strInput.isEmpty{
            tvResult.text += tfInput.text! + "\n" // optional 푸는 것은 대부분 오른쪽에서 한다
        }
        
        tfInput.text = ""
    }
    
    
    

} // ViewController

