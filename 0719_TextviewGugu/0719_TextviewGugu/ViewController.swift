//
//  ViewController.swift
//  0719_TextviewGugu
//
//  Created by TJ on 2021/07/19.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var tfInput: UITextField!
    @IBOutlet weak var tvResult: UITextView!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        tvResult.text = ""
        tvResult.isEditable = false
    }

    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
                self.view.endEditing(true)
            }
    
    
    @IBAction func btnAppend(_ sender: UIButton) {
        self.view.endEditing(true)
        tvResult.text = ""
        // 공백이 들어가지 않도록 설정
        let strInput = tfInput.text!.trimmingCharacters(in: .whitespacesAndNewlines)
        
        // strInput이 비어있지 않으면 = !strInput
        if !strInput.isEmpty{
            for i in 1...9{
                tvResult.text += "\(tfInput.text!) X \(i) = \(Int(tfInput.text!)!*i) \n"
            }
        }
        
        tfInput.text = ""
    }
    
    

} // ViewController

