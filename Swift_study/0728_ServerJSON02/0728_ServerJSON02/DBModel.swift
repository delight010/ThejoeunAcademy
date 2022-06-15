//
//  DBModel.swift
//  0728_ServerJSON02
//
//  Created by Seong A Oh on 2021/07/28.
//

import Foundation

// Json 사용 시 class에 type을 주는 것이 좋음

class DBModel: NSObject{ // NSObject :: 가장 큰 타입
    // 전부 다 nil 값 허용
    var scode: String?
    var sname: String?
    var sdept: String?
    var sphone: String?
    
    // 생성자 생성
    // Empty constructor
    override init() {
        
    }
    
    init(scode: String, sname: String, sdept: String, sphone: String) {
        self.scode = scode
        self.sname = sname
        self.sdept = sdept
        self.sphone = sphone
    }
}
