//
//  DBModel.swift
//  0727_ServerJSON01
//
//  Created by TJ on 2021/07/27.
//

import Foundation

// Json 사용 시 class에 type을 주는 것이 좋음

class DBModel: NSObject{
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
