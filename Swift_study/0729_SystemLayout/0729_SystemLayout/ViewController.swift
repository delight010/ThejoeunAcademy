//
//  ViewController.swift
//  0729_SystemLayout
//
//  Created by TJ on 2021/07/29.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var tfUserId: UITextField!
    @IBOutlet weak var tfUserPassword: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        
    }

    @IBAction func btnOK(_ sender: UIButton) {
        if tfUserId.text == "aaa" && tfUserPassword.text == "1111"{
            Share.userID = tfUserId.text! // Share에 저장
            
            // segue 이름이 afterChecking인 곳으로 이동
            self.performSegue(withIdentifier: "afterChecking", sender: self)
        }else{
            // alert 모양 생성
            let idAlert = UIAlertController(title: "경고", message: "ID나 암호가 불일치 합니다!", preferredStyle: .alert)
            // alert 기능
            let idAction = UIAlertAction(title: "Yes", style: .default, handler: nil)
            idAlert.addAction(idAction) // 기능 추가
            
            // alert 띄우기
            present(idAlert, animated: true, completion: nil)
        }
    }
    
}

