//
//  ViewController.swift
//  0722_TabBarPractice
//
//  Created by Seong A Oh on 2021/07/22.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func btnGoImageView(_ sender: UIButton) {
        tabBarController?.selectedIndex = 1 // tabBar는 배열, 0부터 시작
        // 1번에 시작되는 바로 이동
    }
    
    
    @IBAction func btnGoDatePicker(_ sender: UIButton) {
        tabBarController?.selectedIndex = 2
    }
    
}

