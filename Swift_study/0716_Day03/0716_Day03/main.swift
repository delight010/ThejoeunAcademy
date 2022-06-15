//
//  main.swift
//  0716_Day03
//
//  Created by TJ on 2021/07/16.
//

import Foundation

// Dictionary
// Key와 Value로 구성됨

// var scoreDictionary: Dictionary<String, Int> = [String: Int]()
var scoreDictionary: [String: Int] = [:] // 많이 쓰이는 형태
// scoreDictionary["유비"] = 100
// print(scoreDictionary) // ["유비": 100]

scoreDictionary["유비"] = 100
scoreDictionary["관우"] = 90
scoreDictionary["장비"] = 80
print(scoreDictionary) // ["장비": 80, "유비": 100, "관우": 90]

// 초기값을 가지는 Dictionary
let intializedDictionary: [String: String] = ["name":"James", "gender":"male"]
print(intializedDictionary)



// Set
// Set은 집한연산에 사용되고, 중복데이터를 적용하지 않는다.
// 주로 중복데이터 체크 시 사용

let oddDigits: Set = [1,3,5,7,9,9,9,9,9,9,9,9]
print(oddDigits) // [1, 3, 7, 5, 9]

let evenDigits: Set = [0,2,4,6,8]
let singleDigitPrimeNumbers: Set = [2,3,5,7]

// 합집합
print(oddDigits.union(evenDigits).sorted())
// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// .sorted(오름차순으로 정렬)


// 교집합
print(oddDigits.intersection(evenDigits).sorted())
// []


// 차집합
print(oddDigits.subtracting(singleDigitPrimeNumbers).sorted())
// [1, 9]

// Set의 동등 비교
let houseAnimals: Set = ["dog", "cat", "apple"]
let farmAnimals: Set = ["cow", "chicken", "sheep", "dog", "cat"]
let cityAnimals: Set = ["duck", "rabbit"]

// 메소드들
// houseAnimals에 farmAnimal가 포함되어 있는가?
print(houseAnimals.isSubset(of: farmAnimals)) // false
// houseAnimals에 farmAnimals가 포함되어 있는가? : isSubset의 반대
print(farmAnimals.isSuperset(of: houseAnimals)) // false
// farmAnimals와 cityAnimals에 교집합되어 있는 요소가 있다면 -> false
// 없다면 -> true
print(farmAnimals.isDisjoint(with: cityAnimals)) // true

print("========================")

// If
var isCar = true
var isNew = true

if isCar, isNew{
    print("New Car")
}


isNew = false
if isCar, isNew{ // if isCar && isNew 와 같음
    print("New Car")
}else{
    print("Old Car")
}

print("========================")


// Switch 조건문
// Before Switch

let personAge = 14
if personAge < 1 {
    print("baby")
}else if personAge < 3{
    print("toddler")
}else if personAge < 5 {
    print("preschooler")
}else if personAge < 13 {
    print("gradeschooler")
}else if personAge < 18 {
    print("teen")
}else{
    print("adult")
}


// After using Switch statement
// 범위를 설정 가능
switch personAge{
case 0..<1:
    print("baby")
case 1..<3:
    print("toddler")
case 3..<5:
    print("preschooler")
case 5..<13:
    print("gradeschooler")
case 13..<18:
    print("teen")
default:
    print("adult")
}

let someInteger = 123456

switch someInteger{
case 0:
    print("zero")
case 1..<100:
    print("1~99")
case 101...Int.max: // 101 부터 Int자료형이 표현할 수 있는 최대치까지
    print("over 100")
default:
    print("unknown")
}

print(Int.max) // 9223372036854775807
print(Double.maximum(10.0, 20.0)) // 최대값 찾는 메소드

let aCharacter: Character = "a"

switch aCharacter{
case "a", "A":
    print("The letter A")
default:
    print("Not the leter A")
}


// 국어, 영어, 수학 점수로 총점 평균을 구하고 등급을 정하기
let name = "유비"
let kor = 91
let eng = 97
let math = 95

var tot = 0
var avg: Double = 0

tot = kor + eng + math
avg = Double(tot) / 3

// 점수 등급 출력 - 1
var grade: String

// if문을 이용한 등급 출력
if avg < 0{
    grade = "잘못된 점수 입니다."
    print(grade)
}else if avg < 60{
    grade = "F학점입니다."
    print(grade)
}else if avg < 70{
    grade = "D학점입니다."
    print(grade)
}else if avg < 80{
    grade = "C학점입니다."
    print(grade)
}else if avg < 90 {
    grade = "B학점입니다."
    print(grade)
}else if avg <= 100 {
    grade = "A학점입니다."
    print(grade)
}else{
    grade = "잘못된 점수입니다."
    print(grade)
}


// switch case문을 이용한 등급 출력
switch avg{
case 0..<60: // 0~59
    grade = "F학점입니다."
    print(grade)
case 60..<70: // 60~69
    grade = "D학점입니다."
    print(grade)
case 70..<80:
    grade = "C학점입니다."
    print(grade)
case 80..<90:
    grade = "B학점입니다."
    print(grade)
case 90..<101: // case 90...100: 과 같음
    grade = "A학점입니다."
    print(grade)
default:
    grade = "잘못된 점수입니다."
    print(grade)
}


// 삼항연산자 등급 출력
grade = avg >= 90 ? "수" :
    avg >= 80 ? "우" :
    avg >= 70 ? "미" :
    avg >= 60 ? "양" : "가"
print(grade)

// 배열과 반복문
var score = [ 90,  80 ,  70 , 60,   0 ]
var level = ["수", "우", "미", "양", "가"]

for i in 0..<score.count{
    if avg >= Double(score[i]){
        grade = level[i] // grade = "수"
        print("등급은 \(grade)입니다.")
        break
    }
}
    

// 반복문
let names = ["Anna", "Alex", "Brian", "jack"]

for name in names{
    print(name)
}


// dictionary 반복문
let numberOfLegs = ["Spider":8, "Ant":6, "Cat":4]

// dictionary는 순서가 없다.
for (animalName, LegCount) in numberOfLegs{
    print("\(animalName) have \(LegCount) legs")
}


let seq1 = 1...5
for i in seq1{
    print("\(i) * 5 = \(i*5)")
}

// 역순으로 띄우기
for i in seq1.reversed(){
    print("\(i) * 5 = \(i*5)")
}


// for ~ in ~ stride
let minutes = 60
let hourInterval = 5
for tickMark in stride(from: 0, to: minutes, by: hourInterval){
    print(tickMark) // 60이 안나옴
}

print("=====================")

for tickMark in stride(from: 0, through: minutes, by: hourInterval){
    print(tickMark) // 60이 나옴
}

print("=========역순으로==========")

for tickMark in stride(from: 0, through: minutes, by: hourInterval).reversed(){
    print(tickMark) // 60이 나옴
}


// while
// 1 ~ 100까지의 합
var startIndex = 0
var endIndex = 100
var sum = 0

while startIndex <= endIndex{
    sum += startIndex
    startIndex += 1
}
print(sum)


// 1부터 100까지의 짝수의 합을 구하시오 (단 if문을 사용금지)
var startIndex2 = 0
var endIndex2 = 100
var evenSum = 0
while startIndex2 <= endIndex2{
    evenSum += startIndex2
    startIndex2 += 2
}
print(evenSum)



// 입력한 한 자릿수 정수의 합을 구하는 프로그램을 작성하라
// Enter an integer(0 ~ 9) : 12345678
// Sum of digits = 36
// var inputValueSum:Int = 0
// print("Enter an integer(0 ~ 9)",terminator:" : ")
// var read = readLine()
// var inputValue: Int = Int(read!)!
// while inputValue != 0{
//    inputValueSum += inputValue % 10
//    inputValue = inputValue/10
// }
//
// print("Sum of digits = \(inputValueSum)")


var repNum = 0
var remainder = 0
var sumNo = 0

print("Enter an integer(0 ~ 9)",terminator:" : ")
var inpNum = Int(readLine()!)

// if let의 사용
if let _: Int = inpNum{ // _는 변수 생략
    repNum = inpNum! // optional 풀기
    while repNum != 0{
        remainder = repNum % 10
        sumNo += remainder
        repNum /= 10
    }
    print ("Sum of digits : \(sumNo)")
}else{
    print("Input value is wrong!")
}






