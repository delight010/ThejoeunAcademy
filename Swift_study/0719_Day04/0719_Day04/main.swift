//
//  main.swift
//  0719_Day04
//
//  Created by TJ on 2021/07/19.
//

import Foundation

// 함수
func interSum(a: Int, b: Int) -> Int{
    return a + b
}

var abSum = interSum(a: 5, b: 8)
print(abSum)


func greet(person: String) -> String {
    let greeting = "Hello, \(person)"
    return greeting
}

print(greet(person: "Anna"))
print(greet(person: "Brian"))

func sayHelloWorld() -> String{
    return "Hello, world!"
}

print(sayHelloWorld())
// argument :: 전달인자(인자), 함수와 메서드의 '입력값(Value)'
// parameter :: 매개변수, 함수와 메서드 입력 '변수명(Variable)'


func buildAddress(_ name: String, address: String, city: String, 우편번호 zipCode: String, country: String? = "USA") -> String{
    return """
        \(name)
        \(address)
        \(city)
        \(zipCode)
        \(country ?? "")
        """
}
// String? = "USA"    :: default 값은 "USA"
// \(country ?? "")   :: nil값이 들어가면 ""가 된다.

print(buildAddress("유비", address: "중국", city: "상하이", 우편번호: "123", country: "China"))
print("-------")
print(buildAddress("장비", address: "중국", city: "북경", 우편번호: "234"))
print("-------")
print(buildAddress("유비", address: "중국", city: "상하이", 우편번호: "123", country: nil))
print("-------")
// nil에 해당하는 파라미터는 출력 X



// 가변 매개변수
// String...   :: 여러 개의 매개변수가 들어갈 수 있음
func sayHelloFriends(me: String, friend: String...) -> String{
    return "Hello \(friend)! I'm \(me)."
}

print(sayHelloFriends(me: "초선", friend: "손견", "손책", "장양"))


// 복수의 값을 반환하는 함수(Tuple을 이용)
func getCountry() -> (dialCode: Int, isoCode: String, name: String){
    let country = (dialCode: 82, isoCode: "KR", name: "Korea")
    return country
}

let ret = getCountry()
print(ret)
print(ret.dialCode)


// 시작 숫자부터 끝 숫자까지의 합계를 구하는 함수
// 1) for문
func addRange(start: Int, end: Int) -> String{
    var sumResult = 0
    for i in start...end{
        sumResult += i
    }
    return "\(start)부터 \(end)까지의 합은 \(sumResult)입니다."
}

// 2) while문
func addRange2(start: Int, end: Int) -> String{
    var startNum = start
    var sumResult = 0
    while startNum <= end{
        sumResult += startNum
        startNum += 1
    }
    
    return "\(start)부터 \(end)까지의 합은 \(sumResult)입니다."
}


//print(addRange(start:1, end:100))
// 1부터 100까지의 합은 5050입니다.
print(addRange(start:1, end:100))
print(addRange2(start:1, end: 100))


// Overloading : 함수의 이름은 중복되도 parameter의 갯수로 구분이 가능
// 도형의 면적과 둘레를 구하는 함수
// 원
func shape(_ r: Double){
    let pi = 3.14
    let area = pi * r * r // 면적
    let border = 2 * pi * r // 둘레
    print("원 : \(area), \(border)")
}

// 직사각형
func shape(_ w: Int, _ h: Int){
    let area = w * h
    let border = (w + h) * 2
    print("직사각형 : \(area), \(border)")
}

// 직각 삼각형
func shape(_ w: Int, _ h: Int, _ n: Int){
    let area = (w + h) / 2
    let border = w + h + n
    print("직각 삼각형 : \(area), \(border)")
}

shape(5)
shape(5, 6)
shape(5, 6, 7)


/*
 Class 1개 = 화면 1개
 Class : 전통적인 OOP 관점에서의 클래스
 - 단일 상속
 - property
 - constructor
 - method
 - 참조 타입 선언(Call by reference)
 
 Struct
 - 상속 불가능
 - property
 - constructor
 - method
 - 값 타입 선언(Call by value)
 
 */

// Class와 Struct의 비교
struct ValueType {
    var property = 1
}

class ReferenceType{
    var property = 1
}


// Struct 생성자 선언
// let firstStructInstance: ValueType = ValueType()
let firstStructInstance = ValueType()
var secondStructInstance = firstStructInstance
secondStructInstance.property = 2

print("Struct first : \(firstStructInstance.property)") // 1
print("Struct second : \(secondStructInstance.property)") // 2


// Class 생성자 선언
//let firstClassInstance: ReferenceType = ReferenceType()
let firstClassInstance = ReferenceType()
var secondClassInstance = firstClassInstance
secondClassInstance.property = 2

print("Class first : \(firstClassInstance.property)") // 2
print("Class Second : \(secondClassInstance.property)") //2


