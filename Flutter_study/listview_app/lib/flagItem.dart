
class Flag{
  // 데이터 변수
  late String imagePath;
  late String country;
  
  // 생성자 생성
  Flag(
    {
      // required : 반드시 들어가야함
      required this.country,
      required this.imagePath,
    }
  );
}