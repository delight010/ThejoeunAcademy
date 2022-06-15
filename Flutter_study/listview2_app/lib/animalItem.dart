import 'package:flutter/cupertino.dart';

class Animal{
  // 데이터 변수
  late String imagePath;
  late String animalName;
  late String kind;
  late bool flyExist;
  
  // 생성자 생성
  Animal(
    {
      // required : 반드시 들어가야함
      required this.animalName,
      required this.kind,
      required this.imagePath,
      required this.flyExist
    }
  );
}