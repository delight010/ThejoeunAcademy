//
//  UpdateModel.swift
//  0728_DBCRUD
//
//  Created by Seong A Oh on 2021/07/28.
//

import Foundation

// Insert, Update, Delete할 때에는 protocol이 필요 X

class UpdateModel {
    var urlPath = "http://192.168.200.180:8080/ios/studentUpdate_ios.jsp" // file 경로 지정
    
    // 잘 불러왔다면 true를 return
    func updateItems(code: String, name: String, dept: String, phone: String) -> Bool{
        var result: Bool = true
        let urlAdd = "?code=\(code)&name=\(name)&dept=\(dept)&phone=\(phone)" // urlPath 뒤에 붙는 주소
        urlPath = urlPath + urlAdd
        print(urlPath)
        
        // 한글 url encoding
        urlPath = urlPath.addingPercentEncoding(withAllowedCharacters: CharacterSet.urlQueryAllowed)!
        
        let url: URL = URL(string: urlPath)!
        // Session과 URL 연결
        let defaultSession = URLSession(configuration: URLSessionConfiguration.default)
        // Task를 정의, Json의 전체를 가져오기 위함,
        let task = defaultSession.dataTask(with: url){(data, response, error) in
            if error != nil {
                print("Failed to update data")
                result = false
            }else {
                print("Data is updated")
                result = true 
            }
        }
        task.resume() // task 실행
        return result // 입력이 잘되면 true, 안되면 false를 return
    }
    
}
