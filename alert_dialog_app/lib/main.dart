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

/*
context : Widget에 대한 meta정보나 widget tree의 위치를 나타냄.
*/

class MyHomePage extends StatelessWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Alert Dialog with Gesture"),
      ),
      body: Center(
        child: GestureDetector(
          onTap: () {
            _showDialog(context); // _(언더바)로 시작하면 private
          },
          child: Text('Hello World!'),
        ),
      ),
    );
  }
}

void _showDialog(BuildContext context) {
  showDialog(
    context: context,
    // context를 받아와 builder 생성
    builder: (BuildContext context) {
      return AlertDialog(
        // AlertDialog 생성
        title: Text("Alert Title"),
        content: Text('Hello World!!!'),
        actions: [
          // alert에 쓸 수 있는 버튼 등 설정
          ElevatedButton(
            style: ButtonStyle(
              backgroundColor: MaterialStateProperty.all(Colors.blue),
            ),
            onPressed: () {
              Navigator.of(context).pop(); // Alert를 제거
            },
            child: Text('종료'),
          ),
        ],
      );
    },
  );
}
