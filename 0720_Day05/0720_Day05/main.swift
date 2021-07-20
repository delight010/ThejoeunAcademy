//
//  main.swift
//  0720_Day05
//
//  Created by Seong A Oh on 2021/07/20.
//

import Foundation

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

// -------
// 구조체 : Structure
// : Swift에서 Data Type을 정의

// Structure 생성
struct Sample {
    var sampleProperty: Int = 10 // 가변 property (변수)
    let fixedSampleProperty: Int = 100 // 불변 property
    static var typeProperty: Int = 1000 // 타입 property
    
//    // init : 생성자
//    init(){
//
//    }
    
    func instanceMethod(){
        print("instance method")
    }
    
    static func typeMethod(){
        print("type method")
    }
}

// Structure 사용 (유저 ID, PW를 보관할 때 사용)
//var samp: Sample = Sample()
var samp = Sample()
print(samp.sampleProperty) // 10
samp.sampleProperty = 100
print(samp.sampleProperty) // 100

var samp1 = Sample()
print(samp1.sampleProperty) // 10




// Type Property
Sample.typeMethod() // type method
print(Sample.typeProperty) // 1000
// Sample.instanceMethod(<#T##self: Sample##Sample#>)

// 학생 구조체
struct Student{
    var name: String = "unknown"
    var `class`: String = "Swift" // `` 사이로 하면 예약어도 변수명으로 사용 가능
    
    static func selfIntroduce(){
        print("학생 타입 입니다.")
    }
    
    func selfIntroduce(){
//        print("저는 \(`class`)반 \(name)입니다.")
        print("저는 \(self.class)반 \(name)입니다.")
    }
    
    // static func과 func는 다른 함수로 구별됨.
}

Student.selfIntroduce() // 학생 타입 입니다.

var student: Student = Student()
student.name = "James"
student.class = "스위프트"
student.selfIntroduce()

let cathy: Student = Student()
//cathy.name = "Cathy" // 사용 X
cathy.selfIntroduce()



// --------------------------

// 학생 구조체
class Student1{
    var name: String = "unknown"
    var `class`: String = "Swift" // `` 사이로 하면 예약어도 변수명으로 사용 가능
    
    static func selfIntroduce(){ // instance에는 못씀
        print("학생 타입 입니다.")
    }
    
    func selfIntroduce(){
//        print("저는 \(`class`)반 \(name)입니다.")
        print("저는 \(self.class)반 \(name)입니다.")
    }
    
    // static func과 func는 다른 함수로 구별됨.
}

Student1.selfIntroduce()
var student1: Student1 = Student1()


//---------------------------
class Shape{
    // 원
    func input(_ r: Double){
        let pi = 3.14
        let area = pi * r * r // 면적
        let border = 2 * pi * r // 둘레
        print("원의 면적은 \(area)이고, 둘레는 \(border)입니다.")
    }
    
    // 직사각형
    func input(_ w: Int, _ h: Int) {
        let area = w * h
        let border = (w + h) * 2
        print("직사각형의 면적은 \(area)이고, 둘레는 \(border)입니다.")
    }
    
    // 직각삼각형
    func input(_ w: Int, _ h: Int, _ n: Int){
        let area = (w * h) / 2
        let border = w + h + n
        print("직각 삼각형의 면적은 \(area)이고, 둘레는 \(border)입니다.")
    }
}

let sh1: Shape = Shape()
let sh2: Shape = Shape()
let sh3: Shape = Shape()

sh1.input(5) // 원의 면적과 둘레 구하기
sh2.input(5, 6) // 직사각형의 면적과 둘레 구하기
sh3.input(5, 6, 8) // 직각삼각형의 면적과 둘레 구하기


// 생성자
class Shape1{
    var area = 0.0
    var shape = ""
    let pi  = 3.14157
    
    // 생성자
    init() {
        print("계산 시작")
    }
    
    init(radius: Double){
        area = radius * radius * pi
        shape = "원"
        calc()
    }
    
    init(width: Int, height: Int){
        area = Double(width * height)
        shape = "직사각형"
        calc()
    }
    
    init(width: Int, height: Int, n: Int){
        area = Double(width * height / 2)
        shape = "직각 삼각형"
        calc()
    }
    
    //---
    
    func input(r: Double){
        area = r * r * pi
        shape = "원"
        calc()
    }
    
    func input(w: Int, h: Int) {
        area = Double(w * h)
        shape = "직사각형"
        calc()
    }
    
    func input(w: Int, h: Int, n: Int) {
        area = Double(w * h / 2)
        shape = "직각 삼각형"
        calc()
    }
    
    func calc(){
        print("\(shape)의 면적은 \(Int(area))입니다.")
    }
    
}


let sh4: Shape1 = Shape1() // 계산 시작
sh4.input(r: 5.0)

let sh5: Shape1 = Shape1(radius: 5.0)

//----

let shwh: Shape1 = Shape1()
shwh.input(w: 3, h: 4)

let shwh2: Shape1 = Shape1(width: 3, height: 4)

//----

let shwhn: Shape1 = Shape1()
shwhn.input(w: 3, h: 4, n: 5)

let shwhn2: Shape1 = Shape1(width: 3, height: 4, n: 5)


//-----------------------------------------------------

// Extension ** 중요
// Swift5부터 쓰이게 됨. 상속으로 쓰는 것보다 메모리를 적게 쓸 수 있다.
// 구조체, 클래스, 프로토콜 타입에 새로운 기능을 추가할 수 있는 기능
// 기존에 존재하는 기능은 재정의 할 수 없다. (기능 추가만 가능)

extension Int{
    var isEven: Bool{ // 짝수 확인
        return self % 2 == 0 // self : 들어온 값
        // 나머지가 0이면 true, 아니면 false
    }
    
    var isOdd: Bool{ // 홀수 확인
        return self % 2 == 1
    }
}

print(1.isEven) // false



// Closure
// 파이썬의 Lamda함수와 같음
// AlertMessage에 사용

// 함수
func sumFunction(a: Int, b: Int) -> Int{
    return a + b
}

var sumResult = sumFunction(a: 10, b: 20)
print(sumResult)

// Closure : in이 들어간다.(기억할 것)
var sumClosure: (Int, Int) -> Int = {(a: Int, b: Int) -> Int in
    return a + b
}

sumResult = sumClosure(10,20)
print(sumResult)



// Random
print(Int.random(in: 1..<10))
print(Int.random(in: 1..<10))

print("----------")

func genNum() -> String{
    return String(Int.random(in: 1..<10))
}

print(genNum())
print(genNum())
print(genNum())

