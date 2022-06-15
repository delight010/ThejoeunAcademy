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
      appBar: AppBar(
        title: Text("Image fitting"),
      ),
      body: Center(
        child: Column(
          children: [
            Image.asset(
              'images/turtle.gif',
              width: 50,
              height: 100,
            ),
            Image.asset(
              'images/turtle.gif',
              width: 50,
              height: 100,
              fit: BoxFit.fill, // 50*100 사이즈로 꽉 채워서 맞춤(강제로)
            ),
            Image.asset(
              'images/turtle.gif',
              width: 50,
              height: 100,
              fit: BoxFit.contain, // **그림의 비율에 가장 잘 맞춰줌(많이쓰임)**
            ),
            Image.asset(
              'images/turtle.gif',
              width: 50,
              height: 100,
              fit: BoxFit.cover, // 비율을 유지하지만 이미지가 짤림
            ),
            Image.asset(
              'images/turtle.gif',
              width: 50,
              height: 100,
              fit: BoxFit.fitWidth, // 가로폭에 맞추어 출력
            ),
            Image.asset(
              'images/turtle.gif',
              width: 50,
              height: 100,
              fit: BoxFit.scaleDown, // 전체이미지가 나오도록 맞춤
            ),
          ],
        ),
      ),
    );
  }
}
