//
//  ViewController.swift
//  0720_AlertActionSheet
//
//  Created by Seong A Oh on 2021/07/20.
//

import UIKit

class ViewController: UIViewController {
    
    
    

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    
    @IBAction func btnAlert(_ sender: UIButton) {
        // Controller 초기화
        // Title과 메세지 만들기
        let testAlert = UIAlertController(title: "Title", message: "Message", preferredStyle: .alert)
        
        
        // AlertAction ( 중앙 메세지 )
        // 버튼 모양 + 기능 만들기
        // .default   ::  파란색 글씨
        // .destructive  ::  빨간색 글씨
        // .cancel  :: 파란색 Bold 글씨
        let actionDefault = UIAlertAction(title: "Action Default", style: .default, handler: nil)
        let actionDestructive = UIAlertAction(title: "Action Destructive", style: .destructive, handler: {ACTION in
            // 실행할 내용
            print("destructive action called.")
        })
        let actionCancel = UIAlertAction(title: "Action Cancel", style: .cancel, handler: {ACTION in
            // 실행할 내용
            print("cancel action called.")
        })
        
        // Controller와 Action결합
        testAlert.addAction(actionDefault) //
        testAlert.addAction(actionDestructive) // 실행할 내용
        testAlert.addAction(actionCancel) //
        
        // 화면 띄우기
        present(testAlert, animated: true, completion: nil)
        
    } // btnAlert
    
    
    
    @IBAction func btnActionSheet(_ sender: UIButton) {
        // Controller 초기화
        // Title과 메세지 만들기
        let testAlert = UIAlertController(title: "Title", message: "Message", preferredStyle: .actionSheet)
        
        
        // ActionSheet ( 아래쪽 메시지 )
        // 버튼 모양 + 기능 만들기
        // .default   ::  파란색 글씨
        // .destructive  ::  빨간색 글씨
        // .cancel  :: 파란색 Bold 글씨
        let actionDefault = UIAlertAction(title: "Action Default", style: .default, handler: nil)
        let actionDestructive = UIAlertAction(title: "Action Destructive", style: .destructive, handler: {ACTION in
            // 실행할 내용
            print("destructive action called.")
        })
        let actionCancel = UIAlertAction(title: "Action Cancel", style: .cancel, handler: {ACTION in
            // 실행할 내용
            print("cancel action called.")
        })
        
        // Controller와 Action결합
        testAlert.addAction(actionDefault) //
        testAlert.addAction(actionDestructive) // 실행할 내용
        testAlert.addAction(actionCancel) //
        
        // 화면 띄우기
        present(testAlert, animated: true, completion: nil)
    } // btnActionSheet
    

}// ViewController

