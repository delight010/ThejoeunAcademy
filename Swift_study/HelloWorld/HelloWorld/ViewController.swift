//
//  ViewController.swift
//  HelloWorld
//
//  Created by Seong A Oh on 2021/07/14.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var lblHello: UILabel!
    // var(변수) lblHello(변수이름): UILabel(label)
    
    override func viewDidLoad() { // Android의 onCreate
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        lblHello.text = "Hello World!"
    }


}

