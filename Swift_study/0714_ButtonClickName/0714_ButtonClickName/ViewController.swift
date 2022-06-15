//
//  ViewController.swift
//  0714_ButtonClickName
//
//  Created by Seong A Oh on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var lblWelcome: UILabel!
    var count: Int = 1
    var name: String = " 오성아"

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    
    @IBAction func btnName(_ sender: UIButton) {
        count += 1
        
        if count%2==0{
            lblWelcome.text?.append(name)
        }else{
            lblWelcome.text = "Welcome!"
        }
    }
    

}// UIViewController

