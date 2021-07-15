//
//  main.swift
//  0715_Day02
//
//  Created by TJ on 2021/07/15.
//

import Foundation

var str1: String

str1 = "Apple"
str1 = "Google"
//str1 = nil (var str1: String에는 nil 값이 들어갈 수 없음)
print(str1)

var str2: String?
str2 = "Apple"
str2 = "Google"
str2 = "123"
//str2 = nil (nil값이 들어갈 수 있음)
//print(str2!) // unwrapping

var int1: Int = Int(str2!)!
//str2를 optional로 변환 한 후 다시 또 특정 타입으로 변환

print(int1 + 10)


// 비교 연산자
print(1 == 1)

// Tuple에서의 비교 연산
print((1, "zebra") < (2, "apple"))
// 첫번째 1 < 2만 비교하기 때문에 true

print((3, "apple") < (3, "bird"))
// 3<3이 같으므로 "apple" < "bird"를 비교하기 때문에 true


// 삼항 조건 연산자
let contentHeight = 40
let hasHeader = true

let rowHeight = contentHeight + (hasHeader ? 50 : 20)
// text?.empty -> 삼항 연산자
print(rowHeight) // 40+50


// 범위 연산자
// 닫힌 범위 연산자
for i in 1...10{
    print(i)
}


var sum: Int = 0
for i in 1...10{ // 슬라이싱, 파이썬으로는 1:10
    sum += i
}

print("1~10의 합계는 \(sum) 입니다. ")

for i in 1...9{
    print("5 X \(i) = \(i*5)")
}

for i in 1..<10{ // 배열에 많이 쓰임
    print("5 X \(i) = \(i*5)")
}

let names = ["Anna", "Alex", "Brian", "jack"]

for i in 0..<names.count{
    print("Person \(i+1) is called \(names[i])")
}

// Optional
// : 값이 있을 수도 있고, 없을 수도 있다
// : nil 값을 포함할 수도 있고, 포함 안할 수도 있다.

var constantNum: Int? = 100
constantNum = nil
var constantNum2: Int! = 100
//constantNum2 = nil
print(constantNum2) // Optional(100)
print(constantNum2!)
print(constantNum2 + 10) // 110




// Optional Unwrapping
var myName: String? = nil // == 'var myName: String! = nil'
print(myName) // nil
print(myName as Any) // nil


// Optional Binding
if let name: String = myName{ // 현재 myName != nil 이라면
    print(name)
}else{ // 현재 myName = nil 이라면
    print("myName is nil")
}



var myName2: String? = "James"
var yourName2: String? = nil

if let name = myName2, let friend = yourName2{
    print("\(name) and \(friend)")
} // else는 생략


// Force Unwrapping
print(myName2) // Optional("James")
print(myName2!) // James

// nil 값을 출력
myName2 = nil
print(myName2 as Any) // nil

// Collection : 여러 값들을 묶어서 하나의 변수로 사용
/*
 Array : 순서가 있는 리스트 컬렉션(가장 많이 쓰임)
 Dictionary : Key와 Value의 쌍으로 이루어진 컬렉션
 Set : 순서가 없고 멤버가 유일한 컬렉션, 집합연산
 */


// Array
// 빈 Array 생성
// var intVariable: Array<Int> = Array<Int>()
// var intVariable: [Int] = [Int]()
var intVariable: [Int] = [] // 가장 많이 쓰임
intVariable.append(1)
intVariable.append(10)
intVariable.append(100)
intVariable.append(1000)

print(intVariable) // [1, 10, 100, 1000]

// 배열에 특정값이 있는 지 확인
print(intVariable.contains(100)) // true
print(intVariable.contains(90)) // false

// 배열의 특정 범위의 값을 확인
print(intVariable[0]) // 1
print(intVariable[0...2]) // [1, 10, 100]
print(intVariable[0...2][0]) // 1

// 배열의 특정 번지의 Data 삭제
intVariable.remove(at: 0)
print(intVariable) // [10, 100, 1000]

// 배열의 맨 끝의 Data 삭제
intVariable.removeLast()
print(intVariable) // [10, 100]

// 배열의 모든 Data 삭제
intVariable.removeAll()
print(intVariable) // []

// 배열의 초기화
intVariable = [] // 초기화

// 기본값으로 배열 생성하기
// 0.0을 3번 반복
var threeDouble = Array(repeating: 0.0, count: 3)
print(threeDouble) // [0.0, 0.0, 0.0]

var anotherDouble = Array(repeating: 2.5, count: 3)
print(anotherDouble) // [2.5, 2.5, 2.5]

var sixDouble = threeDouble + anotherDouble
print(sixDouble) // [0.0, 0.0, 0.0, 2.5, 2.5, 2.5]

// 배열의 타입 띄우기
let intVarriable2 = [1,2,3]
print(type(of: intVarriable2)) // Array<Int>
// intVarriable2.append(4) :: 상수라 추가할 수 없음

// 배열의 데이터 갯수 세기
var shoppingList = ["Eggs", "Milk"]
print(type(of: shoppingList)) // Array<String>
print(shoppingList.count) // 2
if shoppingList.isEmpty{
    print("shoppingList는 비어있습니다")
}

shoppingList += ["Baking Power"]
shoppingList += ["Chocolate", "Cheese", "Butter"]
print(shoppingList)
// ["Eggs", "Milk", "Baking Power", "Chocolate", " Cheese", "Butter"]


// 배열의 특정 위치 데이터 변경 및 제거
//shoppingList[0...3] = ["Banana"]
//print(shoppingList) // ["Banana", " Cheese", "Butter"]

shoppingList[0...3] = ["Banana1", "Banana2", "Banana3", "Banana4", "Banana5"]
print(shoppingList)
// ["Banana1", "Banana2", "Banana3", "Banana4", "Banana5", " Cheese", "Butter"]

shoppingList.insert("Apple", at: 0)
print(shoppingList)
// ["Apple", "Banana1", "Banana2", "Banana3", "Banana4", "Banana5", " Cheese", "Butter"]



// 배열의 값과 인덱스가 필요한 경우
for (index, value) in shoppingList.enumerated(){
    print("Item \(index+1): \(value)")
}

print(shoppingList.enumerated())
// EnumeratedSequence<Array<String>>(_base: ["Apple", "Banana1", "Banana2", "Banana3", "Banana4", "Banana5", "Cheese", "Butter"])


var tot = 0.0
print(sixDouble) // [0.0, 0.0, 0.0, 2.5, 2.5, 2.5]
for i in sixDouble{
    tot += i
}
print(tot) // 7.5



// 최대값 찾기
print(sixDouble.max()) // Optional(2.5)
print(sixDouble.max()!) // 2.5

// 최소값 찾기
print(sixDouble.min()) // Optional(0.0)
print(sixDouble.min()!) // 0.0







