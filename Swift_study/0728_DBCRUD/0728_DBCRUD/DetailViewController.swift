//
//  DetailViewController.swift
//  0728_DBCRUD
//
//  Created by Seong A Oh on 2021/07/28.
//

import UIKit

class DetailViewController: UIViewController {
    @IBOutlet weak var tfCode: UITextField!
    @IBOutlet weak var tfName: UITextField!
    @IBOutlet weak var tfDept: UITextField!
    @IBOutlet weak var tfPhone: UITextField!
    
    var code = ""
    var name = ""
    var dept = ""
    var phone = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        // 기본키값은 변경 안되게 설정
        tfCode.isUserInteractionEnabled = false
        
        // tf에 값 입력
        tfCode.text = code
        tfName.text = name
        tfDept.text = dept
        tfPhone.text = phone
    }
    
    // 셀 클릭시 셀에 해당하는 내용 가져오기
    func receiveItems(_ code: String, _ name: String, _ dept: String, _ phone: String){
        self.code = code
        self.name = name
        self.dept = dept
        self.phone = phone
    }

    @IBAction func btnUpdate(_ sender: UIButton) {
        let code = tfCode.text
        let name = tfName.text
        let dept = tfDept.text
        let phone = tfPhone.text
        
        let updateModel = UpdateModel()
        let result = updateModel.updateItems(code: code!, name: name!, dept: dept!, phone: phone!)
        // 입력이 되면 true, 안되면 false
        
        if result{
            let resultAlert = UIAlertController(title: "완료", message: "수정이 완료 되었습니다.", preferredStyle: .alert)
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
    
    
    
    @IBAction func btnDelete(_ sender: UIButton) {
        let code = tfCode.text
        
        let deleteModel = DeleteModel()
        let result = deleteModel.deleteItems(code: code!)
        // 입력이 되면 true, 안되면 false
        
        if result{
            let resultAlert = UIAlertController(title: "완료", message: "삭제가 완료 되었습니다.", preferredStyle: .alert)
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
