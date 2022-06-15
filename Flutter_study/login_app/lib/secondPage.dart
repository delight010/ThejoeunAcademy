import 'package:flutter/material.dart';

class SecondPage extends StatefulWidget {
  final String id; // 받아오는 데이터 변수
  const SecondPage({Key? key, required this.id}) : super(key: key);

  @override
  _SecondPageState createState() => _SecondPageState();
}

class _SecondPageState extends State<SecondPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.id.toString() + "님! 환영 합니다."),
      ),
      body: Center(
        child: Image.asset('images/picachu1.png'),
      ),
    );
  }
}
