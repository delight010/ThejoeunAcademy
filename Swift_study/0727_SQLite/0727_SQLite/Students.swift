//
//  Students.swift
//  0727_SQLite
//
//  Created by TJ on 2021/07/27.
//

import Foundation

class Students{
    var id: Int // nil값이 안들어가도록 설정
    var name: String?
    var dept: String?
    var phone: String?
    
    // 생성자 생성
    init(id: Int, name: String?, dept: String?, phone: String?){
        self.id = id
        self.name = name
        self.dept = dept
        self.phone = phone
    }
    
}
