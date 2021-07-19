//
//  ViewController.swift
//  0719_SendMessage
//
//  Created by TJ on 2021/07/19.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var tvResult: UITextView!
    @IBOutlet weak var tfInput: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        tvResult.isEditable = false
        tvResult.text = ""
        tfInput.allowsEditingTextAttributes = true
    }

    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
                self.view.endEditing(true)
            }
    
    
    @IBAction func btnEmoji(_ sender: UIButton) {
        self.view.endEditing(true)
        tfInput.text! += "😃"
        
    }
    
    
    @IBAction func btnSend(_ sender: UIButton) {
        self.view.endEditing(true)
        
        // 공백이 들어가지 않도록 설정
        let strInput = tfInput.text!.trimmingCharacters(in: .whitespacesAndNewlines)
        
        // strInput이 비어있지 않으면 = !strInput
        if !strInput.isEmpty{
            tvResult.text += tfInput.text! + "\n"
        }
        
        tfInput.text = ""
        
    }
    
    

} // ViewController

