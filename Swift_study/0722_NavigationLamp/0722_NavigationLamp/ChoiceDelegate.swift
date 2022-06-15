//
//  ChoiceDelegate.swift
//  0722_NavigationLamp
//
//  Created by Seong A Oh on 2021/07/22.
//
// Protocol : Java의 Interface

protocol ChoiceDelegate {
    // 같은 기능의 프로토콜 내용을
    // _ controller: 만 변경하여 사용할 수 있다.
    func didLampOnOffDone(_ controller: ChoiceViewController, isOn: Bool, isRed: Bool)
}

// protocol   [프로토콜이름] {
// func [메소드명](_ controller: [받아올 컨트롤러명], 파라미터명: 자료형)
// }

