//
//  EditDelegate.swift
//  0722_Navigation
//
//  Created by Seong A Oh on 2021/07/22.
//
// Protocol : Java의 Interface

protocol EditDelegate {
    // 같은 기능의 프로토콜 내용을
    // _ controller: 만 변경하여 사용할 수 있다.
    func didMessageEditDone(_ controller: EditViewController, message: String)
    func didImageOnOffDone(_ controller: EditViewController, isOn: Bool)
}
