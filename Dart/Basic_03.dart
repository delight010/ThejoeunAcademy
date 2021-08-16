void main() {
  // 배열의 선언
  List threeKingdoms = [];

  // 데이터 추가
  threeKingdoms.add("위");
  threeKingdoms.add("촉");
  threeKingdoms.add("오");

  print(threeKingdoms); // [위, 촉, 오]

  // 데이터의 변경
  threeKingdoms[0] = "We";
  print(threeKingdoms); // [We, 촉, 오]

  // 데이터의 삭제
  threeKingdoms.remove("We"); // 값이 일치하는 데이터
  print(threeKingdoms); // [촉, 오]

  threeKingdoms.removeAt(0); // 0번째 데이터
  print(threeKingdoms); // [오]
  print(threeKingdoms.length); // 1

  threeKingdoms.add(1);
  threeKingdoms.add(2);
  print(threeKingdoms); // [오, 1, 2]

  // 배열의 자료형 설정
  List<String> threeKingdoms2 = [];
  threeKingdoms2.add("위");
  threeKingdoms2.add("촉");

  List<String> threeKingdoms3 = ['위', '촉', '오'];
  print(threeKingdoms3);

  // Dictionary
  Map<String, int> fruitPrice = {
    'apple': 1000,
    'grape': 2000,
    'watermelon': 3000
  };

  print(fruitPrice['apple']); // 1000

  // Optional : Null Safety
  int num1 = 10;

  int? num2 = null;

  // num2가 null 이면 8을 대입
  num2 ??= 8;
  print(num2); // 8

  // for in 문이 사용
  List<int> list1 = [1, 3, 5, 7, 9];
  int sum = 0;
  for (int i in list1) {
    sum += i;
  }

  print("합계 : $sum"); // 25
}
