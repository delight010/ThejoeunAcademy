//
//  JsonModel.swift
//  0727_ServerJSON01
//
//  Created by TJ on 2021/07/27.
//

import Foundation

// Json Data를 넘겨주기 위한 Protocol
protocol JsonModelProtocol {
    func itemDownloaded(items: NSArray) // 배열 생성
}

class JsonModel{
    var delegate: JsonModelProtocol! // Protocol
    let urlPath = "http://192.168.200.180:8080/ios/student.json" // file 경로 지정
    
    // async
    func downloadItems(){
        let url: URL = URL(string: urlPath)!
        // Session과 URL 연결
        let defaultSession = Foundation.URLSession(configuration: URLSessionConfiguration.default)
        // Task를 정의, Json의 전체를 가져오기 위함,
        let task = defaultSession.dataTask(with: url){(data, response, error) in
            if error != nil{
                print("Failed to download data")
            }else{
                print("Data is downloaded")
                self.parseJSON(data!) // parseJSON에 data를 넣어줌
            }
            
        }
        task.resume() // task 실행
    }
    
    
    func parseJSON(_ data: Data){
        var jsonResult = NSArray() // json 데이터를 저장할 배열, 여러가지 자료형을 쓰기 위해 NSArray를 씀
        do{
            // Json에서 Data를 불러옴
            jsonResult = try JSONSerialization.jsonObject(with: data, options: JSONSerialization.ReadingOptions.allowFragments) as! NSArray
        }catch let error as NSError{
            print(error)
        }
        
        var jsonElement = NSDictionary() // (Key, Value) 값으로 저장하기 위한 Dictionary
        let locations = NSMutableArray() // ArrayList와 같음
        
        for i in 0..<jsonResult.count{
            // json의 {} 의 값을 1개로 취급한다
            jsonElement = jsonResult[i] as! NSDictionary // jsonResult를 NSDictionary로 변환 :: (Key, Value) 값으로 구성하기 위하여
            if let scode = jsonElement["code"] as? String, // json의 "code"의 값을 불러옴
               let sname = jsonElement["name"] as? String,
               let sdept = jsonElement["dept"] as? String,
               let sphone = jsonElement["sphone"] as? String{
                // let 변수 scode, sname, sdept, sphone이 이상이 없으면
                // DBModel 생성자를 통하여 Data를 query 변수에 넣어줌
                let query = DBModel(scode: scode, sname: sname, sdept: sdept, sphone: sphone)
                locations.add(query) // NSMutableArray(locations)에 Data를 넣어줌
            }
        }
        DispatchQueue.main.async(execute: {() -> Void in // item 다운로드 시, 위의 코드를 실행
            // locations와 async, 12행 참고
            self.delegate.itemDownloaded(items: locations) // 딕셔너리와 연결
        })
    }
}
