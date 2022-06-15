//
//  ViewController.swift
//  0714_ButtonClickEmoji
//
//  Created by Seong A Oh on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var lbl1: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }// viewDidLoad

    @IBAction func btnSmile(_ sender: UIButton) {
        
        let someCharacter: Character = "😆"
        
        lbl1.text?.append(someCharacter)
        
    }// btnSmile
    
} // ViewController

