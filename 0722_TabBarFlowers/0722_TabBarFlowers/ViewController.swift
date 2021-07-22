//
//  ViewController.swift
//  0722_TabBarFlowers
//
//  Created by Seong A Oh on 2021/07/22.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    
    @IBAction func btnButton(_ sender: UIButton) {
        tabBarController?.selectedIndex = 1 // tabBar는 배열, 0부터 시작
        // 1번에 시작되는 바로 이동
    }
    

    @IBAction func btnTimer(_ sender: UIButton) {
        tabBarController?.selectedIndex = 2 // tabBar는 배열, 0부터 시작
    }
    
    
    @IBAction func PageController(_ sender: UIButton) {
        tabBarController?.selectedIndex = 3 // tabBar는 배열, 0부터 시작
    }
    
}

