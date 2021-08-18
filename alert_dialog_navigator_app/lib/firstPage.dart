import 'package:flutter/material.dart';

class FirstPage extends StatelessWidget {
  const FirstPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Alert and push'),
        centerTitle: false,
      ),
      body: Center(
        child: GestureDetector(
            onTap: () {
              _showDialog(context); // _(언더바)로 시작하면 private
            },
            child: Text('Move the 2nd page.')),
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
          title: Text("Page 이동"),
          content: Text('아래의 버튼을 누르면 페이지 이동을 합니다.'),
          actions: [
            // alert에 쓸 수 있는 버튼 등 설정
            ElevatedButton(
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(Colors.blue),
              ),
              onPressed: () {
                Navigator.of(context).pop(); // alert를 제거
                Navigator.pushNamed(context, '/SecondPage'); // 페이지 이동
              },
              child: Text('Page 이동'),
            ),
          ],
        );
      });
}
