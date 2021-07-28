//
//  AddViewController.swift
//  0728_DBCRUD
//
//  Created by Seong A Oh on 2021/07/28.
//

import UIKit

class AddViewController: UIViewController {
    
    @IBOutlet weak var tfCode: UITextField!
    @IBOutlet weak var tfName: UITextField!
    @IBOutlet weak var tfDept: UITextField!
    @IBOutlet weak var tfPhone: UITextField!
    

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    @IBAction func btnInsert(_ sender: UIButton) {
        let code = tfCode.text
        let name = tfName.text
        let dept = tfDept.text
        let phone = tfPhone.text
        
        let insertModel = InsertModel()
        let result = insertModel.insertItems(code: code!, name: name!, dept: dept!, phone: phone!)
        // 입력이 되면 true, 안되면 false
        
        if result{
            let resultAlert = UIAlertController(title: "완료", message: "입력이 되었습니다.", preferredStyle: .alert)
            let onAction = UIAlertAction(title: "OK", style: .default, handler: {ACTION in
                self.navigationController?.popViewController(animated: true)
            })
            
            resultAlert.addAction(onAction) // 실행할 액션을 추가
            // Alert 띄우기
            present(resultAlert, animated: true, completion: nil)
        }else{
            let resultAlert = UIAlertController(title: "실패", message: "에러가 발생 되었습니다.", preferredStyle: .alert)
            let onAction = UIAlertAction(title: "OK", style: .default, handler: {ACTION in
                self.navigationController?.popViewController(animated: true)
            })
            resultAlert.addAction(onAction) // 실행할 액션을 추가
            // Alert 띄우기
            present(resultAlert, animated: true, completion: nil)
        }
        
    }
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
