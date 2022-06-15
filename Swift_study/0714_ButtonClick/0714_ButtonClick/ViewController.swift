//
//  ViewController.swift
//  0714_ButtonClick
//
//  Created by Seong A Oh on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var tfWelcome: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }// viewDidLoad

    @IBAction func btnName(_ sender: UIButton) {
        let name: String = "오성아"
        
        tfWelcome.text?.append(name) // 뒤에 추가함
    } //btnName
    
} // ViewController

