import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.amberAccent, // background color 변경
      appBar: AppBar(
        title: Text("Image Test"),
      ),
      body: Center(
        child: Image.asset(
          // 이미지 출력 및 사이즈 설정
          'images/smile.png',
          width: 200.0,
          height: 200.0,
        ),
      ),
    );
  }
}
